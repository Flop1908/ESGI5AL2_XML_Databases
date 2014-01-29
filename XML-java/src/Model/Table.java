package Model;

import java.util.ArrayList;

public class Table {
	
	ArrayList<Column> listColumns;
	ArrayList<Row> listRows;
	
	private String name;
	
	public Table(String name){
		this.name = name;
		this.listColumns = new ArrayList<Column>();
		this.listRows = new ArrayList<Row>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void AddColumn(Column t){
		this.listColumns.add(t);
	}
	
	public ArrayList<Column> GetListColumns(){
		return this.listColumns;
	}
	
	public void AddRow(Row t){
		this.listRows.add(t);
	}
	
	public ArrayList<Row> GetListRows(){
		return this.listRows;
	}

}
