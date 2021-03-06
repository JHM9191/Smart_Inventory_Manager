package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.ChainMapper;
import top.vo.ChainVO;

@Repository("chaindao")
public class ChainDao implements Dao<String, ChainVO> {
	@Autowired
	ChainMapper chainmapper;

	@Override
	public ChainVO select(String chainID) {
		return chainmapper.select(chainID);
	}

	@Override
	public ArrayList<ChainVO> selectall() {
		return chainmapper.selectall();
	}

	@Override
	public ArrayList<ChainVO> selectbyhq(String hqID) {
		return chainmapper.selectbyhq(hqID);
	}

	@Override
	public ChainVO selectchainname(String hqid) {
		return chainmapper.selectchainname(hqid);
	}

	@Override
	public ArrayList<ChainVO> selectnotifi(String hqid) {
		return chainmapper.selectnotifi(hqid);

	}

}