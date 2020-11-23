import solrinterface.Item
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_buscador_frontend_solrPublicsearchTypeSelected_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/searchTypeSelected.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('javascript','g',2,['library':("jquery")],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('set','g',12,['var':("titleType"),'value':(" ${message(code: 'skin.coreDisplay',args: [])}")],-1)
printHtmlPart(2)
invokeTag('set','g',13,['var':("descriptionType"),'value':(this.q != null && this.q.size() > 0 ? message(code: 'section.search.terminoBuscado',args: [this.q]) : '')],-1)
printHtmlPart(2)
invokeTag('set','g',14,['var':("urlImgSection"),'value':(evaluate('grailsApplication.config.section.DEFAULT.urlImg'))],-1)
printHtmlPart(2)
invokeTag('set','g',15,['var':("color"),'value':(evaluate('grailsApplication.config.section.DEFAULT.color'))],-1)
printHtmlPart(5)
invokeTag('render','g',19,['template':("searchBox"),'model':([color: color,urlImg:urlImgSection,title:titleType, description: descriptionType, displayActive: titleType])],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('hiddenField','g',23,['name':("q"),'value':(this.q)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',24,['name':("type"),'value':(this.type)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',25,['name':("rows"),'value':(this.rows)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',26,['name':("sort"),'value':(this.sort)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',27,['name':("typeItem"),'value':(this.typeItem)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',28,['name':("fqstring"),'value':(this.fqstring)],-1)
printHtmlPart(7)

def pageCant=Math.round(Math.floor(this.numFound/this.rows)+1)

printHtmlPart(7)

def pageActual=Math.round(Math.floor(1+this.start/this.rows))

printHtmlPart(8)
expressionOut.print(this.q)
printHtmlPart(9)
invokeTag('message','g',35,['code':("section.search.numFound"),'args':([this.numFound])],-1)
printHtmlPart(10)
if(true && (this.fq != null && this.fq.size() > 0)) {
printHtmlPart(11)
invokeTag('render','g',37,['template':("facetSelected"),'var':("facetSelected"),'collection':(this.fq)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('render','g',39,['template':("facet"),'var':("myFacet"),'collection':(this.facets)],-1)
printHtmlPart(14)
for( sortField in (grails.converters.JSON.parse(grailsApplication.config.solr.sorts)) ) {
printHtmlPart(15)
expressionOut.print(sortField.value)
printHtmlPart(16)
expressionOut.print(sortField.display)
printHtmlPart(17)
}
printHtmlPart(18)
for( rowField in (grails.converters.JSON.parse(grailsApplication.config.solr.rows)) ) {
printHtmlPart(19)
expressionOut.print(rowField.value)
printHtmlPart(20)
expressionOut.print(rowField.display)
printHtmlPart(17)
}
printHtmlPart(21)
for( rowField in (grails.converters.JSON.parse(grailsApplication.config.solr.rows)) ) {
printHtmlPart(19)
expressionOut.print(rowField.value)
printHtmlPart(22)
expressionOut.print(rowField.display)
printHtmlPart(17)
}
printHtmlPart(23)
invokeTag('render','g',92,['template':("pagination"),'model':([pageCant:pageCant,pageActual:pageActual,cant:3])],-1)
printHtmlPart(24)
invokeTag('render','g',94,['template':("item"),'var':("myItem"),'collection':(this.items)],-1)
printHtmlPart(25)
invokeTag('render','g',99,['template':("pagination"),'model':([pageCant:pageCant,pageActual:pageActual])],-1)
printHtmlPart(26)
})
invokeTag('form','g',100,['name':("searchForm"),'action':("search"),'controller':("solrPublic")],2)
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('javascript','g',111,['library':("jquery")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',111,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605884802636L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
