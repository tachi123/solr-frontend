import solrinterface.DocSolrType
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sndg_interface_solrPublic_typeBox_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/solrPublic/_typeBox.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (grailsApplication.config.search.sections.enabled.contains(solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()))) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
expressionOut.print(typeDoc.getCount())
printHtmlPart(3)
invokeTag('message','g',13,['code':("solrinterface.DocSolrType.${solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()}")],-1)
printHtmlPart(4)
if(true && (grailsApplication.config.section.ICON.type == 'ICON')) {
printHtmlPart(5)
invokeTag('set','g',19,['var':("icon"),'value':(evaluate('grailsApplication.config.section.'+solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()+'.icon'))],-1)
printHtmlPart(5)
invokeTag('set','g',20,['var':("colorClass"),'value':(evaluate('grailsApplication.config.section.'+solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()+'.color'))],-1)
printHtmlPart(6)
expressionOut.print(icon)
printHtmlPart(7)
expressionOut.print(icon != null && icon.size() > 0 ? icon : grailsApplication.config.section.DEFAULT.icon)
printHtmlPart(8)
expressionOut.print(colorClass != null && colorClass.length()>0 ? 'text-'+colorClass : 'text-gray')
printHtmlPart(9)
expressionOut.print(icon)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (grailsApplication.config.section.ICON.type == 'PNG')) {
printHtmlPart(5)
invokeTag('set','g',24,['var':("urlImgSection"),'value':(evaluate('grailsApplication.config.section.'+solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()+'.urlImg'))],-1)
printHtmlPart(5)
invokeTag('img','g',25,['dir':("images"),'file':(urlImgSection != null && urlImgSection.size() > 0 ? urlImgSection : grailsApplication.config.section.DEFAULT.urlImg),'width':("inherit"),'height':("100px")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
})
invokeTag('link','g',30,['controller':("solrPublic"),'action':("search"),'params':([type:typeDoc.getName(),q:this.q]),'class':("panel panel-default")],2)
printHtmlPart(13)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571328412372L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
