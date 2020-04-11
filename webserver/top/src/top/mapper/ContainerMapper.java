package top.mapper;

import java.util.ArrayList;

import top.vo.ContainerVO;

public interface ContainerMapper {

	public ContainerVO select(String conID);

	public ArrayList<ContainerVO> selectall();

}