import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interface_layoutsmain_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(1)
invokeTag('link','asset',8,['rel':("icon"),'href':("favicon.ico"),'type':("image/x-ico")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',10,['src':("jquery-2.2.0.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',12,['src':("bootstrap.js")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',13,['src':("bootstrap.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',15,['src':("bootstrap-theme.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',16,['src':("poncho.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',17,['src':("roboto-fontface.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',18,['src':("icono-arg.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',19,['src':("font-awesome.min.css")],-1)
printHtmlPart(4)
invokeTag('layoutHead','g',20,[:],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',31,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('render','g',35,['template':("/templates/header")],-1)
printHtmlPart(1)
invokeTag('layoutBody','g',37,[:],-1)
printHtmlPart(7)
invokeTag('render','g',39,['template':("/templates/footer")],-1)
printHtmlPart(4)
createClosureForHtmlPart(8, 2)
invokeTag('javascript','g',51,['library':("jquery")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571857005459L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
