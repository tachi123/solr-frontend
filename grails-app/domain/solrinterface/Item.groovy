package solrinterface

import org.apache.solr.client.solrj.beans.Field;

public class Item{

    static mapWith = "none"

    @Field Integer Identificador

    def dynamicProperties = [:]
    //setter
    void setProperty(String name, value){
       if(name.equals("Identificador")) this.Identificador = value
        else {
           dynamicProperties.put(name,value)
       }
    }
    //getter
    def getProperty(String name){
        if(name == "Identificador")
            return this.Identificador
        else
            return this.dynamicProperties[name]
    }

    static constraints = {
    }
}
