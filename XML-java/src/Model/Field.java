package Model;

public class Field {
	
	private String column_name;
	private String content;
	
	public Field(String column_name, String content){
		this.setColumn_name(column_name);
		this.setContent(content);
	
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
