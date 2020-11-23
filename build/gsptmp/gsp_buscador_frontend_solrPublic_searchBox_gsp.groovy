import org.apache.solr.client.solrj.response.FacetField
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_buscador_frontend_solrPublic_searchBox_gsp extends org.grails.gsp.GroovyPage {
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
expressionOut.print(urlImgSection != null && urlImgSection.length() > 0 ? 'background-image: url(resource(dir: "images", file: '+urlImgSection+' ) ': 'background-color: '+color)
printHtmlPart(5)
for( path in (grails.converters.JSON.parse(grailsApplication.config.breadcrumb.path)) ) {
printHtmlPart(6)
expressionOut.print(path.url)
printHtmlPart(7)
expressionOut.print(raw(path.display))
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(raw(displayActive != null ? displayActive : grailsApplication.config.breadcrumb.activoDisplay))
printHtmlPart(10)
expressionOut.print(raw(title != null ? title : grailsApplication.config.title))
printHtmlPart(11)
expressionOut.print(raw(description != null ? description : grailsApplication.config.description))
printHtmlPart(12)
if(true && (buscadorEnabled != false)) {
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
if(true && ((grailsApplication.config.solr.queryFieldsOptionsEnabled).equals("true"))) {
printHtmlPart(15)
invokeTag('select','g',45,['name':("queryField"),'id':("queryField"),'from':(grails.converters.JSON.parse(grailsApplication.config.solr.queryFieldsOptions)),'optionValue':("display"),'optionKey':("value"),'class':("form-control")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('form','g',54,['name':("searchForm"),'action':("search"),'controller':("solrPublic")],3)
printHtmlPart(18)
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605884802635L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
