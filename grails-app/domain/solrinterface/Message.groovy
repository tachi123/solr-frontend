package solrinterface

class Message {

    String code

    Locale locale

    String text

    def setLocaleCodeText(Locale Locale, String Code, String Text){
        this.locale = Locale
        this.code = Code
        this.text = Text
    }

}
