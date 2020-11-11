//default_config = "/data/${appName}/config/${appName}-application.properties"
//default_config = "C:\\data\\encuesta\\config\\encuesta-config.properties"

default_configs = [
        "C:\\data\\$appName\\config\\$appName-application.yml",
        "C:\\data\\$appName\\config\\$appName-application.properties",
        "/data/$appName/config/$appName-application.yml",
        "/data/$appName/config/$appName-application.properties"
]

if(!grails.config.locations || !(grails.config.locations instanceof List)) {
    grails.config.locations = []
}
for(fileConfig in default_configs) {
    if (new File(fileConfig).exists()) {
        println "[${appName}] Including default configuration file: " + fileConfig;
        grails.config.locations.add "file:" + fileConfig
    } else {
        println "No external configuration file defined on [${fileConfig}]"
    }
}
println "[${appName}] (*) grails.config.locations = ${grails.config.locations}"
//println "default_config = ${default_config}"
println "default_configs = ${default_configs}"