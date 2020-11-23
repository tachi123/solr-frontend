import solrinterface.Item
import solrinterface.DocSolrType
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_buscador_frontend_solrPublicsearchCentros_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/searchCentros.gsp" }
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
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('set','g',10,['var':("titleType"),'value':(message(code: 'section.CENTROS.display',args: []))],-1)
printHtmlPart(2)
invokeTag('set','g',11,['var':("descriptionType"),'value':(message(code: 'section.CENTROS.description',args: []))],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("urlImgSection"),'value':(evaluate('grailsApplication.config.section.ORGANIZATION.urlImg'))],-1)
printHtmlPart(2)
invokeTag('set','g',13,['var':("colorClass"),'value':(evaluate('grailsApplication.config.section.ORGANIZATION.color'))],-1)
printHtmlPart(2)
invokeTag('render','g',15,['template':("searchBox"),'model':([colorClass: colorClass,urlImg:urlImgSection,title:titleType, description: descriptionType, displayActive: titleType, optionsVisible: false])],-1)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('hiddenField','g',19,['name':("q"),'value':(this.q)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',20,['name':("type"),'value':(this.type)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',21,['name':("rows"),'value':(this.rows)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',22,['name':("sort"),'value':(this.sort)],-1)
printHtmlPart(6)

def pageCant=Math.round(Math.floor(this.numFound/this.rows)+1)

printHtmlPart(5)

def pageActual=Math.round(Math.floor(1+this.start/this.rows))

printHtmlPart(7)
invokeTag('render','g',29,['template':("pagination"),'model':([pageCant:pageCant,pageActual:pageActual])],-1)
printHtmlPart(8)
invokeTag('render','g',32,['template':("item"),'var':("myItem"),'collection':(this.items),'typeItem':(this.typeItem)],-1)
printHtmlPart(9)
invokeTag('render','g',34,['template':("pagination"),'model':([pageCant:pageCant,pageActual:pageActual])],-1)
printHtmlPart(10)
})
invokeTag('form','g',37,['name':("searchForm"),'action':("searchCentros"),'controller':("solrPublic")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('javascript','g',51,['library':("jquery")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570651681960L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
