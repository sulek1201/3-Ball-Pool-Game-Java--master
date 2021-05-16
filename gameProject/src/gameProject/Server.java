package gameProject;
import org.json.*;
import java.awt.BorderLayout;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Integer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities; 

public class Server extends JFrame {

	private JTextField enterField;
	private JTextArea displayArea;
	public ObjectOutputStream output;
	private ObjectInputStream input;
	protected static ServerSocket server;
	private Socket connection;
	private String src;
	private int counter = 1;
	protected static int topx;
	
	
	public Server() {
		super("Server");
		
//		enterField = new JTextField();
//		enterField.setEditable(false);
//		enterField.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sendData(e.getActionCommand());
//				enterField.setText("");
//			}
//		});
		
		//add(enterField,BorderLayout.NORTH);
		
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea),BorderLayout.CENTER);
		
		setSize(300,100);
		setVisible(true);
	}
	
	public void runServer() {
		try {
			server = new ServerSocket(12345,100);
			
			while(true) {
				try {
					waitForConnection();
					getStreams();
					//processConnection(src);
				}
				catch (EOFException e) {
					displayMessage("\nServer terminated connection");
				}
				finally {
					closeConnection();
					++counter;
				}
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForConnection() throws IOException{
		displayMessage("Waiting for connection\n");
		connection = server.accept();
		displayMessage("Connection " + counter + " received from: " + 
						connection.getInetAddress().getHostName());
	}
	
	public void getStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		
		input = new ObjectInputStream(connection.getInputStream());
		
		displayMessage("\nGot I/O streams\n");
	}
	
	public void processConnection() throws IOException{
		String msg ;
		//sendData(message);
		
//		do {
			try {
//				try {
//					JSON.put("TOP1x", SnookerOnline.TOP1x);
//					JSON.put("TOP1y", SnookerOnline.TOP1y);
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				output.writeObject(JSON);
				//JSONObject msgg = new JSONObject();
				msg = (String) input.readObject();
				System.out.println(msg);
				JSONObject msgg = new JSONObject();
				try {
					msgg = new JSONObject(msg);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				try {
//					displayMessage("\n" + abc.get("TOP1x"));
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("çalýþtý");
				//sendData(msg);
				
				try {
					SnookerOnline.TOP1x = (int) msgg.get("TOP1x");
					SnookerOnline.TOP1y = (int) msgg.get("TOP1y");
					SnookerOnline.TOP2x = (int) msgg.get("TOP2x");
					SnookerOnline.TOP2y = (int) msgg.get("TOP2y");
					SnookerOnline.TOP3x = (int) msgg.get("TOP3x");
					SnookerOnline.TOP3y = (int) msgg.get("TOP3y");
					SnookerOnline.speed1X = (int) msgg.get("speed1X");
					SnookerOnline.speed1Y = (int) msgg.get("speed1Y");
					SnookerOnline.speed2X = (int) msgg.get("speed2X");
					SnookerOnline.speed2Y = (int) msgg.get("speed2Y");
					SnookerOnline.speed3X = (int) msgg.get("speed3X");
					SnookerOnline.speed3Y = (int) msgg.get("speed3Y");
					SnookerPaintPanelOnline.score = (int) msgg.get("score");
					SnookerPaintPanelOnline.score2 = (int) msgg.get("score2");
					GUI.name2 = (String) msgg.get("name");
					GUI.xox1 = (int) msgg.get("xox");
				} 
				catch (JSONException e) {}
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			} catch (ClassNotFoundException e) {
				displayMessage("\nUnknown object type received");
			}
//		}while(!msg.equals("CLIENT>>> TERMINATE"));
	}
	
	public void closeConnection() {
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false);
		
		try {
			output.close();
			input.close();
			connection.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendData(String message) {
		try {
			output.writeObject("hakan" + message);
			output.flush();
			displayMessage("\nSERVER>>> " + message);
		}
		catch (IOException e) {
			displayArea.append("\nError writing object");
		}
	}
	
	public void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				displayArea.append(messageToDisplay);
			}
		});
	}
	
	public void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				enterField.setEditable(editable);				
			}
		});
	}
}





