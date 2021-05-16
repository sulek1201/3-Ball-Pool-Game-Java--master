package gameProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.io.IOException; 

public class GUIPanel extends JPanel{
	BufferedImage semih;

	
	public GUIPanel()
	{
		try
	    {
	    	BufferedImage semih = ImageIO.read(new FileImageInputStream(new File("semih_sayginer.jpg")));
	
	    	this.semih = semih;
	    
	    } 
	    catch (IOException e)
	    {
	    	System.out.println("Error: "+e);
	    }
	    
	}
	
	

	@Override
	public void paint (Graphics g) {
		super.paint(g);
		
//		g.drawLine(10,10,100,100);
//		g.drawRect(20, 20, 30, 40);
//		g.drawString("Hello", 700, 500);
//		
		//g.setColor(Color.yellow);
		//g.fillArc(Pacman.TOP1x,Pacman.TOP1y,25,25,Pacman.sAngle,Pacman.arcAngle);
		//g.setColor(Color.white);
		//g.fillArc(Pacman.TOP2x,Pacman.TOP2y,25,25,Pacman.sAngle,Pacman.arcAngle);
		//g.setColor(Color.red);
		//g.fillArc(Pacman.TOP3x,Pacman.TOP3y,25,25,Pacman.sAngle,Pacman.arcAngle);
		//g.setColor(Color.darkGray);
		//g.fillRoundRect(400, 280, 500, 10, 10, 60);
		//g.drawImage(img, x, y, observer)
	

		
		g.setColor(Color.black);

		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(semih, 0, 0, this);
		//g.drawImage(imgCue,200,400,this);
	
	}
}