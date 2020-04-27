package top.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.frame.Biz;
import top.frame.Dao;
import top.vo.NotiVO;

@Service("notibiz")
public class NotiBiz implements Biz<String, NotiVO> {

	@Resource(name = "notidao")
	Dao<String, NotiVO> dao;

	@Override
	public NotiVO get(String chainID) {
		return dao.select(chainID);
	}

	@Override
	public ArrayList<NotiVO> get() {
		return dao.selectall();
	}

	@Override
	public void register(NotiVO model) {
		dao.insert(model);

	}

	@Override
	public void refreshstate(String chainID) {
		dao.updatestate(chainID);
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(NotiVO model) {
		// TODO Auto-generated method stub

	}

}
