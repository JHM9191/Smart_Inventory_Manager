package top.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import client.Client;
import msg.Msg;
import top.vo.ContainerVO;

@Controller
public class ChainController {

	HashMap<String, ArrayList<ContainerVO>> conMap = new HashMap<String, ArrayList<ContainerVO>>();

	ArrayList<ContainerVO> conList = null;

	// HQ add IoT Container to specific Chain
	@RequestMapping("/addContainer.top")
	public void addContainer() {

//		ContainerVO c1 = new ContainerVO("CONID_1000001", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000003",
//				"chainID_1000000");
		// sendToTablet(c1);

	}

	public void sendToTablet(ContainerVO container) {
		Client client = null;

		String serverIP = "192.168.43.2";

		client = new Client(serverIP, 8888);

		Msg msg = new Msg(serverIP, "webserver", "/192.168.43.2");
		client.startClient(msg);

	}

	// show List of registered IoT containers of specific Chain

	// save real time IoT container data
	@RequestMapping("/realtimecontainerdata.top")
	public void realtimecontainerdata(HttpServletRequest req) {
		String conID = req.getParameter("conID");
		System.out.println(conID.substring(6));
		double conFullWeight = Double.parseDouble(req.getParameter("conFullWeight"));
		double conCurrWeight = Double.parseDouble(req.getParameter("conCurrWeight"));
		double conWarningWeight = Double.parseDouble(req.getParameter("conWarningWeight"));
		String ingID = req.getParameter("ingID");
		String chainID = req.getParameter("chainID");

		System.out.println(conID + " | " + conFullWeight + " | " + conCurrWeight + " | " + conWarningWeight + " | "
				+ ingID + " | " + chainID);
		// ContainerVO con = new ContainerVO(conID, conFullWeight, conCurrWeight,
		// conWarningWeight, ingID, chainID);
		// saveConData(con, conID, chainID, conCurrWeight);
	}

	@RequestMapping("/getRealTimeContainerData.top")
	@ResponseBody
	public ArrayList<ContainerVO> getRealTimeContainerData(HttpServletRequest req) {
		String chainID = req.getParameter("chainID");
		System.out.println("chainID : " + chainID);
		Collection<String> col = conMap.keySet();
		Iterator<String> it = col.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println("key : " + key);
			if (key.equals(chainID)) {
				ArrayList<ContainerVO> list = conMap.get(key);

				list.sort(new Comparator<ContainerVO>() {

					@Override
					public int compare(ContainerVO o1, ContainerVO o2) {

						int con1 = Integer.parseInt(o1.getConID().substring(6));
						int con2 = Integer.parseInt(o2.getConID().substring(6));
						if (con1 == con2) {
							return 0;
						} else if (con1 > con2) {
							return 1;
						} else {
							return -1;
						}
					}

				});

				System.out.println(list);
				return list;
			}
		}
		return null;
	}

	public void saveConData(ContainerVO con, String conID, String chainID, double conCurrWeight) {
		if (conMap.isEmpty()) { // first time
			System.out.println("Initial");
			conList = new ArrayList<ContainerVO>();
			conList.add(con);
			conMap.put(chainID, conList);
		}

		//
		boolean chainNotExist = true;
		Collection<String> col = conMap.keySet();
		Iterator<String> it = col.iterator();
		while (it.hasNext()) {
			String key = it.next();

			if (key.equals(chainID)) { // chainID exists
				conList = conMap.get(key);
				boolean conNotExist = true;
				for (int i = 0; i < conList.size(); i++) {
					if (conList.get(i).getConID().equals(conID)) {
						conList.get(i).setConCurrWeight(conCurrWeight);
						conNotExist = false;
						chainNotExist = false;
					}
				}
				if (conNotExist) {
					conList.add(con);
					conNotExist = false;
					chainNotExist = false;
				}
			}
//			else { // chainID does not exist
//				conList = new ArrayList<ContainerVO>();
//				conList.add(con);
//				conMap.put(chainID, conList);
//			}
		}

		if (chainNotExist) {
			conList = new ArrayList<ContainerVO>();
			conList.add(con);
			conMap.put(chainID, conList);
		}
		System.out.println("conMap.size() : " + conMap.size());
	}

}
