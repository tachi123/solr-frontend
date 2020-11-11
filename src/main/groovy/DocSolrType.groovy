package solrinterface

public enum DocSolrType implements org.springframework.context.MessageSourceResolvable{
	PUBLICATION(0),
	BIOPROJECT(1),
	SEQUENCE(2),
	ASSEMBLY(3),
	GENOME(4),
	READS(5),
	STRUCTURE(6),
	EXPRESSION(7),
	BARCODE(8),
	SAMPLE(9),
	TOOL(10),
	ORGANIZATION(30),
	PERSON(20),
	PROTEIN(40),
	UNPROCESSED(50)

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