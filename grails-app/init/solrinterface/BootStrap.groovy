package solrinterface

import grails.converters.JSON
import grails.core.GrailsApplication
import javafx.beans.property.Property

class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->

        //Cargamos la tabla message con los datos correspondientes a los archivos declarados en el archivo config
        if(grailsApplication.config.grails.i18n.basenames != null && grailsApplication.config.grails.i18n.basenames.length() >0)
        for(filePropertiesI18n in (JSON.parse(grailsApplication.config.grails.i18n.basenames))){
            def fileBasename = new File(filePropertiesI18n.value).getText().replaceAll("\r","")
            def Locale locale = Locale.getDefault()
            if(filePropertiesI18n.language.length() > 0)
                locale = Locale.forLanguageTag(filePropertiesI18n.language)
            for(mapLine in fileBasename.split("\n")){
                if(mapLine.length()>0 && !mapLine.substring(0,1).equals("//")){
                    Message mesgToInsert = new Message()
                    mesgToInsert.setLocaleCodeText(locale,mapLine.split("=")[0],mapLine.split("=")[1])
                    mesgToInsert.save(flush: true)
                }
            }
        }

    }
    def destroy = {
    }
}
