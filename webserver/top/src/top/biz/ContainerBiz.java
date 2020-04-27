package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.ContainerVO;

@Service("conbiz")
public class ContainerBiz implements Biz<String, ContainerVO> {

	@Resource(name = "condao")
	Dao<String, ContainerVO> dao;

	@Override
	public ContainerVO get(String conID) {
		return dao.select(conID);
	}

	@Override
	public ArrayList<ContainerVO> get() {
		return dao.selectall();
	}

	public ArrayList<ContainerVO> getForChain(String chainID) {
		return dao.selectForChain(chainID);
	}

	public ArrayList<ContainerVO> getbyhq(String hqID) {
		return dao.selectbyhq(hqID);
	}

	@Override
	@Transactional
	public void register(ContainerVO model) {
		dao.insert(model);

	}

	@Override
	public void modify(ContainerVO model) {
		dao.update(model);
	}

	@Override
	public void modifyondelivered(ContainerVO model) {
		dao.updateondelivered(model);
	}

	@Override
	public void remove(String conID) {
		dao.delete(conID);

	}

	@Override
	public ContainerVO getjustregistered(ContainerVO container) {
		return dao.selectjustregistered(container);
	}

}