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

	default public ArrayList<SalesVO> selectYear(String year) {
		return null;
	}

	default public ArrayList<SalesVO> selectMonth(String year, String id) {
		return null;
	}

	default public ArrayList<SalesVO> selectYearly(String id) {
		return null;
	}

	default public ArrayList<SalesVO> selectMonthly(String id) {
		return null;
	}

	// get container data for specific chainID
	default public ArrayList<ContainerVO> selectForChain(String chainID) {
		return null;
	}

	// get container data for specific hq=ID
	default public ArrayList<ChainVO> selectchain(String hqID) {
		return null;
	}

}
