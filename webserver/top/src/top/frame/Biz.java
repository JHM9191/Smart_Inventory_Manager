package top.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import top.vo.ChainVO;
import top.vo.SalesVO;

public interface Biz<Id, Model> {

	@Transactional
	default public void register(Model model) {

	}

	@Transactional
	default public void registertoday(Model model) {

	}

	@Transactional
	default public void registernew(Model model) {

	}

	@Transactional
	default public void modify(Model model) {

	}

	@Transactional
	default public void modifyondelivered(Model model) {

	}

	@Transactional
	default public void remove(Id id) {

	}

	public Model get(Id id);

	public ArrayList<Model> get();

	default public ArrayList<Model> getForChain(String id) {
		return null;
	}

	default public ArrayList<Model> getYear(String year) {
		return null;
	}

	default public ArrayList<Model> getMonth(String year, Id id) {
		return null;
	}

	default public ArrayList<Model> getYearly(Id id) {
		return null;
	}

	default public ArrayList<Model> getMonthly(String year, Id id) {
		return null;
	}

	default public ArrayList<Model> getbyhq(String id) {
		return null;
	}

	default public ArrayList<Model> getnotifi(Id id) {
		return null;
	};

	// refresh

	default void refreshstate(String chainId) {

	}

	default public Model getchainname(String id) {
		return null;
	};

	default public Model getbychain(Id id) {
		return null;
	}

	default public Model getorderbychain(Model model) {
		return null;
	};

	default public Model getbyorderid(String id) {
		return null;
	};

	default public ArrayList<Model> getlistbyorderid(String id) {
		return null;
	};

	default public Model getjustregistered(Model model) {
		return null;
	};

	default public Model getordertoday(Model model) {
		return null;
	};
	
	default public ArrayList<Model> getDailyAllChain(String salesRegDate) {
		return null;
	}
}
