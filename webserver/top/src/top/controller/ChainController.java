package top.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.frame.Biz;
import top.vo.ContainerVO;
import top.vo.NotiVO;

@Controller
public class ChainController {

	@Resource(name = "conbiz")
	Biz<String, ContainerVO> conbiz;
	@Resource(name = "notibiz")
	Biz<String, NotiVO> notibiz;

	HashMap<String, ArrayList<ContainerVO>> conMap = new HashMap<String, ArrayList<ContainerVO>>();

	ArrayList<ContainerVO> conList = null;

	// Fetch IoT Container info for a specific chain when chain tablet sends
	// request.
	@RequestMapping("/fetchContainerData.top")
	public void fetchContainerData(HttpServletRequest req) {
		String chainID = req.getParameter("chainID");
		System.out.println(chainID);

		ArrayList<ContainerVO> conList = conbiz.getForChain(chainID);
		System.out.println("conList : " + conList);

		// send notification to manageApp regardless of the said conditions above
		URL url = null;
		try {
			url = new URL("https://fcm.googleapis.com/fcm/send");
		} catch (MalformedURLException e) {
			System.out.println("Error while creating Firebase URL | MalformedURLException");
			e.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			System.out.println("Error while createing connection with Firebase URL | IOException");
			e.printStackTrace();
		}
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");

		// set my firebase server key
		conn.setRequestProperty("Authorization", "key="
				+ "AAAAoMmzl84:APA91bHIGDTXVb45_HKSfAFsr-IGf1K_gvHgQ4p9AMNUD77S5Pv7O4jGXSo-4XQ1aTS4ZDc1db8_8S0VHZsUAJfUwLXCINoPykcoKUJ3CVgUp4JdsD0KnigqqVWzm1ZfgZChI6cTCK1Q");

		// create notification message into JSON format
		JSONObject message = new JSONObject();
//		message.put("to",
//				"cmm9ME4d9Ss:APA91bGxP8xrtRCzEof13dArAAuJKGODYi7uejryVTxkdndEoUxC0NTw2LbNNhUizHS38syfGTmHRBRUzCXj5HLgkQcb2XYeE4eiyGG-kKHSU-OPbSet2AMU_yjv0gQMg0RDLhNy920d");
		message.put("to", "/topics/chainTablet");
		message.put("priority", "high");
		JSONObject notification = new JSONObject();
		notification.put("title", chainID);
		notification.put("body", "fetch");
		message.put("notification", notification);
		JSONArray conListArray = new JSONArray();

		for (ContainerVO con : conList) {
			JSONObject jo = new JSONObject();
			jo.put("conID", con.getConID());
			jo.put("conSize", con.getConSize());
			jo.put("conMaxWeight", con.getConMaxWeight());
			jo.put("conRegDate", con.getConRegDate());
			jo.put("conUpdateDate", con.getConUpdateDate());
			jo.put("conFullWeight", con.getConFullWeight());
			jo.put("conFullQuantity", con.getConFullQuantity());
			jo.put("conWarningWeight", con.getConWarningWeight());
			jo.put("conWarningQuantity", con.getConWarningQuantity());
			jo.put("conCurrWeight", con.getConCurrWeight());
			jo.put("conCurrQuantity", con.getConCurrQuantity());
			jo.put("conUnitWeight", con.getConUnitWeight());
			jo.put("ingID", con.getIngID());
			jo.put("ingName", con.getIngName());
			jo.put("ingWeight", con.getIngWeight());
			jo.put("chainID", con.getChainID());
			jo.put("chainName", con.getChainName());
			jo.put("hqID", con.getHqID());
			jo.put("hqName", con.getHqName());
			conListArray.add(jo);
		}
		JSONObject list = new JSONObject();
		list.put("list", conListArray);
		message.put("data", list);

		// send data to firebase (http method)
		try {
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(message.toString());
			out.flush();
			conn.getInputStream();
		} catch (IOException e) {
			System.out.println("Error while writing outputstream to firebase sending to ManageApp | IOException");
			e.printStackTrace();
		}

	}

//
//	// HQ add IoT Container to specific Chain
//	@RequestMapping("/addContainer.top")
//	public void addContainer() {
//
////		ContainerVO c1 = new ContainerVO("CONID_1000001", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000003",
////				"chainID_1000000");
//		// sendToTablet(c1);
//
//	}
//
//	public void sendToTablet(ContainerVO container) {
//		Client client = null;
//
//		String serverIP = "192.168.43.2";
//
//		client = new Client(serverIP, 8888);
//
//		Msg msg = new Msg(serverIP, "webserver", "/192.168.43.2");
//		client.startClient(msg);
//
//	}

	// show List of registered IoT containers of specific Chain

	// save real time IoT container data
	@RequestMapping("/realtimecontainerdata.top")
	public void realtimecontainerdata(HttpServletRequest req) {
		String conID = req.getParameter("conID");
//		System.out.println(conID.substring(6));
		double conFullWeight = Double.parseDouble(req.getParameter("conFullWeight"));
		double conCurrWeight = Double.parseDouble(req.getParameter("conCurrWeight"));
		double conWarningWeight = Double.parseDouble(req.getParameter("conWarningWeight"));
		String ingID = req.getParameter("ingID");
		String ingName = req.getParameter("ingName");
		String chainID = req.getParameter("chainID");
		String userID = req.getParameter("userID");

		System.out.println(conID + " | " + conFullWeight + " | " + conCurrWeight + " | " + conWarningWeight + " | "
				+ ingID + " | " + ingName + " | " + chainID + " | " + userID);

//		 ContainerVO con = new ContainerVO(conID, conFullWeight, conCurrWeight,
//		 conWarningWeight, ingID, chainID);
		ContainerVO con = new ContainerVO();
		con.setConID(conID);
		con.setConFullWeight(conFullWeight);
		con.setConCurrWeight(conCurrWeight);
		con.setChainID(chainID);
		con.setIngName(ingName);
		saveConData(con, conID, chainID, conCurrWeight);
		// if below warning, send noti to admin.
		if ((conCurrWeight - conWarningWeight) < 0) {
			String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			System.out.println("Warning!  " + con);
//			notibiz.register(new NotiVO(null, chainID, userID, null, regDate, "new"));
		}
	}

	@RequestMapping("/getAllRealTimeContainerData.top")
	@ResponseBody
	public HashMap<String, ArrayList<ContainerVO>> getAllRealTimeContainerData(HttpServletRequest req) {

		return conMap;
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

				System.out.println("list : " + list);
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
