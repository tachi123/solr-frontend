import solrinterface.DocSolrType
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interfaceindex_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('javascript','g',2,['library':("jquery")],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('render','g',21,['template':("solrPublic/searchBox")],-1)
printHtmlPart(5)
invokeTag('render','g',26,['template':("typeBoxIndex"),'var':("typeKey"),'collection':(grailsApplication.config.search.sections.enabled.split('\\|'))],-1)
printHtmlPart(6)
if(true && (grailsApplication.config.index.sections.enabled.contains('CENTROS'))) {
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('set','g',39,['var':("urlImgSection"),'value':(grailsApplication.config.section.CENTROS.urlImg)],-1)
printHtmlPart(9)
expressionOut.print(resource(dir: 'images', file: urlImgSection))
printHtmlPart(10)
expressionOut.print(message(code: "section.CENTROS.display", args: []))
printHtmlPart(11)
expressionOut.print(message(code: "section.CENTROS.description", args: []))
printHtmlPart(12)
})
invokeTag('link','g',47,['controller':("solrPublic"),'action':("searchCentros"),'class':("panel panel-default")],3)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (grailsApplication.config.index.sections.enabled.contains('TOOL'))) {
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('set','g',53,['var':("urlImgSection"),'value':(grailsApplication.config.section.TOOL.urlImg)],-1)
printHtmlPart(9)
expressionOut.print(resource(dir: 'images', file: urlImgSection))
printHtmlPart(10)
expressionOut.print(message(code: "section.TOOL.display", args: []))
printHtmlPart(11)
expressionOut.print(message(code: "section.TOOL.description", args: []))
printHtmlPart(12)
})
invokeTag('link','g',61,['controller':("solrPublic"),'action':("search"),'params':([type:10]),'class':("panel panel-default")],3)
printHtmlPart(13)
}
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',84,['controller':("estatica"),'action':("estadisticas"),'class':("panel panel-default panel-icon panel-primary")],2)
printHtmlPart(17)
for( path in (grails.converters.JSON.parse(grailsApplication.config.otros.portales)) ) {
printHtmlPart(18)
expressionOut.print(path.url)
printHtmlPart(19)
expressionOut.print(raw(path.display))
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('message','g',143,['code':("section.index.contacto"),'args':([])],-1)
printHtmlPart(22)
invokeTag('message','g',145,['code':("section.index.direccion"),'args':([])],-1)
printHtmlPart(23)
expressionOut.print(raw(grailsApplication.config.contacto.direccion))
printHtmlPart(24)
invokeTag('message','g',147,['code':("section.index.cp"),'args':([])],-1)
printHtmlPart(25)
expressionOut.print(raw(grailsApplication.config.contacto.cp))
printHtmlPart(24)
invokeTag('message','g',149,['code':("section.index.telefono"),'args':([])],-1)
printHtmlPart(25)
expressionOut.print(raw(grailsApplication.config.contacto.tel))
printHtmlPart(24)
invokeTag('message','g',151,['code':("section.index.mail"),'args':([])],-1)
printHtmlPart(26)
expressionOut.print(grailsApplication.config.contacto.mail)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
expressionOut.print(grailsApplication.config.solr.link.core)
printHtmlPart(29)
})
invokeTag('javascript','g',182,['library':("jquery")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',184,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571856990102L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
