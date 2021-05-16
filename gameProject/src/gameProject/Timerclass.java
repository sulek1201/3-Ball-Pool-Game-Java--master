package gameProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Timerclass implements ActionListener{
	

	Timer ba=new Timer(1000,this);
	static int ic=0;
	
	public Timerclass() {
		
	}

	public Timerclass(Timer ba) {
		
	}


	public void actionPerformed(ActionEvent e) {
		ic++;
        if(30-ic==0) {
			ic=0;
		}
		System.out.println(ic);

	}
	
}
