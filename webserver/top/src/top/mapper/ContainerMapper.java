package top.mapper;

import java.util.ArrayList;

import top.vo.ContainerVO;

public interface ContainerMapper {

	public void insert(ContainerVO model);

	public void update(ContainerVO model);

	public void updateondelivered(ContainerVO model);

	public void delete(String conID);

	public ContainerVO select(String conID);

	public ArrayList<ContainerVO> selectall();

	public ArrayList<ContainerVO> selectForChain(String chainID);

	public ArrayList<ContainerVO> selectbyhq(String hqID);

	public ContainerVO selectjustregistered(ContainerVO model);
}