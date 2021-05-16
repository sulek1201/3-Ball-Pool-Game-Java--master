package gameProject;

import java.awt.BorderLayout;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.json.*;



public class Client extends JFrame  {

	private JTextField enterField;
	private JTextArea displayArea;
	public ObjectOutputStream output;
	private ObjectInputStream input;
	protected static String message = "";
	protected static String msg = "";
	private String chatServer;
	private Socket client;
	
	public Client(String host) {
		
		
		super("Client");

		chatServer = host;
		
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea),BorderLayout.CENTER);
		
		setSize(300,100);
		setVisible(true);
	}
	
	
	public void runClient() {
				
		
				try {
					connectToServer();
					getStreams();
				}
				catch (EOFException e) {
					displayMessage("\nClient terminated connection");
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					closeConnection();					
				}		
	}
	
	public void connectToServer() throws IOException{
		displayMessage("Attempting connection\n");
		
		client = new Socket(InetAddress.getByName(chatServer),12345);
		
		displayMessage("Connected to: " + client.getInetAddress().getHostName());
		
	}
	
	public void getStreams() throws IOException{
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		
		input = new ObjectInputStream(client.getInputStream());
		
		displayMessage("\nGot I/O streams\n");
	}
	
	public void processConnection() throws IOException{
		String message ;

			try {
				message = (String) input.readObject();
				System.out.println(message);
				JSONObject messega=new JSONObject();
				try {
					messega=new JSONObject(message);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					SnookerOnline.TOP1x=(int)messega.get("TOP1x");
					SnookerOnline.TOP1y=(int)messega.get("TOP1y");
					SnookerOnline.TOP2x=(int)messega.get("TOP2x");
					SnookerOnline.TOP2y=(int)messega.get("TOP2y");
					SnookerOnline.TOP3x=(int)messega.get("TOP3x");
					SnookerOnline.TOP3y=(int)messega.get("TOP3y");
					
					SnookerOnline.speed1X=(int)messega.get("speed1X");
					SnookerOnline.speed1Y=(int)messega.get("speed1Y");
					SnookerOnline.speed2X=(int)messega.get("speed2X");
					SnookerOnline.speed2Y=(int)messega.get("speed2Y");
					SnookerOnline.speed3X=(int)messega.get("speed3X");
					SnookerOnline.speed3Y=(int)messega.get("speed3Y");
					
					GUI.name2=(String)messega.get("name");
					GUI.xox1=(int)messega.get("xox");
				
					SnookerPaintPanelOnline.score=(int)messega.get("score");
					SnookerPaintPanelOnline.score2=(int)messega.get("score2");
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void closeConnection() {
		displayMessage("\nClosing connection\n");
		setTextFieldEditable(false);
		
		try {
			output.close();
			input.close();
			client.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendData(String message) {
		try {
			output.writeObject("" + message);
			output.flush();
			displayMessage("\nCLIENT>>> " + message);
			msg = message;
			
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





