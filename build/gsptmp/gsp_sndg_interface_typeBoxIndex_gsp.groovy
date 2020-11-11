import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interface_typeBoxIndex_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_typeBoxIndex.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('set','g',1,['var':("icon"),'value':(evaluate('grailsApplication.config.section.'+typeKey+'.icon'))],-1)
printHtmlPart(0)
invokeTag('set','g',2,['var':("colorClass"),'value':(evaluate('grailsApplication.config.section.'+typeKey+'.color'))],-1)
printHtmlPart(1)
expressionOut.print(icon)
printHtmlPart(2)
expressionOut.print(icon != null && icon.size() > 0 ? icon : grailsApplication.config.section.DEFAULT.icon)
printHtmlPart(3)
expressionOut.print(colorClass != null && colorClass.length()>0 ? 'text-'+colorClass : 'text-gray')
printHtmlPart(4)
expressionOut.print(icon)
printHtmlPart(5)
expressionOut.print(solrinterface.DocSolrType.getByKey(typeKey).getId())
printHtmlPart(6)
invokeTag('message','g',7,['code':("solrinterface.DocSolrType.${typeKey}")],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571336432847L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
