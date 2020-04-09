package top.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import top.frame.Dao;
import top.mapper.ContainerMapper;
import top.mapper.UserMapper;
import top.vo.ContainerVO;
import top.vo.UserVO;

@Repository("containerdao")
public class ContainerDao implements Dao<String, ContainerVO> {
	@Autowired
	ContainerMapper containermapper;

	@Override
	public ContainerVO select(String containerID) {
		return containermapper.select(containerID);
	}

	@Override
	public ArrayList<ContainerVO> selectall() {
		return containermapper.selectall();
	}

}