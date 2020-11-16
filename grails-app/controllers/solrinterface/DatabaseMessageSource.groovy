package solrinterface

import org.springframework.context.support.AbstractMessageSource

import java.text.MessageFormat

class DatabaseMessageSource extends AbstractMessageSource  {

    def messageBundleMessageSource

    protected MessageFormat resolveCode(String code, Locale locale) {
        Message msg = Message.findByCodeAndLocale(code, locale)
        def format = null
        if (msg) {
            format = new MessageFormat(msg.text, msg.locale)
        }else{
            format = messageBundleMessageSource.resolveCode(code, locale)
            if(format == null) format = new MessageFormat(code, locale )
        }
        return format;
    }
}
