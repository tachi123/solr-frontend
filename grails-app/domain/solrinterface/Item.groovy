package solrinterface

import org.apache.solr.client.solrj.beans.Field;

public class Item {

    static mapWith = "none"

    @Field String id
    @Field String status
    @Field String name
    @Field String surname
    @Field String django_ct
    @Field String django_id
    @Field String text
    @Field List<String> affiliations
    @Field List<String> affiliations_exact
    @Field String type
    @Field String type_exact

    @Field String bold_org_exact
    @Field List<String> taxon_exact

    @Field String marker_exact

    @Field String subdivision_exact
    @Field String country_exact

    static constraints = {
    }
}
