package top.frame;

import java.util.ArrayList;

import top.vo.ChainVO;
import top.vo.ContainerVO;
import top.vo.SalesVO;

public interface Dao<Id, Model> {

	default public void insert(Model model) {

	}

	default public void inserttoday(Model model) {

	}

	default public void insertnew(Model model) {

	}

	default public void update(Model model) {

	}

	default public void updateondelivered(Model model) {

	}

	default public void delete(Id id) {

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

	// get list of data for specific chainID
	default public ArrayList<Model> selectForChain(String id) {
		return null;
	}

	// get list of data for specific hq=ID
	default public ArrayList<Model> selectbyhq(String id) {
		return null;
	}

	// read.top에서 쓰임 + adminpage.top
	default public ArrayList<Model> selectnotifi(String id) {
		return null;
	};

	// refresh_change
	default public void updatestate(String chainid) {

	}

	// user apply.top 에서 used!
	default public ChainVO selectchainname(String id) {
		return null;
	}

	default public Model selectbychain(Id id) {
		return null;
	};

	default public Model selectorderbychain(Model model) {
		return null;
	};

	default public Model selectbyorderid(String id) {
		return null;
	};

	default public ArrayList<Model> selectlistbyorderid(String id) {
		return null;
	};

	default public Model selectjustregistered(Model model) {
		return null;
	};

	default public Model selectordertoday(Model model) {
		return null;
	};

	default public ArrayList<SalesVO> selectDailyAllChain(String salesRegDate) {
		return null;
	};

}
