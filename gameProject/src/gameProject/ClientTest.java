package gameProject;

import javax.swing.JFrame;

public class ClientTest {

	public static void main(String[] args) {
//		Client application = new Client("192.168.43.76");
		Client application = new Client("127.0.0.1");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runClient();

	}

}
