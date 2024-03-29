package solrinterface

import grails.converters.JSON
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.common.SolrDocument

import solrinterface.Item

class SearchController {

    private static String solrUrl
    private static SolrClient solrCore
    private static String solrFieldList
    private static JSON solrSorts
    private static String solrQueryFieldsDefault
    private static String solrFilterQueries
/*
    static allowedMethods = [searchRegistros: "GET"]*/

    public SearchController() throws MalformedURLException, IOException, SolrServerException {
        solrUrl = grailsApplication.config.solr.url
        solrSorts = JSON.parse(grailsApplication.config.solr.sorts)
        solrQueryFieldsDefault = grailsApplication.config.solr.queryFieldsDefault
        solrFieldList = grailsApplication.config.solr.fieldList
        solrFilterQueries = grailsApplication.config.solr.filterQueries
        solrCore = new HttpSolrClient.Builder(solrUrl).build()
    }

    def index() {}

    def results(Integer max) {

        String view

        if (params.q == null || params.q == "null")
            view = 'search';
        else {
                view = 'searchTypeSelected'

                SolrQuery query = buildQuery(params)

                QueryResponse rsp = solrCore.query(query);
            //  No pude hacerlo funcionar para DynamicProperties
            //  final List<Item> items = rsp.getBeans(Item.class);
            //  Entonces procedo a agregar uno a uno
                final SolrDocumentList documents = rsp.getResults();
                final List<Item> items = convertDocumentsToItems(documents)

                String numFound = documents.getNumFound();
                List<FacetField> facets = rsp.getFacetFields();

                //ESTO ASÍ SACO LOS POSIBLES FIELDQUERIES POR DEFECTO
                for(String fieldQueryDefault in (grailsApplication.config.solr.filterQueries).split('\\|'))
                    query.removeFilterQuery(fieldQueryDefault)

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
    }

    def getNumfound(Integer max) {

        SolrQuery query = buildQuery(params)
        query.setRows(0)
        query.setFields('numFound')

        return solrCore.query(query).getResults().getNumFound();
    }

    def getFacetsForType(Integer max,String facet) {

        SolrQuery query = buildQuery(params)
        query.remove('facet.field')
        query.addFacetField(facet);
        query.setFacetLimit(max)
        query.setRows(0)
        def asdfadsf = solrCore.query(query).getFacetFields().get(0).getValues()
        return asdfadsf;
    }


    def buildQuery(params) {

        String q = params.q != null && params.q.length() > 0 ? params.q : "*"
        Integer start = params.start != null && params.start.size() > 0 ? Integer.parseInt(params.start) : 0
        Integer rows = params.rows != null && params.rows.size() > 0 ? Integer.parseInt(params.rows) : 15
        if (rows >50 ) rows = 50;

        SolrQuery query = new SolrQuery();
        query.setQuery(q);
        query.setFields(solrFieldList)
        query.setRows(rows);
        query.set("defType", "edismax");
        query.setFacetMinCount(2);
        query.setIncludeScore(true);

        if(solrQueryFieldsDefault != null && solrQueryFieldsDefault.length() > 0)
        query.set("qf",solrQueryFieldsDefault);
        if(params.queryField != null && params.queryField.length() > 0)
            query.set("qf",params.queryField);

        if(params.sort != null && params.sort.size() > 0){
            def order = ORDER.asc
            for(elementSort in solrSorts.target)
                if(elementSort.value.equals(params.sort) && elementSort.type.equals("desc")) order = ORDER.desc
            query.setSort(params.sort,order)
        }

        if(params.pageNumber != null && Integer.parseInt(params.pageNumber) > 0)
            start = (Integer.parseInt(params.pageNumber)-1)*rows
        query.setStart(start)

        if (params.fqstring != null && params.fqstring.size() > 0)
            query.setFilterQueries(params.fqstring.split('\\|'))
        for(String fieldQueryDefault in (grailsApplication.config.solr.filterQueries).split('\\|'))
            query.addFilterQuery(fieldQueryDefault)
        if (params.newfq != null && params.newfq.size() > 0 && !params.fqstring.contains(params.newfq))
            query.addFilterQuery(params.newfq)
        if (params.delfq != null && params.delfq.size() > 0)
            query.removeFilterQuery(params.delfq)
        for (String facetAdd : grailsApplication.config.search.facets.enabled.split(","))
            query.addFacetField(facetAdd);

        return query
    }

    def convertDocumentsToItems(SolrDocumentList documents){
        def List<Item> items = []
        for(SolrDocument doc in documents){
            Item itemInstance = new Item()
            for(field in doc)
                itemInstance.setProperty(field.getKey(), field.getValue())
            items.add(itemInstance)
        }
        return items
    }
}


/*    def searchCentros(Integer max) {

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
    }*/