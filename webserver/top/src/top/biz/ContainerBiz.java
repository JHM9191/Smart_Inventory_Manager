package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.ContainerVO;

@Service("containerbiz")
public class ContainerBiz implements Biz<String, ContainerVO> {

	@Resource(name = "containerdao")
	Dao<String, ContainerVO> dao;

	@Override
	public ContainerVO get(String id) {
		return dao.select(id);
	}

	@Override
	public ArrayList<ContainerVO> get() {
		return dao.selectall();
	}

}