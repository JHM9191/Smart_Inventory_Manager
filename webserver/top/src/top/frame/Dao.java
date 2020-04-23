package top.frame;

import java.util.ArrayList;

import top.vo.ChainVO;
import top.vo.ContainerVO;
import top.vo.SalesVO;

public interface Dao<Id, Model> {

	default public void insert(Model model) throws Exception {

	}

	default public void update(Model model) throws Exception {

	}

	default public void delete(Id id) throws Exception {

	}

	public Model select(Id id);

	public ArrayList<Model> selectall();

	default public ArrayList<Model> selectYear(String year) {
		return null;
	}

	default public ArrayList<Model> selectMonth(String year, String id) {
		return null;
	}

	default public ArrayList<Model> selectYearly(String id) {
		return null;
	}

	default public ArrayList<Model> selectMonthly(String id) {
		return null;
	}

	// get container data for specific chainID
	default public ArrayList<Model> selectForChain(String id) {
		return null;
	}

	// get container data for specific hq=ID
	default public ArrayList<Model> selectbyhq(String id) {
		return null;
	}

}
