package solrinterface

class EstaticaController {

    def index() { }

    def estadisticas() {
        def url = grailsApplication.config.estatica.estadistica.urlTableau
        respond view: 'estadisticas', url, model: [url: url, title: 'Estad&iacute;sticas']
    }

    def renaorg(params) {
        def url = grailsApplication.config.apache.view.urlBase +'renaorg/'+params.id
        respond view: 'renaorg',url, model: [url: url, title: 'Centros']
    }

}
