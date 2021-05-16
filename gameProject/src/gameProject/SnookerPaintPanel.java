package gameProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JLabel;
import javax.swing.JPanel; 

public class SnookerPaintPanel extends JPanel{
	
	protected static double stickX=200;
	protected static double stickY=0;
	protected static double whiteBallx=0;
	protected static double whiteBally=20;
	protected static int pwr=0;
	protected static int score=46;
	protected static int score2=46;
	
	BufferedImage imgTable;
	BufferedImage imgCue;
	BufferedImage imgRedBall;
	BufferedImage imgWhiteBall;
	BufferedImage imgOrangeBall;
	BufferedImage bckgrnd;
	BufferedImage pwrBar;
	BufferedImage Player1;
	BufferedImage Player2;
	BufferedImage sýra1;
	BufferedImage sýra2;
	
	JLabel txtName;
	
	public SnookerPaintPanel()
	{
		try
	    {
	    	BufferedImage imgTable = ImageIO.read(new FileImageInputStream(new File("SnookerTable.png")));
	    	BufferedImage imgCue = ImageIO.read(new FileImageInputStream(new File("SnookerCue1.png")));
	    	BufferedImage imgRedBall = ImageIO.read(new FileImageInputStream(new File("SnookerRedBall.png")));
	    	BufferedImage imgWhiteBall = ImageIO.read(new FileImageInputStream(new File("SnookerWhiteBall.png")));
	    	BufferedImage imgOrangeBall = ImageIO.read(new FileImageInputStream(new File("SnookerOrangeBall.png")));
	    	BufferedImage bckgrnd = ImageIO.read(new FileImageInputStream(new File("bckgrnd.jpg")));
	    	BufferedImage pwrBar = ImageIO.read(new FileImageInputStream(new File("powerBar.png")));
	    	BufferedImage Player1=ImageIO.read(new FileImageInputStream(new File("screen-11.jpg")));
	    	BufferedImage Player2=ImageIO.read(new FileImageInputStream(new File("screen-12.jpg")));
	    	BufferedImage sýra1=ImageIO.read(new FileImageInputStream(new File("Backward1.png")));
	    	BufferedImage sýra2=ImageIO.read(new FileImageInputStream(new File("Forward1.png")));
	    	this.imgTable = imgTable;
	    	this.imgCue = imgCue;
	    	this.imgRedBall = imgRedBall;
	    	this.imgWhiteBall = imgWhiteBall;
	    	this.imgOrangeBall = imgOrangeBall;
	    	this.bckgrnd = bckgrnd;
	    	this.pwrBar = pwrBar;
	    	this.Player1=Player1;
	    	this.Player2=Player2;
	    	this.sýra1 = sýra1;
	    	this.sýra2 = sýra2;
	    } 
	    catch (IOException e)
	    {
	    	System.out.println("Error: "+e);
	    }
		
	    
	}
	public void rotateLeft() {

	     if(stickX==200) {
	    	 stickY+=10;
	     }
	     if(stickY==-200) {
	    	 stickX+=10;
	     }
	     if(stickX==-200) {
	    	 stickY-=10;
	     }
	     if(stickY==200) {
	    	 stickX-=10;
	     }
	     
	     if(whiteBallx==0) {
	    	 whiteBally-=1;
	     }
	     if(whiteBally==40) {
	    	 whiteBallx-=1;
	     }
	     if(whiteBallx==40) {
	    	 whiteBally+=1;
	     }
	     if(whiteBally==0) {
	    	 whiteBallx+=1;
	     }
	     repaint();

	   }
	
	public void rotateRight() {

	     if(stickX==200) {
	    	 stickY-=10;
	     }
	     if(stickY==-200) {
	    	 stickX-=10;
	     }
	     if(stickX==-200) {
	    	 stickY+=10;
	     }
	     if(stickY==200) {
	    	 stickX+=10;
	     }
	     
	     if(whiteBallx==0) {
	    	 whiteBally+=1;
	     }
	     if(whiteBally==40) {
	    	 whiteBallx+=1;
	     }
	     if(whiteBallx==40) {
	    	 whiteBally-=1;
	     }
	     if(whiteBally==0) {
	    	 whiteBallx-=1;
	     }
	     repaint();

	   }
	public void fillPower() {

		
	    if(pwr == 285) {
	    	pwr = 0;
	    }
	    else {
	    	pwr += 5;
	    }
	    repaint();

	   }

	@Override
	public void paint (Graphics g) {
		super.paint(g);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		
		
		g.drawImage(bckgrnd,0,0,this);
		g.drawImage(imgTable,400,200,this);
		g.drawImage(imgOrangeBall,(int)Snooker.TOP1x,(int)Snooker.TOP1y,this);
		g.drawImage(imgWhiteBall,(int)Snooker.TOP2x,(int)Snooker.TOP2y,this);
		g.drawImage(imgRedBall,(int)Snooker.TOP3x,(int)Snooker.TOP3y,this);
		g.drawImage(Player1,550,50,this);
		g.drawImage(Player2,1200,50,this);
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(10));
		if(Snooker.sýra_belirleyici == 0) {
			g.drawImage(sýra1,900,100,this);
		}
		if(Snooker.sýra_belirleyici == 1) {
			g.drawImage(sýra2,900,100,this);
		}
		if(Snooker.speed1X == 0 && Snooker.speed1Y == 0 && Snooker.speed2X == 0 && Snooker.speed2Y == 0 && Snooker.speed3X == 0 && Snooker.speed3Y == 0) {
			if (Snooker.sýra_belirleyici == 0) {
				//g2d.drawLine((int)(Snooker.TOP2x-stickX), (int)(Snooker.TOP2y-stickY+20),(int) (Snooker.TOP2x+whiteBallx),(int) (Snooker.TOP2y+whiteBally));
				if (GUI.xox == 0) {

					g2d.setColor(Color.BLACK);

					g2d.setStroke(new BasicStroke(10));

					g2d.drawLine((int) (Snooker.TOP2x - stickX), (int) (Snooker.TOP2y - stickY + 20),
							(int) (Snooker.TOP2x + whiteBallx), (int) (Snooker.TOP2y + whiteBally));

				} else if (GUI.xox == 1) {

					g2d.setColor(Color.RED);

					g2d.setStroke(new BasicStroke(10));

					g2d.drawLine((int) (Snooker.TOP2x - stickX), (int) (Snooker.TOP2y - stickY + 20),
							(int) (Snooker.TOP2x + whiteBallx), (int) (Snooker.TOP2y + whiteBally));

				}

				else if (GUI.xox == 2) {

					g2d.setColor(Color.YELLOW);

					g2d.setStroke(new BasicStroke(10));

					g2d.drawLine((int) (Snooker.TOP2x - stickX), (int) (Snooker.TOP2y - stickY + 20),
							(int) (Snooker.TOP2x + whiteBallx), (int) (Snooker.TOP2y + whiteBally));

				} 
			}
			else if(Snooker.sýra_belirleyici == 1) {
				if (GUI.xox1 == 0) {

					g2d.setColor(Color.BLACK);

					g2d.setStroke(new BasicStroke(10));

					g2d.drawLine((int) (Snooker.TOP2x - stickX), (int) (Snooker.TOP2y - stickY + 20),
							(int) (Snooker.TOP2x + whiteBallx), (int) (Snooker.TOP2y + whiteBally));

				} else if (GUI.xox1 == 1) {

					g2d.setColor(Color.RED);

					g2d.setStroke(new BasicStroke(10));

					g2d.drawLine((int) (Snooker.TOP2x - stickX), (int) (Snooker.TOP2y - stickY + 20),
							(int) (Snooker.TOP2x + whiteBallx), (int) (Snooker.TOP2y + whiteBally));

				}

				else if (GUI.xox1 == 2) {

					g2d.setColor(Color.YELLOW);

					g2d.setStroke(new BasicStroke(10));

					g2d.drawLine((int) (Snooker.TOP2x - stickX), (int) (Snooker.TOP2y - stickY + 20),
							(int) (Snooker.TOP2x + whiteBallx), (int) (Snooker.TOP2y + whiteBally));

				} 
			}
		}
		g.drawImage(pwrBar,1450,300,this);
		g.setColor(Color.BLUE.brighter());
		g.fillRect(1651, 400, 75, pwr);
		g.setColor(Color.MAGENTA);
		g.setFont(new Font("Courier New", Font.BOLD, 30));
		
		if(score>=50) {
			FileOutputStream fos = null;

			String s = null;

		    try {

		    	fos = new FileOutputStream("dosya.txt",true);

		        s = GUI.name1 + ", ";

		        byte[] s_array = s.getBytes();

		        fos.write(s_array);

		        } catch (FileNotFoundException ex) {

		            System.out.println("File Not found exception oluþtu....");

		        } catch (IOException ex) {

		            System.out.println("Dosyaya yazýlýrken bir hata oluþtu...");

		        }
		        finally{
		        	
		            try {

		                fos.close();

		            } catch (IOException ex) {
		            	
		                System.out.println("Dosya kapatýlýrken bir hata oluþtu...");
		                
		            }
		        }
			g.setFont(new Font("Courier New", Font.BOLD, 60));
			g.drawString("YOU WÝN ", 800, 800);
		}
		if(score2>=50) {
			FileOutputStream fos = null;

			String s = null;

		        try {

		            fos = new FileOutputStream("dosya.txt",true);

		            s = GUI.name2 + ", ";

		            byte[] s_array = s.getBytes();

		            fos.write(s_array);

		        } catch (FileNotFoundException ex) {

		            System.out.println("File Not found exception oluþtu....");

		        } catch (IOException ex) {

		            System.out.println("Dosyaya yazýlýrken bir hata oluþtu...");

		        }

		        finally{
		        	try {

		                fos.close();

		            } catch (IOException ex) {

		                System.out.println("Dosya kapatýlýrken bir hata oluþtu...");

		            }
		        }
			g.setFont(new Font("Courier New", Font.BOLD, 60));
			g.drawString("YOU WÝN ", 800, 800);
	
		}
		
		g.setFont(new Font("Courier New", Font.BOLD, 35));
		g.drawString(GUI.name1, 680, 80);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier New", Font.BOLD, 35));
		g.drawString(GUI.name2, 1330, 80);
		
		g.setFont(new Font("Courier New", Font.BOLD, 25));
		g.setColor(Color.MAGENTA);
		g.drawString("Score : " + score, 680, 120);
		
		g.setFont(new Font("Courier New", Font.BOLD, 25));
		g.setColor(Color.MAGENTA);
		g.drawString("Score : " + score2, 1330, 120);
		
		
		g.drawString("Remaining Time :"+(30-Timerclass.ic), 820, 70);

		
	}


}