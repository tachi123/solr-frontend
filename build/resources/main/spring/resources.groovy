// Place your Spring DSL code here
beans = {
    messageSource(solrinterface.DatabaseMessageSource) {
        messageBundleMessageSource = ref("messageBundleMessageSource")
    }
    messageBundleMessageSource(org.springframework.context.support.ReloadableResourceBundleMessageSource) {
        basenames = [ "file:grails-app/i18n/messages", "WEB-INF/grails-app/i18n/messages"]
    }
}
