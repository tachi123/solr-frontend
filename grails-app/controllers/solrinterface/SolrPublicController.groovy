package solrinterface

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.common.SolrDocument;

import solrinterface.Item

class SolrPublicController {

    private static String solrUrl
    private static SolrClient solrCore
/*
    static allowedMethods = [searchRegistros: "GET"]*/

    public SolrPublicController() throws MalformedURLException, IOException, SolrServerException {
        solrUrl = grailsApplication.config.solr.link.core
        solrCore = new HttpSolrClient.Builder(solrUrl).build()
    }

    def index() {}

    def search(Integer max) {

        String view

        if (params.type == null || params.type == "null")
            view = 'search'
        else
            view = 'searchTypeSelected'

        SolrQuery query = buildQuery(params)

        QueryResponse rsp = solrCore.query(query);

        final List<Item> items = rsp.getBeans(Item.class);

        final SolrDocumentList documents = rsp.getResults();

        String numFound = documents.getNumFound();

        List<FacetField> facets = rsp.getFacetFields();

        //ESTO ASI SACO EL TYPE DE FACETSELECTED
        query.removeFilterQuery("type:" + params.type)

        render view: view,
                model: [items   : items,
                        facets  : facets,
                        type    : params.type,
                        rows    : query.getRows(),
                        start   : query.getStart(),
                        sort: params.sort,
                        fq      : query.getFilterQueries(),
                        fqstring: query.getFilterQueries() != null ? query.getFilterQueries().join("|") : "",
                        numFound: documents.getNumFound(),
                        typeItem: params.typeItem,
                        q       : query.getQuery().equals("text:*") ? "" : query.getQuery()]
    }

    def searchCentros(Integer max) {

        params.fqstring = 'status:"Validado institucionalmente"'
        params.type = 30

        SolrQuery query = buildQuery(params)

        QueryResponse rsp = solrCore.query(query);

        final List<Item> items = rsp.getBeans(Item.class);

        final SolrDocumentList documents = rsp.getResults();

        String numFound = documents.getNumFound();

        render view: 'searchCentros',
                model: [items   : items,
                        rows    : query.getRows(),
                        start   : query.getStart(),
                        sort: params.sort,
                        numFound: documents.getNumFound(),
                        q       : query.getQuery().equals("text:*") ? "" : query.getQuery()]
    }


    def buildQuery(params) {

        String q = params.q != null && params.q.length() > 0 ? params.q : "*"
        Integer start = params.start != null && params.start.size() > 0 ? Integer.parseInt(params.start) : 0
        Integer rows = params.rows != null && params.rows.size() > 0 ? Integer.parseInt(params.rows) : 15

        SolrQuery query = new SolrQuery();
        query.setQuery(q);

        if(params.sort != null && params.sort.size() > 0)
            if(params.sort == "name")
                query.setSort(params.sort+" ",ORDER.asc)
            else
                query.setSort(params.sort+" ",ORDER.desc)

        if(params.pageNumber != null && Integer.parseInt(params.pageNumber) > 0)
            start = (Integer.parseInt(params.pageNumber)-1)*rows

        query.setStart(start)

        query.setFacet(true);
        if (params.type == null || params.type == "null") {
            query.setRows(0);
            query.addFacetField("type");
        } else {
            query.setRows(rows);
            if (params.fqstring != null && params.fqstring.size() > 0)
                query.setFilterQueries(params.fqstring.split('\\|'))
            query.addFilterQuery("type:" + params.type)
            if (params.newfq != null && params.newfq.size() > 0 && !params.fqstring.contains(params.newfq))
                query.addFilterQuery(params.newfq)
            if (params.delfq != null && params.delfq.size() > 0)
                query.removeFilterQuery(params.delfq)
            for (String facetAdd : grailsApplication.config.search.facets.enabled.split(","))
                query.addFacetField(facetAdd);
        }

        query.set("defType", "edismax");
        query.setFacetMinCount(2);
        query.setIncludeScore(true);

        //query.removeFilterQuery("type:" + params.type)

        return query
    }
}