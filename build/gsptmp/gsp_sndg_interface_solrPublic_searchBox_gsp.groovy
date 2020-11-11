import org.apache.solr.client.solrj.response.FacetField
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interface_solrPublic_searchBox_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/_searchBox.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',4,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',5,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(colorClass != null && colorClass.length()>0 ? 'bg-'+colorClass : '')
printHtmlPart(5)
expressionOut.print(resource(dir: "images", file: urlImg != null ? urlImg : grailsApplication.config.section.search.img.default))
printHtmlPart(6)
for( path in (grails.converters.JSON.parse(grailsApplication.config.breadcrumb.path)) ) {
printHtmlPart(7)
expressionOut.print(path.url)
printHtmlPart(8)
expressionOut.print(raw(path.display))
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(raw(displayActive != null ? displayActive : grailsApplication.config.breadcrumb.activoDisplay))
printHtmlPart(11)
expressionOut.print(raw(title != null ? title : grailsApplication.config.title))
printHtmlPart(12)
expressionOut.print(raw(description != null ? description : grailsApplication.config.description))
printHtmlPart(13)
if(true && (buscadorEnabled != false)) {
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
if(true && (!(optionsVisible == false))) {
printHtmlPart(16)
invokeTag('select','g',46,['name':("type"),'id':("type"),'from':(solrinterface.DocSolrType.findAll {grailsApplication.config.search.sections.enabled.contains(it.getKey())}),'value':(params.type),'noSelection':(['null':'Todos']),'optionKey':("id"),'class':("form-control")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
})
invokeTag('form','g',55,['name':("searchForm"),'action':("search"),'controller':("solrPublic")],3)
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',66,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571328583643L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
