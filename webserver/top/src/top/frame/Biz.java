package top.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import top.vo.ChainVO;
import top.vo.SalesVO;

public interface Biz<Id, Model> {

	@Transactional
	default public void register(Model model) throws Exception {

	}

	@Transactional
	default public void modify(Model model) throws Exception {

	}

	@Transactional
	default public void remove(Id id) throws Exception {

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
	

}
