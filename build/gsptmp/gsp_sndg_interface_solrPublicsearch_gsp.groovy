import solrinterface.Item
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interface_solrPublicsearch_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/search.gsp" }
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
invokeTag('set','g',10,['var':("titleType"),'value':(" ${message(code: 'section.ALL.display',args: [])}")],-1)
printHtmlPart(2)
invokeTag('set','g',11,['var':("descriptionType"),'value':(this.q != null && this.q.size() > 0 ? message(code: 'section.search.terminoBuscado',args: [this.q]) : '')],-1)
printHtmlPart(2)
invokeTag('render','g',13,['template':("searchBox"),'model':([title:titleType, description: descriptionType, displayActive: titleType])],-1)
printHtmlPart(4)
loop:{
int i = 0
for( facetType in (facets[0].getValues()) ) {
printHtmlPart(5)
invokeTag('render','g',18,['template':("typeBox"),'var':("typeDoc"),'collection':(facetType)],-1)
printHtmlPart(6)
i++
}
}
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',22,[:],1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571330940188L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
