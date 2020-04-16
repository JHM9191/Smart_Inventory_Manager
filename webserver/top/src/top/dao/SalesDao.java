package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.SalesMapper;
import top.vo.SalesVO;

@Repository("salesdao")
public class SalesDao implements Dao<String, SalesVO> {
	@Autowired
	SalesMapper salesmapper;

	@Override
	public SalesVO select(String salesID) {
		return salesmapper.select(salesID);
	}

	@Override
	public ArrayList<SalesVO> selectall() {
		return salesmapper.selectall();
	}

	public ArrayList<SalesVO> selectYear(String year) {
		return salesmapper.selectYear(year);
	}
	
	public ArrayList<SalesVO> selectMonth(String year, String chainID) {
		return salesmapper.selectMonth(year, chainID);
	}

	public ArrayList<SalesVO> selectYearly(String salesID) {
		return salesmapper.selectYearly(salesID);
	}

	public ArrayList<SalesVO> selectMonthly(String salesID) {
		return salesmapper.selectMonthly(salesID);
	}

}