package solrinterface

class UrlMappings {

/*    static excludes = [
            '/css/*',
            '/fonts/*',
            '/static/*',
            '/asset-manifest.json',
            '/favicon.ico'
    ]*/

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
