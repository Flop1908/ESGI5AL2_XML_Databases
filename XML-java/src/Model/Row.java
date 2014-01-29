package Model;

import java.util.ArrayList;

public class Row {

	ArrayList<Field> listFields;
	
	public Row(){
		this.listFields = new ArrayList<Field>();
	}
	
	public void AddField(Field t){
		this.listFields.add(t);
	}
	
	public ArrayList<Field> GetListFields(){
		return this.listFields;
	}
}
