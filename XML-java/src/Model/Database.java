package Model;

import java.util.ArrayList;

public class Database {

	ArrayList<Table> listTables;
	private String name;
	
	public Database(String name)
	{
		this.setName(name);
		this.listTables = new ArrayList<Table>();
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public void AddTable(Table t){
		listTables.add(t);
	}
	
	public ArrayList<Table> GetListTables(){
		return listTables;
	}
	
}
