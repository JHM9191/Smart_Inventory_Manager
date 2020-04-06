package top.frame;

import java.util.ArrayList;

public interface Biz<Id, Model> {
	
	public Model get(Id id);
	
	public ArrayList<Model> get();

}
