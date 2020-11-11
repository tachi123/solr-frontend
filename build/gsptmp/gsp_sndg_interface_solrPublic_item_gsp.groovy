import solrinterface.Item
import solrinterface.DocSolrType
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interface_solrPublic_item_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/_item.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',3,['var':("href"),'value':(myItem.django_id != null ? grailsApplication.config.external.link.exactas + solrinterface.DocSolrType.getById(Integer.parseInt(myItem.getType())).getKey().toLowerCase()+'/'+myItem.django_id : '/estatica/'+myItem.id.replace('.','/'))],-1)
printHtmlPart(0)
if(true && (typeItem == 'blocks')) {
printHtmlPart(1)
expressionOut.print(href)
printHtmlPart(2)
expressionOut.print(myItem.getName())
printHtmlPart(3)
if(true && (myItem.marker_exact != null && myItem.marker_exact.size() > 0)) {
printHtmlPart(4)
expressionOut.print(myItem.marker_exact)
printHtmlPart(5)
}
printHtmlPart(6)
}
else {
printHtmlPart(7)
expressionOut.print(href)
printHtmlPart(8)
expressionOut.print(myItem.getName())
printHtmlPart(9)
if(true && (myItem.getStatus() == null || myItem.getStatus() == 0)) {
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (myItem.bold_org_exact != null && myItem.bold_org_exact.size() > 0)) {
printHtmlPart(13)
expressionOut.print(myItem.bold_org_exact)
printHtmlPart(14)
}
printHtmlPart(14)
if(true && (myItem.taxon_exact != null && myItem.taxon_exact.size() > 0)) {
printHtmlPart(15)
expressionOut.print(myItem.taxon_exact[0])
printHtmlPart(14)
}
printHtmlPart(14)
if(true && (myItem.marker_exact != null && myItem.marker_exact.size() > 0)) {
printHtmlPart(16)
expressionOut.print(myItem.marker_exact)
printHtmlPart(14)
}
printHtmlPart(14)
if(true && (myItem.subdivision_exact != null && myItem.subdivision_exact.size() > 0)) {
printHtmlPart(17)
expressionOut.print(myItem.subdivision_exact)
printHtmlPart(14)
}
printHtmlPart(18)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571856626980L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
