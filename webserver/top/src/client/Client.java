package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import msg.Msg;

public class Client {

	Socket socket;
	Sender sender;
	Receiver receiver;
	String connected_server_ip;

	public Client() {

	}

	public Client(String ip, int port) {

		try {
			socket = new Socket(ip, port);
		} catch (Exception e) {
//			e.printStackTrace();

			while (true) {
				System.out.println("Retry Connecting to Server ...");

				try {
					Thread.sleep(500);
					socket = new Socket(ip, port);
					break;
				} catch (Exception e1) {
//					e1.printStackTrace();
				}

			}

		}

		System.out.println("Connected to Server.");
		System.out.println("Server IP : " + ip);

		try {
			receiver = new Receiver(socket);
			sender = new Sender(socket);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class Receiver implements Runnable {

		InputStream is;
		ObjectInputStream ois;

		public Receiver(Socket socket) throws IOException {
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
		}

		@Override
		public void run() {

			while (ois != null) {
				Msg msg = null;

				try {
					msg = (Msg) ois.readObject();

					connected_server_ip = msg.getId();
					System.out.println("Connected IP : " + connected_server_ip);

				} catch (Exception e) {
//					e.printStackTrace();
					System.out.println("Disconnected to Server");
					break;
				}

			}

			try {
				if (ois != null) {
					ois.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	class Sender implements Runnable {

		OutputStream os;
		ObjectOutputStream oos;
		Msg msg;

		public Sender(Socket socket) throws IOException {
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
		}

		public void setMsg(Msg msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			System.out.println("Entered Sender run()");

			if (oos != null) {

				try {
					oos.writeObject(msg);
					System.out.println(msg.getId() + " | " + msg.getTxt() + " | " + msg.getTid());
				} catch (IOException e) {
//					e.printStackTrace();
					try {
						if (oos != null) {
							oos.close();
						}
						if (socket != null) {
							socket.close();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
						new Client(connected_server_ip, 8888);

					}
				}
			}

		}

	}

	public void startClient(Msg msgFromWebServer) {
		Msg msg = msgFromWebServer;
		System.out.println("Entered startClient()");
		System.out.println(msg.getId() + " | " + msg.getTxt() + " | " + msg.getTid());
		sender.setMsg(msg);
		new Thread(sender).start();
	}

}
