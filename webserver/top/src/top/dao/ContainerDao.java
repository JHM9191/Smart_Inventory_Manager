package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.ContainerMapper;
import top.vo.ContainerVO;

@Repository("condao")
public class ContainerDao implements Dao<String, ContainerVO> {
	@Autowired
	ContainerMapper containermapper;

	@Override
	public ContainerVO select(String conID) {
		return containermapper.select(conID);
	}

	@Override
	public ArrayList<ContainerVO> selectall() {
		return containermapper.selectall();
	}

}