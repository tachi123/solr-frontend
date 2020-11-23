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
expressionOut.print(grailsApplication.config.googleAnalitycsCode)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('set','g',22,['var':("titleType"),'value':(" ${message(code: 'skin.coreDisplay',args: [])}")],-1)
printHtmlPart(2)
invokeTag('set','g',23,['var':("descriptionType"),'value':(this.q != null && this.q.size() > 0 ? message(code: 'section.search.terminoBuscado',args: [this.q]) : '')],-1)
printHtmlPart(2)
invokeTag('set','g',24,['var':("urlImgSection"),'value':(evaluate('grailsApplication.config.section.DEFAULT.urlImg'))],-1)
printHtmlPart(2)
invokeTag('set','g',25,['var':("color"),'value':(evaluate('grailsApplication.config.section.DEFAULT.color'))],-1)
printHtmlPart(6)
invokeTag('render','g',28,['template':("search/searchBox"),'model':([color: color,urlImg:urlImgSection,title:titleType, description: descriptionType, displayActive: titleType])],-1)
printHtmlPart(7)
for( path in (grails.converters.JSON.parse(grailsApplication.config.otras.app)) ) {
printHtmlPart(8)
expressionOut.print(path.url)
printHtmlPart(9)
expressionOut.print(raw(path.display))
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',49,['code':("section.index.contacto"),'args':([])],-1)
printHtmlPart(12)
invokeTag('message','g',50,['code':("section.index.direccion"),'args':([])],-1)
printHtmlPart(13)
expressionOut.print(raw(grailsApplication.config.contacto.direccion))
printHtmlPart(14)
invokeTag('message','g',51,['code':("section.index.cp"),'args':([])],-1)
printHtmlPart(15)
expressionOut.print(raw(grailsApplication.config.contacto.cp))
printHtmlPart(14)
invokeTag('message','g',53,['code':("section.index.telefono"),'args':([])],-1)
printHtmlPart(15)
expressionOut.print(raw(grailsApplication.config.contacto.tel))
printHtmlPart(14)
invokeTag('message','g',55,['code':("section.index.mail"),'args':([])],-1)
printHtmlPart(16)
expressionOut.print(grailsApplication.config.contacto.mail)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
expressionOut.print(grailsApplication.config.solr.link.core)
printHtmlPart(19)
})
invokeTag('javascript','g',67,['library':("jquery")],2)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605994789444L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
