import solrinterface.DocSolrType
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_buscador_frontendindex_gsp extends org.grails.gsp.GroovyPage {
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
for( path in (grails.converters.JSON.parse(grailsApplication.config.otros.portales)) ) {
printHtmlPart(7)
expressionOut.print(path.url)
printHtmlPart(8)
expressionOut.print(raw(path.display))
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('message','g',42,['code':("section.index.contacto"),'args':([])],-1)
printHtmlPart(11)
invokeTag('message','g',43,['code':("section.index.direccion"),'args':([])],-1)
printHtmlPart(12)
expressionOut.print(raw(grailsApplication.config.contacto.direccion))
printHtmlPart(13)
invokeTag('message','g',45,['code':("section.index.cp"),'args':([])],-1)
printHtmlPart(14)
expressionOut.print(raw(grailsApplication.config.contacto.cp))
printHtmlPart(13)
invokeTag('message','g',49,['code':("section.index.telefono"),'args':([])],-1)
printHtmlPart(14)
expressionOut.print(raw(grailsApplication.config.contacto.tel))
printHtmlPart(13)
invokeTag('message','g',51,['code':("section.index.mail"),'args':([])],-1)
printHtmlPart(15)
expressionOut.print(grailsApplication.config.contacto.mail)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(grailsApplication.config.solr.link.core)
printHtmlPart(18)
})
invokeTag('javascript','g',68,['library':("jquery")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605121370286L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
