// Place your Spring DSL code here
beans = {

//,"file:grails-app/i18n/messages", "classpath:grails-app/i18n/buscador-frontend", "WEB-INF/grails-app/i18n/messages"
//
    messageSource(solrinterface.DatabaseMessageSource) {
        messageBundleMessageSource = ref("messageBundleMessageSource")
    }
    messageBundleMessageSource(org.springframework.context.support.ReloadableResourceBundleMessageSource) {
        basenames = [ "file:grails-app/i18n/messages", "WEB-INF/grails-app/i18n/messages"]
    }
 //   messageBundleMessageSource(org.grails.spring.context.support.PluginAwareResourceBundleMessageSource) {
 //       basenames = "WEB-INF/grails-app/i18n/messages"
  //  }
}
