package top.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import client.Client;
import msg.Msg;
import top.vo.ContainerVO;

@Controller
public class ChainController {

	@RequestMapping("/addContainer.top")
	public void addContainer() {

		ContainerVO c1 = new ContainerVO("CONID_1000001", "100", 10.0, 8.0, 40, 2.0, 10, 6.0, 30, 0.2, "ingID_1000003",
				"chainID_1000000");
		sendToTablet(c1);

	}

	public void sendToTablet(ContainerVO container) {
		Client client = null;

		String serverIP = "192.168.43.2";

		client = new Client(serverIP, 8888);

		Msg msg = new Msg(serverIP, "webserver", "/192.168.43.2");
		client.startClient(msg);

	}

}
