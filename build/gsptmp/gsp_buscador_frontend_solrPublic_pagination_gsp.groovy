import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_buscador_frontend_solrPublic_pagination_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/_pagination.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('set','g',1,['var':("cantMostrar"),'value':(cant != null ? cant : 5)],-1)
printHtmlPart(0)
expressionOut.print(1)
printHtmlPart(1)
expressionOut.print((pageActual - 1) > 0 ? '' : 'disabled=true')
printHtmlPart(2)
expressionOut.print(pageActual - 1)
printHtmlPart(3)
for( pagNumber in (pageActual > 5 ? ((pageActual-cantMostrar)..pageActual).toList() : (1..(pageActual)).toList()) ) {
printHtmlPart(4)
if(true && (pagNumber != pageActual)) {
printHtmlPart(5)
expressionOut.print(pagNumber)
printHtmlPart(6)
expressionOut.print(pagNumber)
printHtmlPart(7)
}
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(pageActual)
printHtmlPart(10)
for( pagNumber in ((pageActual+cantMostrar) <= pageCant ? ((pageActual+1)..(pageActual+cantMostrar)).toList() : ((pageActual)..(pageCant)).toList()) ) {
printHtmlPart(4)
if(true && (pagNumber != pageActual)) {
printHtmlPart(11)
expressionOut.print(pageActual == pagNumber ? 'active' : '')
printHtmlPart(12)
expressionOut.print(pagNumber)
printHtmlPart(6)
expressionOut.print(pagNumber)
printHtmlPart(7)
}
printHtmlPart(8)
}
printHtmlPart(13)
expressionOut.print(pageActual + 1)
printHtmlPart(14)
expressionOut.print(pageCant)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605114259440L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
