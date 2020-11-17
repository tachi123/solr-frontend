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
invokeTag('set','g',10,['var':("titleType"),'value':(" ${message(code: 'skin.coreDisplay',args: [])}")],-1)
printHtmlPart(2)
invokeTag('set','g',11,['var':("descriptionType"),'value':(this.q != null && this.q.size() > 0 ? message(code: 'section.search.terminoBuscado',args: [this.q]) : '')],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("urlImgSection"),'value':(evaluate('grailsApplication.config.section.DEFAULT.urlImg'))],-1)
printHtmlPart(2)
invokeTag('set','g',13,['var':("colorClass"),'value':(evaluate('grailsApplication.config.section.DEFAULT.color'))],-1)
printHtmlPart(2)
invokeTag('render','g',15,['template':("searchBox"),'model':([colorClass: colorClass,urlImg:urlImgSection,title:titleType, description: descriptionType, displayActive: titleType])],-1)
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
printHtmlPart(5)
invokeTag('hiddenField','g',23,['name':("typeItem"),'value':(this.typeItem)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',24,['name':("fqstring"),'value':(this.fqstring)],-1)
printHtmlPart(5)

def pageCant=Math.round(Math.floor(this.numFound/this.rows)+1)

printHtmlPart(5)

def pageActual=Math.round(Math.floor(1+this.start/this.rows))

printHtmlPart(6)
expressionOut.print(this.q)
printHtmlPart(7)
invokeTag('message','g',31,['code':("section.search.numFound"),'args':([this.numFound])],-1)
printHtmlPart(8)
if(true && (this.fq != null && this.fq.size() > 0)) {
printHtmlPart(9)
invokeTag('render','g',33,['template':("facetSelected"),'var':("facetSelected"),'collection':(this.fq)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('render','g',35,['template':("facet"),'var':("myFacet"),'collection':(this.facets)],-1)
printHtmlPart(12)
for( sortField in (grails.converters.JSON.parse(grailsApplication.config.solr.sorts)) ) {
printHtmlPart(13)
expressionOut.print(sortField.value)
printHtmlPart(14)
expressionOut.print(sortField.display)
printHtmlPart(15)
}
printHtmlPart(16)
for( rowField in (grails.converters.JSON.parse(grailsApplication.config.solr.rows)) ) {
printHtmlPart(17)
expressionOut.print(rowField.value)
printHtmlPart(18)
expressionOut.print(rowField.display)
printHtmlPart(15)
}
printHtmlPart(19)
for( rowField in (grails.converters.JSON.parse(grailsApplication.config.solr.rows)) ) {
printHtmlPart(17)
expressionOut.print(rowField.value)
printHtmlPart(20)
expressionOut.print(rowField.display)
printHtmlPart(15)
}
printHtmlPart(21)
invokeTag('render','g',88,['template':("pagination"),'model':([pageCant:pageCant,pageActual:pageActual,cant:3])],-1)
printHtmlPart(22)
invokeTag('render','g',90,['template':("item"),'var':("myItem"),'collection':(this.items)],-1)
printHtmlPart(23)
invokeTag('render','g',95,['template':("pagination"),'model':([pageCant:pageCant,pageActual:pageActual])],-1)
printHtmlPart(24)
})
invokeTag('form','g',96,['name':("searchForm"),'action':("search"),'controller':("solrPublic")],2)
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('javascript','g',107,['library':("jquery")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',107,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605624934471L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
