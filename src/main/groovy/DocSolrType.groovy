package solrinterface

public enum DocSolrType implements org.springframework.context.MessageSourceResolvable{

	PERSONA(0),
	PROYECTO(1)

	final int id;
	
	private DocSolrType(int id) {
		this.id = id
	}

	String toString() {
		id.toString()
	}

	String getKey() {
		name()
	}
	
	public static DocSolrType getById(int id) {
		for(DocSolrType e : values()) {
			if(e.id.equals(id)) return e;
		}
		return null;
	}

	public static DocSolrType getByKey(String name) {
		for(DocSolrType e : values()) {
			if(e.getKey().equals(name)) return e;
		}
		return null;
	}
	
	Object[] getArguments() { [] as Object[] }

	String[] getCodes() {
		["${getClass().name}.${name()}"] as String[]
	}

	String getDefaultMessage() { name() }
	
}