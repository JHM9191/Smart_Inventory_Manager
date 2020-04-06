package top.frame;

import java.util.ArrayList;

public interface Dao<Id, Model> {

	
	public Model select(Id id);
	
	public ArrayList<Model> selectall();
	
	
}
