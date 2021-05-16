package gameProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.io.IOException; 

public class SnookerPaintPanelPractice extends JPanel{
	
	protected static double stickX=200;
	protected static double stickY=0;
	protected static double whiteBallx=0;
	protected static double whiteBally=20;
	protected static int pwr=0;
	
	BufferedImage imgTable;
	BufferedImage imgCue;
	BufferedImage imgRedBall;
	BufferedImage imgWhiteBall;
	BufferedImage imgOrangeBall;
	BufferedImage bckgrnd;
	BufferedImage pwrBar;
	BufferedImage Player1;
	BufferedImage Player2;
	
	JLabel txtName;
	
	public SnookerPaintPanelPractice()
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
	    	this.imgTable = imgTable;
	    	this.imgCue = imgCue;
	    	this.imgRedBall = imgRedBall;
	    	this.imgWhiteBall = imgWhiteBall;
	    	this.imgOrangeBall = imgOrangeBall;
	    	this.bckgrnd = bckgrnd;
	    	this.pwrBar = pwrBar;
	    	this.Player1=Player1;
	    	this.Player2=Player2;
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
		g.drawImage(imgOrangeBall,(int)SnookerPractice.TOP1x,(int)SnookerPractice.TOP1y,this);
		g.drawImage(imgWhiteBall,(int)SnookerPractice.TOP2x,(int)SnookerPractice.TOP2y,this);
		g.drawImage(imgRedBall,(int)SnookerPractice.TOP3x,(int)SnookerPractice.TOP3y,this);
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(10));
		if(SnookerPractice.speed1X == 0 && SnookerPractice.speed1Y == 0 && SnookerPractice.speed2X == 0 && SnookerPractice.speed2Y == 0 && SnookerPractice.speed3X == 0 && SnookerPractice.speed3Y == 0) {
			g2d.drawLine((int)(SnookerPractice.TOP2x-stickX), (int)(SnookerPractice.TOP2y-stickY+20),(int) (SnookerPractice.TOP2x+whiteBallx),(int) (SnookerPractice.TOP2y+whiteBally));
		}
		g.drawImage(pwrBar,1450,300,this);
		g.setColor(Color.BLUE.brighter());
		g.fillRect(1651, 400, 75, pwr);

		
	}


}