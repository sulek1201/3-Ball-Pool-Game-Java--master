package gameProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.json.JSONException;
import org.json.JSONObject;

public class GUI extends JFrame implements ActionListener {

	JFrame frame;
	static String name1;
	static String name2;
	
	static JSONObject JSON = new JSONObject();
	
	Timer ac =new Timer(1,this);

	JPanel  p, k, jp;

	JButton button;

	JButton buton;

	JButton buton3;

	JButton butonOnline;

	BufferedImage semih;

	protected static int xox;

	protected static int xox1;
	
	protected static int cnt;
	
	protected static int counter;
	
	Server application = new Server();
	
//	Client application1 = new Client("192.168.43.175");

	public GUI() {

		p = new GUIPanel();
		k = new GUIPanel();
		JButton buton5 = new JButton("BACK");

		buton5.setBounds(10, 275, 120, 45);
		JLabel lblNewLabel2 = new JLabel("Bugra Mert Ayar 1730080 ");

		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 21));

		lblNewLabel2.setBounds(10, 100, 500, 200);
		JLabel lblNewLabel3 = new JLabel("Hakan Yýldýz 1602268 ");

		lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 21));

		lblNewLabel3.setBounds(10, 150, 500, 200);
		JLabel lblNewLabel4 = new JLabel("Anýl Þülekoðlu 1602414");

		lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, 21));

		lblNewLabel4.setBounds(10, 50, 500, 200);
		lblNewLabel2.setForeground(Color.yellow);
		lblNewLabel3.setForeground(Color.yellow);
		lblNewLabel4.setForeground(Color.yellow);

		JLabel lblNewLabel5 = new JLabel("Bugra Mert Ayar \n Hakan Yýldýz \n Anýl Þülekoðlu");

		lblNewLabel5.setFont(new Font("Tahoma", Font.PLAIN, 21));

		lblNewLabel5.setBounds(10, 50, 500, 200);
		
		String ogrenci_bilgisi = null;

		try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("dosya.txt")))) {

			while (scanner.hasNextLine()) {

				ogrenci_bilgisi = scanner.nextLine();

			}
		} catch (FileNotFoundException ex) {

			System.out.println("Dosya Bulunamadý...");

		} catch (IOException ex) {

			System.out.println("Dosya açýlýrken bir hata oluþtu....");

		}

		String msj = ("<html><h1> </h1> 50 - "+ogrenci_bilgisi)+

				"<br/> " + "</html>";

		JLabel lblNewLabel6 = new JLabel("50- " + ogrenci_bilgisi);
		
		lblNewLabel6.setFont(new Font("Tahoma", Font.PLAIN, 21));

		lblNewLabel6.setBounds(10, 50, 500, 200);

		lblNewLabel6.setForeground(Color.GREEN);

		Timerclass d = new Timerclass();
		add(p);

		try {
			BufferedImage semih = ImageIO.read(new FileImageInputStream(new File("semih_sayginer.jpg")));

			this.semih = semih;

		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

		JButton buton8 = new JButton("PRACTÝCE GAME");

		buton8.setBounds(10, 190, 180, 60);

		p.add(buton8);

		buton8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent _event) {

				SnookerPractice up = new SnookerPractice();

				setVisible(false);

				up.setSize(1920, 1080);

				up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				up.setVisible(true);

				up.t.start();

				d.ba.start();

			}

		});

		button = new JButton("TWO PLAYER");

		p.setLayout(null);

		button.setBounds(10, 276, 180, 60);

		p.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				String baslik = "CUES";

				String[] options = { "BLACK", "RED", "YELLOW" };

				name1 = JOptionPane.showInputDialog("Enter name 1 :");

				name2 = JOptionPane.showInputDialog("Enter name 2 :");

				xox = JOptionPane.showOptionDialog(null,
						"Choose your Cue " + name1
								+ "\n Black ->Powerfull \n Red -> More point gain \n Yellow ->Less point loss ",
						baslik, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

				xox1 = JOptionPane.showOptionDialog(null,
						"Choose your Cue " + name2
								+ "\n Black ->Powerfull \n Red -> More point gain \n Yellow ->Less point loss ",
						baslik, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

				Snooker c = new Snooker();
				setVisible(false);
				c.setSize(1920, 1080);
				c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				c.setVisible(true);
				c.t.start();
				d.ba.start();

			}

		});

		JButton buton4 = new JButton("EXIT");

		buton4.setBounds(10, 900, 120, 45);

		p.add(buton4);

		buton4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent _event) {

				setVisible(false);

				System.exit(0);

			}

		});

		JButton buton2 = new JButton("HIGH SCORES");

		buton2.setBounds(10, 448, 180, 60);

		p.add(buton2);

		JButton buton3 = new JButton("DEVELOPERS");

		buton3.setBounds(10, 534, 180, 60);

		p.add(buton3);

		butonOnline = new JButton("ONLINE GAME");
		butonOnline.setBounds(10, 362, 180, 60);
		p.add(butonOnline);
		SnookerOnline f = new SnookerOnline();
		butonOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				String baslikk = "CUES";

				String[] optionss = { "BLACK", "RED", "YELLOW" };

				name1 = JOptionPane.showInputDialog("Enter name 1 :");

				name2 = "";

				xox = JOptionPane.showOptionDialog(null,
						"Choose your Cue " + name1
								+ "\n Black ->Powerfull \n Red -> More point gain \n Yellow ->Less point loss ",
						baslikk, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionss, optionss[0]);
				
				try {
					JSON.put("name", name1);
					JSON.put("xox", xox);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				setVisible(false);
				f.setSize(1920, 1080);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				f.t.start();
				d.ba.start();
				ac.start();

			}

		});

		buton3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent _event) {

				k.setLayout(null);
				k.remove(lblNewLabel5);
				k.remove(lblNewLabel6);
				k.add(buton5);
				k.add(lblNewLabel2);
				k.add(lblNewLabel3);
				k.add(lblNewLabel4);
				p.setVisible(false);
				add(k);
				k.setVisible(true);

				SwingUtilities.updateComponentTreeUI(k);
			}

		});

		buton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent _event) {

				k.setVisible(false);
				p.setVisible(true);

			}
		});

		buton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent _event) {

				k.setLayout(null);
				k.remove(lblNewLabel2);
				k.remove(lblNewLabel3);
				k.remove(lblNewLabel4);
				k.add(buton5);
				p.setVisible(false);
				add(k);
				k.setVisible(true);
				k.add(lblNewLabel6);

				SwingUtilities.updateComponentTreeUI(k);

				}

			});

		JLabel lblNewLabel = new JLabel("3- BALL SNOOKER");

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));

		lblNewLabel.setBounds(800, 11, 350, 150);
		lblNewLabel.setForeground(Color.yellow);

		getContentPane().add(lblNewLabel);

		getContentPane().add(p);

		setDefaultCloseOperation(3);

		setSize(1920, 1080);

		setVisible(true);
		
		
		
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			application.server = new ServerSocket(12345,100);
				try {
					application.waitForConnection();
					application.getStreams();
					
				}
				catch (EOFException e) {
					application.displayMessage("\nServer terminated connection");
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		application1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		try {
//			application1.connectToServer();
//			application1.getStreams();
//			
//				
//				
//		
//			
//		}
//		catch (EOFException e) {
//			application1.displayMessage("\nClient terminated connection");
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.drawImage(semih, 0, 0, this);
	}

	public static void main(String[] args) {

		// TODO code application logic here

		new GUI();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		 TODO Auto-generated method stub
		
		if(SnookerOnline.sýra_belirleyici == 0) {
			System.out.println("alýcý");
			try {
			application.processConnection();
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1);
			}
		}
		if (SnookerOnline.sýra_belirleyici == 1) {
			System.out.println("gönderici");
			try {
				application.output.writeObject(JSON.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(e1);
			}
			
//			try {
//				application1.output.writeObject(JSON.toString());
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//				System.out.println(e1);
//			}
		}
		
		
	}
}
