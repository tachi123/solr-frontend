import solrinterface.Item
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_buscador_frontend_solrPublic_item_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/_item.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',3,['var':("flagValue"),'value':(grailsApplication.config.skin.flag)],-1)
printHtmlPart(1)
if(true && (typeItem == 'blocks')) {
printHtmlPart(2)
expressionOut.print(href)
printHtmlPart(3)
if(true && (flagValue != null && myItem.getProperty(flagValue) != null)) {
printHtmlPart(4)
invokeTag('image','asset',9,['src':("banderas/"+myItem.getProperty(flagValue).toUpperCase()+".PNG"),'style':("height:1.3em;padding-left: 3px;")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
for( fieldTitle in (grails.converters.JSON.parse(grailsApplication.config.skin.typeBox.title)) ) {
printHtmlPart(4)
if(true && (fieldTitle.type == 'property')) {
printHtmlPart(6)
expressionOut.print(myItem.getProperty(fieldTitle.value))
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (fieldTitle.type == 'string')) {
printHtmlPart(6)
expressionOut.print(fieldTitle.value)
printHtmlPart(4)
}
printHtmlPart(5)
}
printHtmlPart(7)
for( fieldVisible in (grailsApplication.config.skin.typeBox.otherFields.split(",")) ) {
printHtmlPart(4)
if(true && (myItem.getProperty(fieldVisible) != null)) {
printHtmlPart(8)
expressionOut.print(message(code: 'skin.typeBox.'+fieldVisible, args:[]))
printHtmlPart(9)
expressionOut.print(myItem.getProperty(fieldVisible))
printHtmlPart(4)
}
printHtmlPart(5)
}
printHtmlPart(10)
}
else {
printHtmlPart(11)
expressionOut.print(href)
printHtmlPart(12)
for( fieldTitle in (grails.converters.JSON.parse(grailsApplication.config.skin.listItem.title)) ) {
printHtmlPart(5)
if(true && (fieldTitle.type == 'property')) {
printHtmlPart(4)
expressionOut.print(myItem.getProperty(fieldTitle.value))
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (fieldTitle.type == 'string')) {
printHtmlPart(4)
expressionOut.print(fieldTitle.value)
printHtmlPart(5)
}
printHtmlPart(13)
}
printHtmlPart(13)
if(true && (flagValue != null && myItem.getProperty(flagValue) != null)) {
printHtmlPart(5)
invokeTag('image','asset',42,['src':("banderas/"+myItem.getProperty(flagValue).toUpperCase()+".PNG"),'style':("height:1.3em;padding-left: 3px;")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
for( fieldVisible in (grailsApplication.config.skin.listItem.otherFields.split(",")) ) {
printHtmlPart(5)
if(true && (myItem.getProperty(fieldVisible) != null)) {
printHtmlPart(15)
expressionOut.print(message(code: 'skin.listItem.'+fieldVisible, args:[]))
printHtmlPart(9)
expressionOut.print(myItem.getProperty(fieldVisible))
printHtmlPart(5)
}
printHtmlPart(13)
}
printHtmlPart(16)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605483587448L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
