# Front end de un núcleo solr

Es un proyecto en Grails que tiene como objetivo ofrecer una interfaz web de fácil configuración para poder visualizar la información que almacene un núcleo de solr ya creado previamente.

Este proyecto ofrece las características básicas de configuración de facetas, campos, boots, entre otras características de los índices creados por solr.

## Tabla de contenidos:

- [Empezando](#empezando)
- [Instalación](#instalacion)
- [Despliegue](#despliegue)

## Empezando

Primero debes tener un núcleo solr ya creado.

Es necesario tener la url del índice y el archivo de configuración para obtener los campos con los cuales se quiere realizar la visualización.

Los archivos de ejemplo se encuentran en la carpeta "configExample"

### Instalacion

**Configuración de base de datos en memoria:** application.yml

Prestar atención al usuario y contraseña de la base de datos con rol de administrador.

**Configuración de núcleo:** application.properties

1. Completar con la url del núcleo: `solr.url`
2. Configurar los parametros obligatorios de solr.*: `sort, fl, facets, facetsList, queryFields`
3. Configurar el resto de los parametros que presentan un ejemplo como default
4. Aclaraciones del campo solr.facetslist:

```diff
[[Diccionario del campo]]
-  field: nombre del campo como se llama en el índice
-  display: nombre a mostrar en pantalla
-  limiteado: en la interfaz se limita la cantidad a mostrar y se agrega la opción de ver más
-  typequery: cuando la faceta es del tipo query
-  multiple: permite seleccionar mas de una faceta
-  orden: se setea un orden (definido en el archivo de las facetas)
-  collapsed: aparece con las opciones colapsadas
-  fieldpadre: en el caso que otra faceta tenga que ser previamente seleccionada (ejemplo: pais -> provincia)
```

**Configuración de idiomas:** i18n

Dentro del archivo de configuración "application.properties" en el campo grails.i18n.basenames se debe completar con la ruta donde van a estar alojados los archivos i18n correspondientes a cada idioma.

Es importante si se desean agregar tags correspondientes a facetas u otros campos de la interfaz no tenidos en cuenta en este prototipo, hay que agregarlos en todos los archivos.

## Despliegue

Para producir el war y ejecutarlo en un servidor
```bash
grails prod war
```

Para ejecutar usando grails
```bash
grails run-app
```
