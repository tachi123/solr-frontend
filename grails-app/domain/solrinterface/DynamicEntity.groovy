package solrinterface

public class DynamicEntity {

    def dynamicProperties = [:]
    //setter
    def propertyMissing(String name, value){ dynamicProperties[name]=value}
    //getter
    def propertyMissing(String name) {dynamicProperties=[name]}

    static constraints = {
    }
}
