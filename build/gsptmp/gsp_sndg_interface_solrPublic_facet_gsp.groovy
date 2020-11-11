import org.apache.solr.client.solrj.response.FacetField
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interface_solrPublic_facet_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/_facet.gsp" }
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
printHtmlPart(1)
if(true && (myFacet.getValues() != null && myFacet.getValues().size() > 0)) {
printHtmlPart(4)
invokeTag('set','g',11,['var':("facetDisplay"),'value':(message(code: 'facet.'+myFacet.getName()+'.display', args:[]))],-1)
printHtmlPart(5)
expressionOut.print(myFacet.getName())
printHtmlPart(6)
expressionOut.print(facetDisplay != null && facetDisplay.size()>0 ? facetDisplay : myFacet.getName())
printHtmlPart(7)
expressionOut.print(myFacet.getName())
printHtmlPart(8)
expressionOut.print(myFacet.getName())
printHtmlPart(9)
expressionOut.print(myFacet.getName())
printHtmlPart(10)
loop:{
int i = 0
for( facetEntry in (myFacet.getValues()) ) {
printHtmlPart(11)
expressionOut.print(myFacet.getName()+":\""+facetEntry.getName()+"\"")
printHtmlPart(12)
expressionOut.print(facetEntry.getName() + " (" + facetEntry.getCount()+")")
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
}
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',38,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570646405565L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
