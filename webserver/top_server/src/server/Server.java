package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import msg.Msg;

public class Server {

	int port;

	ServerSocket serverSocket;

	HashMap<String, ObjectOutputStream> maps = new HashMap<>();

	boolean flag = true;

	public Server() {

	}

	public Server(int port) throws Exception {
		serverSocket = new ServerSocket(port);

		System.out.println("Server Started");

		Runnable r = new Runnable() {

			@Override
			public void run() {

				Socket socket = null;

				while (flag) {
					System.out.println("Server is Ready.....");

					try {
						socket = serverSocket.accept();

						saveConnection(socket);

						new Thread(new Receiver(socket)).start();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(r).start();
	}

	public void saveConnection(Socket socket) throws Exception {
		OutputStream os;
		ObjectOutputStream oos;

		os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);

		maps.put(socket.getInetAddress().toString(), oos);
		System.out.println("Connected tablet IP : " + socket.getInetAddress());
		System.out.println("Total # of Connected tablets : " + maps.size());

	}

	class Receiver implements Runnable {

		InputStream is;
		ObjectInputStream ois;

		Socket socket;

		public Receiver(Socket socket) {
			this.socket = socket;

			try {
				is = socket.getInputStream();
				ois = new ObjectInputStream(is);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		@Override
		public void run() {
			while (ois != null) {

				Msg msg = null;

				try {
					msg = (Msg) ois.readObject();
					System.out.println(
							socket.getInetAddress() + ":" + msg.getId() + ":" + msg.getTxt() + ":" + msg.getTid());
					sendMsg(msg);
				} catch (Exception e) {
//					e.printStackTrace();
					maps.remove(socket.getInetAddress().toString());
					System.out.println("Exited table IP : " + socket.getInetAddress());
					System.out.println("Total # of Connected tablets : " + maps.size());
					break;
				}

			}
			System.out.println("ois == null");
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

		Msg msg;

		public Sender(Msg msg) {
			this.msg = msg;

		}

		@Override
		public void run() {
			String ip = msg.getTid();

			try {
				maps.get(ip).writeObject(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendMsg(Msg msg) {

		new Thread(new Sender(msg)).start();

	}

	public static void main(String[] args) {
		Server server = null;

		try {
			server = new Server(8888);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
