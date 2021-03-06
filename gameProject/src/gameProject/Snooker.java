package gameProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snooker extends JFrame implements KeyListener, ActionListener {

	JPanel jp;
	protected static double TOP1x;
	protected static double TOP1y;
	protected static double TOP2x;
	protected static double TOP2y;
	protected static double TOP3x;
	protected static double TOP3y;
	protected static double speed1X;
	protected static double speed1Y;
	protected static double speed2X;
	protected static double speed2Y;
	protected static double speed3X;
	protected static double speed3Y;
	protected static double power;
	protected static int spdcntr;
	protected static int ctr;
	protected static int counter12;
	protected static int counter13;
	protected static int counter23;
	protected static int s?ra_belirleyici = 0;
	protected static int abc = 0;
	protected static int yoy;
	protected static String xox4;
	
	Timer t = new Timer(1, this);
	double rad12 = 0.0;
	double rad13 = 0.0;
	double rad23 = 0.0;
	SnookerPaintPanel cuk = new SnookerPaintPanel();

	public Snooker() {

		jp = new SnookerPaintPanel();

		add(jp);
		addKeyListener(this);

		TOP1x = 1000.0;
		TOP1y = 600.0;
		TOP2x = 1200.0;
		TOP2y = 500.0;
		TOP3x = 700.0;
		TOP3y = 700.0;
		speed1X = 0.0;
		speed1Y = 0.0;
		speed2X = 0.0;
		speed2Y = 0.0;
		speed3X = 0.0;
		speed3Y = 0.0;
		power = 0.0;
		spdcntr = 0;

	}

	public void actionPerformed(ActionEvent e) {

		TOP1x = TOP1x + speed1X;
		TOP1y = TOP1y + speed1Y;
		TOP2x = TOP2x + speed2X;
		TOP2y = TOP2y + speed2Y;
		TOP3x = TOP3x + speed3X;
		TOP3y = TOP3y + speed3Y;
	
		
		spdcntr++;
		repaint();

		if (Math.abs(speed1X) < 0.011 && Math.abs(speed1Y) < 0.011) {
			speed1X = 0.0;
			speed1Y = 0.0;
		}

		if (Math.abs(speed2X) < 0.011 && Math.abs(speed2Y) < 0.011) {
			speed2X = 0.0;
			speed2Y = 0.0;
		}

		if (Math.abs(speed3X) < 0.011 && Math.abs(speed3Y) < 0.011) {
			speed3X = 0.0;
			speed3Y = 0.0;
		}
		if (Math.abs((TOP1x + speed1X) - (TOP2x + speed2X)) < 27.5
				&& Math.abs((TOP1y + speed1Y) - (TOP2y + speed2Y)) < 27.5) {
			while (Math.abs(TOP1x - TOP2x) > 27.5 || Math.abs(TOP1y - TOP2y) > 27.5) {
				TOP1x = TOP1x + (speed1X / 100);
				TOP1y = TOP1y + (speed1Y / 100);
				TOP2x = TOP2x + (speed2X / 100);
				TOP2y = TOP2y + (speed2Y / 100);

			}

			rad12 = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
		} else {

			rad12 = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
		}

		if ((Math.abs(TOP1x - TOP2x) < 27.5 && Math.abs(TOP1y - TOP2y) < 27.5)) {
			
			counter12=1;

			System.out.println("Sar? Beyaz Top A??: " + Math.toDegrees(rad12));

			if ((speed1X != 0 || speed1Y != 0) && (speed2X != 0 || speed2Y != 0)) {
				double tempX = speed2X;
				double tempY = speed2Y;

				speed2X = speed1X;
				speed2Y = speed1Y;
				speed1X = tempX;
				speed1Y = tempY;
				
//				while (Math.abs(TOP1x - TOP2x) < 27.5 || Math.abs(TOP1y - TOP2y) < 27.5) {
//					TOP1x = TOP1x + (speed1X / 100);
//					TOP1y = TOP1y + (speed1Y / 100);
//					TOP2x = TOP2x + (speed2X / 100);
//					TOP2y = TOP2y + (speed2Y / 100);
//
//				}
			}

			if ((speed1X == 0 && speed1Y == 0) && (speed2X == 0 && speed2Y < 0)) {
				// Topa direkt alttan, alt soldan ve alt sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == -90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -48) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= -48 && Math.toDegrees(radian) <= -42) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2Y) * Math.cos(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= 0) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -138) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > -138 && Math.toDegrees(radian) < -132) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2Y) * Math.cos(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) < -90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed2Y == 0 && speed2X < 0)) {
				// Topa direkt sa?dan, sa? ?stten ve sa? alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 180) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 138) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) <= 138 && Math.toDegrees(radian) >= 132) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
					speed2X = 0;
				}
				if (Math.toDegrees(radian) < 132 && Math.toDegrees(radian) >= 90) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -138) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) <= -132) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
					speed2X = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) <= -90) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed2Y == 0 && speed2X > 0)) {
				// Topa direkt soldan, sol ?stten ve sol alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 0) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 90 && Math.toDegrees(radian) > 48) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 48 && Math.toDegrees(radian) >= 42) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) < 42 && Math.toDegrees(radian) > 0) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) < 0) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -48 && Math.toDegrees(radian) < -42) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
					speed2X = 0;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -48) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed2X == 0 && speed2Y > 0)) {
				// Topa direkt ?stten, ?st soldan ve ?st sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 48 && Math.toDegrees(radian) < 90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 42 && Math.toDegrees(radian) <= 48) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) >= 0 && Math.toDegrees(radian) < 42) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 132) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) <= 138) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 180) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}

			}
			if ((speed1X == 0 && speed1Y == 0) && (speed2X < 0 && speed2Y < 0)) {
				// Topa -,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) >= 90) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian));
					speed2X = (-Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (-Math.abs(speed2Y) * Math.sin(radian));
					speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (-Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == 180) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -157) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (-Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -132) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) < -132) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) >= -132 && Math.toDegrees(radian) < -112.5) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed2X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) == -90) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -67.6) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -45) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -45 && Math.toDegrees(radian) < -22.5) {
					speed1Y = (Math.abs(speed2X) * Math.sin(radian));
					speed1X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -22.5 && Math.toDegrees(radian) < 0) {
					speed1Y = (Math.abs(speed2X) * Math.sin(radian));
					speed1X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * Math.sin(radian);
				}

			}
			if ((speed1X == 0 && speed1Y == 0) && (speed2X > 0 && speed2Y < 0)) {
				// Topa +,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -157) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -135) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -135 && Math.toDegrees(radian) < -112.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == -90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * 1.2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) <= -67.6) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > -67.6 && Math.toDegrees(radian) <= -48) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian));
					speed2X = -(Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -42 && Math.toDegrees(radian) > -48) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= -22.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > -22.5 && Math.toDegrees(radian) < 0) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) <= 22.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 22.5 && Math.toDegrees(radian) <= 43) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 43 && Math.toDegrees(radian) <= 47) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > 47 && Math.toDegrees(radian) <= 67.6) {
					speed1Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed2Y) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 67.6 && Math.toDegrees(radian) <= 90) {
					speed1Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed2Y) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed2X > 0 && speed2Y > 0)) {
				// Topa +,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed1Y = Math.abs(speed2X) * Math.sin(radian);
					speed1X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian));
					speed2X = (Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) > 90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian));
					speed2X = (Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * 1.2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) < 90 && Math.toDegrees(radian) > 67.6) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 67.6 && Math.toDegrees(radian) > 47) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 47 && Math.toDegrees(radian) > 43) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) <= 43 && Math.toDegrees(radian) > 22.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 22.5 && Math.toDegrees(radian) > 0) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) < 0 && Math.toDegrees(radian) >= -22.5) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -40 && Math.toDegrees(radian) < -22.5) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -47 && Math.toDegrees(radian) < -43) {
					if (speed2Y < 1) {
						speed1Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
						speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
						speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 2;
					} else {
						speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
						speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
						speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -47) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = Math.abs(speed2Y) * Math.cos(radian);
					speed2X = -Math.abs(speed2X) * Math.sin(radian) / 1.2;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -67.6) {
					speed1Y = (Math.abs(speed2X) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed2Y) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.sin(radian);
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed2X < 0 && speed2Y > 0)) {
				// Topa -,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP2y), (TOP1x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) < 22.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 22.5 && Math.toDegrees(radian) < 45) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 45 && Math.toDegrees(radian) < 67.6) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian));
					speed2X = -(Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= 67.6 && Math.toDegrees(radian) < 90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian));
					speed2X = -(Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2X) * 1.2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 112.5) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 112.5 && Math.toDegrees(radian) < 132) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) < 138) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 157) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > 157 && Math.toDegrees(radian) < 180) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian);
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 2;
				}

				if (Math.toDegrees(radian) == 180) {
					speed1Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) <= -157 && Math.toDegrees(radian) >= -180) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= -138 && Math.toDegrees(radian) > -157) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian));
					speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -132 && Math.toDegrees(radian) > -138) {
					if (speed2Y < 1) {
						speed1Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
						speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
						speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 2;
					} else {
						speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
						speed1X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
						speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) <= -112.5 && Math.toDegrees(radian) > -132) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed2X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) <= -90 && Math.toDegrees(radian) > -112.5) {
					speed1Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed2X) * Math.cos(radian);
				}
			}

//*********************************************************************************************
			if ((speed2X == 0 && speed2Y == 0) && (speed1X == 0 && speed1Y < 0)) {
				// Topa direkt alttan, alt soldan ve alt sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == -90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -48) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= -48 && Math.toDegrees(radian) <= -42) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = 0;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= 0) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -138) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > -138 && Math.toDegrees(radian) < -132) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1Y) * Math.cos(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) < -90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed1Y == 0 && speed1X < 0)) {
				// Topa direkt sa?dan, sa? ?stten ve sa? alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 180) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 138) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) <= 138 && Math.toDegrees(radian) >= 132) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
					speed1X = 0;
				}
				if (Math.toDegrees(radian) < 132 && Math.toDegrees(radian) >= 90) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -138) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) <= -132) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
					speed1X = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) <= -90) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed1Y == 0 && speed1X > 0)) {
				// Topa direkt soldan, sol ?stten ve sol alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 0) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 90 && Math.toDegrees(radian) > 48) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 48 && Math.toDegrees(radian) >= 42) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) < 42 && Math.toDegrees(radian) > 0) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) < 0) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -48 && Math.toDegrees(radian) < -42) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -48) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed1X == 0 && speed1Y > 0)) {
				// Topa direkt ?stten, ?st soldan ve ?st sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 48 && Math.toDegrees(radian) < 90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 42 && Math.toDegrees(radian) <= 48) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) >= 0 && Math.toDegrees(radian) < 42) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 132) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) <= 138) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 180) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}

			}
			if ((speed2X == 0 && speed2Y == 0) && (speed1X < 0 && speed1Y < 0)) {
				// Topa -,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) >= 90) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian));
					speed1X = (-Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (-Math.abs(speed1Y) * Math.sin(radian));
					speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (-Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == 180) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -157) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (-Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -132) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) < -132) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) >= -132 && Math.toDegrees(radian) < -112.5) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed1X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) == -90) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -67.6) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -45) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -45 && Math.toDegrees(radian) < -22.5) {
					speed2Y = (Math.abs(speed1X) * Math.sin(radian));
					speed2X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -22.5 && Math.toDegrees(radian) < 0) {
					speed2Y = (Math.abs(speed1X) * Math.sin(radian));
					speed2X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * Math.sin(radian);
				}

			}
			if ((speed2X == 0 && speed2Y == 0) && (speed1X > 0 && speed1Y < 0)) {
				// Topa +,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -157) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -135) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -135 && Math.toDegrees(radian) < -112.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == -90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * 1.2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) <= -67.6) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > -67.6 && Math.toDegrees(radian) <= -48) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian));
					speed1X = -(Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -42 && Math.toDegrees(radian) > -48) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= -22.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > -22.5 && Math.toDegrees(radian) < 0) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) <= 22.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 22.5 && Math.toDegrees(radian) <= 43) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 43 && Math.toDegrees(radian) <= 47) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > 47 && Math.toDegrees(radian) <= 67.6) {
					speed2Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed1Y) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 67.6 && Math.toDegrees(radian) <= 90) {
					speed2Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed1Y) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed1X > 0 && speed1Y > 0)) {
				// Topa +,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed2Y = Math.abs(speed1X) * Math.sin(radian);
					speed2X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian));
					speed1X = (Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) > 90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian));
					speed1X = (Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * 1.2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) < 90 && Math.toDegrees(radian) > 67.6) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 67.6 && Math.toDegrees(radian) > 47) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 47 && Math.toDegrees(radian) > 43) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) <= 43 && Math.toDegrees(radian) > 22.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 22.5 && Math.toDegrees(radian) > 0) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) < 0 && Math.toDegrees(radian) >= -22.5) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -40 && Math.toDegrees(radian) < -22.5) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -47 && Math.toDegrees(radian) < -43) {
					if (speed1Y < 1) {
						speed2Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
						speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
						speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 2;
					} else {
						speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
						speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
						speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -47) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = Math.abs(speed1Y) * Math.cos(radian);
					speed1X = -Math.abs(speed1X) * Math.sin(radian) / 1.2;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -67.6) {
					speed2Y = (Math.abs(speed1X) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed1Y) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.sin(radian);
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed1X < 0 && speed1Y > 0)) {
				// Topa -,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP1y), (TOP2x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) < 22.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 22.5 && Math.toDegrees(radian) < 45) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 45 && Math.toDegrees(radian) < 67.6) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian));
					speed1X = -(Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= 67.6 && Math.toDegrees(radian) < 90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian));
					speed1X = -(Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1X) * 1.2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 112.5) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 112.5 && Math.toDegrees(radian) < 132) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) < 138) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 157) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > 157 && Math.toDegrees(radian) < 180) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian);
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 2;
				}

				if (Math.toDegrees(radian) == 180) {
					speed2Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) <= -157 && Math.toDegrees(radian) >= -180) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= -138 && Math.toDegrees(radian) > -157) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian));
					speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -132 && Math.toDegrees(radian) > -138) {
					if (speed1Y < 1) {
						speed2Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
						speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
						speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 2;
					} else {
						speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
						speed2X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
						speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) <= -112.5 && Math.toDegrees(radian) > -132) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed1X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) <= -90 && Math.toDegrees(radian) > -112.5) {
					speed2Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed1X) * Math.cos(radian);
				}
			}

		}

//*********************************************************************************************

		if (Math.abs((TOP1x + speed1X) - (TOP3x + speed3X)) < 27.5
				&& Math.abs((TOP1y + speed1Y) - (TOP3y + speed3Y)) < 27.5) {
			while (Math.abs(TOP1x - TOP3x) > 27.5 || Math.abs(TOP1y - TOP3y) > 27.5) {
				TOP1x = TOP1x + (speed1X / 100);
				TOP1y = TOP1y + (speed1Y / 100);
				TOP3x = TOP3x + (speed3X / 100);
				TOP3y = TOP3y + (speed3Y / 100);

			}

			rad13 = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
		} else {
			
			rad13 = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
		}

		if ((Math.abs(TOP1x - TOP3x) < 27.5 && Math.abs(TOP1y - TOP3y) < 27.5)) {
			
			counter13=1;

			System.out.println("Sar? K?rm?z? Top A??: " + Math.toDegrees(rad13));
			
			if ((speed1X != 0 || speed1Y != 0) && (speed3X != 0 || speed3Y != 0)) {
				double tempX = speed3X;
				double tempY = speed3Y;

				speed3X = speed1X;
				speed3Y = speed1Y;
				speed1X = tempX;
				speed1Y = tempY;
				
//				while (Math.abs(TOP1x - TOP3x) < 27.5 || Math.abs(TOP1y - TOP3y) < 27.5) {
//					TOP1x = TOP1x + (speed1X / 100);
//					TOP1y = TOP1y + (speed1Y / 100);
//					TOP3x = TOP3x + (speed3X / 100);
//					TOP3y = TOP3y + (speed3Y / 100);
//
//				}
			}

			if ((speed1X == 0 && speed1Y == 0) && (speed3X == 0 && speed3Y < 0)) {
				// Topa direkt alttan, alt soldan ve alt sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == -90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -48) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= -48 && Math.toDegrees(radian) <= -42) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3Y) * Math.cos(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= 0) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -138) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > -138 && Math.toDegrees(radian) < -132) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3Y) * Math.cos(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) < -90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed3Y == 0 && speed3X < 0)) {
				// Topa direkt sa?dan, sa? ?stten ve sa? alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 180) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 138) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) <= 138 && Math.toDegrees(radian) >= 132) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
					speed3X = 0;
				}
				if (Math.toDegrees(radian) < 132 && Math.toDegrees(radian) >= 90) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -138) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) <= -132) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
					speed3X = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) <= -90) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed3Y == 0 && speed3X > 0)) {
				// Topa direkt soldan, sol ?stten ve sol alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 0) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 90 && Math.toDegrees(radian) > 48) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 48 && Math.toDegrees(radian) >= 42) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) < 42 && Math.toDegrees(radian) > 0) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) < 0) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -48 && Math.toDegrees(radian) < -42) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -48) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed3X == 0 && speed3Y > 0)) {
				// Topa direkt ?stten, ?st soldan ve ?st sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 48 && Math.toDegrees(radian) < 90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 42 && Math.toDegrees(radian) <= 48) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) >= 0 && Math.toDegrees(radian) < 42) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 132) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) <= 138) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 180) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}

			}
			if ((speed1X == 0 && speed1Y == 0) && (speed3X < 0 && speed3Y < 0)) {
				// Topa -,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) >= 90) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian));
					speed3X = (-Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (-Math.abs(speed3Y) * Math.sin(radian));
					speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (-Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == 180) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -157) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (-Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -132) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) < -132) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) >= -132 && Math.toDegrees(radian) < -112.5) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed3X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) == -90) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -67.6) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -45) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -45 && Math.toDegrees(radian) < -22.5) {
					speed1Y = (Math.abs(speed3X) * Math.sin(radian));
					speed1X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -22.5 && Math.toDegrees(radian) < 0) {
					speed1Y = (Math.abs(speed3X) * Math.sin(radian));
					speed1X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * Math.sin(radian);
				}

			}
			if ((speed1X == 0 && speed1Y == 0) && (speed3X > 0 && speed3Y < 0)) {
				// Topa +,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -157) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -135) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -135 && Math.toDegrees(radian) < -112.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == -90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * 1.2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) <= -67.6) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > -67.6 && Math.toDegrees(radian) <= -48) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian));
					speed3X = -(Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -42 && Math.toDegrees(radian) > -48) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= -22.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > -22.5 && Math.toDegrees(radian) < 0) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) <= 22.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 22.5 && Math.toDegrees(radian) <= 43) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 43 && Math.toDegrees(radian) <= 47) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > 47 && Math.toDegrees(radian) <= 67.6) {
					speed1Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed3Y) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 67.6 && Math.toDegrees(radian) <= 90) {
					speed1Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
					speed1X = (Math.abs(speed3Y) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed3X > 0 && speed3Y > 0)) {
				// Topa +,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed1Y = Math.abs(speed3X) * Math.sin(radian);
					speed1X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian));
					speed3X = (Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) > 90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian));
					speed3X = (Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * 1.2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) < 90 && Math.toDegrees(radian) > 67.6) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 67.6 && Math.toDegrees(radian) > 47) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 47 && Math.toDegrees(radian) > 43) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) <= 43 && Math.toDegrees(radian) > 22.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 22.5 && Math.toDegrees(radian) > 0) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) < 0 && Math.toDegrees(radian) >= -22.5) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -40 && Math.toDegrees(radian) < -22.5) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -47 && Math.toDegrees(radian) < -43) {
					if (speed3Y < 1) {
						speed1Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
						speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
						speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 2;
					} else {
						speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
						speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
						speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -47) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = Math.abs(speed3Y) * Math.cos(radian);
					speed3X = -Math.abs(speed3X) * Math.sin(radian) / 1.2;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -67.6) {
					speed1Y = (Math.abs(speed3X) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed3Y) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.sin(radian);
				}
			}
			if ((speed1X == 0 && speed1Y == 0) && (speed3X < 0 && speed3Y > 0)) {
				// Topa -,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP1y - TOP3y), (TOP1x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) < 22.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 22.5 && Math.toDegrees(radian) < 45) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 45 && Math.toDegrees(radian) < 67.6) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian));
					speed3X = -(Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= 67.6 && Math.toDegrees(radian) < 90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian));
					speed3X = -(Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3X) * 1.2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 112.5) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 112.5 && Math.toDegrees(radian) < 132) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) < 138) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 157) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > 157 && Math.toDegrees(radian) < 180) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian);
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 2;
				}

				if (Math.toDegrees(radian) == 180) {
					speed1Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) <= -157 && Math.toDegrees(radian) >= -180) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= -138 && Math.toDegrees(radian) > -157) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian));
					speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -132 && Math.toDegrees(radian) > -138) {
					if (speed3Y < 1) {
						speed1Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
						speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
						speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 2;
					} else {
						speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
						speed1X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
						speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) <= -112.5 && Math.toDegrees(radian) > -132) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed3X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) <= -90 && Math.toDegrees(radian) > -112.5) {
					speed1Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed3X) * Math.cos(radian);
				}
			}

//*********************************************************************************************
			if ((speed3X == 0 && speed3Y == 0) && (speed1X == 0 && speed1Y < 0)) {
				// Topa direkt alttan, alt soldan ve alt sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == -90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -48) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= -48 && Math.toDegrees(radian) <= -42) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1Y) * Math.cos(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= 0) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -138) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > -138 && Math.toDegrees(radian) < -132) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1Y) * Math.cos(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) < -90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed1Y == 0 && speed1X < 0)) {
				// Topa direkt sa?dan, sa? ?stten ve sa? alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 180) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 138) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) <= 138 && Math.toDegrees(radian) >= 132) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
					speed1X = 0;
				}
				if (Math.toDegrees(radian) < 132 && Math.toDegrees(radian) >= 90) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -138) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) <= -132) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
					speed1X = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) <= -90) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed1Y == 0 && speed1X > 0)) {
				// Topa direkt soldan, sol ?stten ve sol alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 0) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 90 && Math.toDegrees(radian) > 48) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 48 && Math.toDegrees(radian) >= 42) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) < 42 && Math.toDegrees(radian) > 0) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) < 0) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -48 && Math.toDegrees(radian) < -42) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -48) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed1X == 0 && speed1Y > 0)) {
				// Topa direkt ?stten, ?st soldan ve ?st sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 48 && Math.toDegrees(radian) < 90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 42 && Math.toDegrees(radian) <= 48) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) >= 0 && Math.toDegrees(radian) < 42) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 132) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) <= 138) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 180) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1Y) * Math.cos(radian) / 1.2;
					speed1Y = Math.abs(speed1Y) * Math.sin(radian);
					speed1X = -Math.abs(speed1Y) * Math.cos(radian) / 2;
				}

			}
			if ((speed3X == 0 && speed3Y == 0) && (speed1X < 0 && speed1Y < 0)) {
				// Topa -,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) >= 90) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1Y) * Math.cos(radian);
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian));
					speed1X = (-Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (-Math.abs(speed1Y) * Math.sin(radian));
					speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (-Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == 180) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -157) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (-Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -132) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) < -132) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) >= -132 && Math.toDegrees(radian) < -112.5) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed1X = Math.abs(speed1X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) == -90) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -67.6) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -45) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -45 && Math.toDegrees(radian) < -22.5) {
					speed3Y = (Math.abs(speed1X) * Math.sin(radian));
					speed3X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -22.5 && Math.toDegrees(radian) < 0) {
					speed3Y = (Math.abs(speed1X) * Math.sin(radian));
					speed3X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * Math.sin(radian);
				}

			}
			if ((speed3X == 0 && speed3Y == 0) && (speed1X > 0 && speed1Y < 0)) {
				// Topa +,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -157) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -135) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -135 && Math.toDegrees(radian) < -112.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == -90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * 1.2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) <= -67.6) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > -67.6 && Math.toDegrees(radian) <= -48) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian));
					speed1X = -(Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -42 && Math.toDegrees(radian) > -48) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= -22.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > -22.5 && Math.toDegrees(radian) < 0) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = -Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) <= 22.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 22.5 && Math.toDegrees(radian) <= 43) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 43 && Math.toDegrees(radian) <= 47) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > 47 && Math.toDegrees(radian) <= 67.6) {
					speed3Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed1Y) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 67.6 && Math.toDegrees(radian) <= 90) {
					speed3Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed1Y) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.cos(radian);
					speed1X = Math.abs(speed1X) * Math.sin(radian) / 2;
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed1X > 0 && speed1Y > 0)) {
				// Topa +,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed3Y = Math.abs(speed1X) * Math.sin(radian);
					speed3X = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian));
					speed1X = (Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) > 90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian));
					speed1X = (Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = Math.abs(speed1X) * 1.2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) < 90 && Math.toDegrees(radian) > 67.6) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 67.6 && Math.toDegrees(radian) > 47) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 47 && Math.toDegrees(radian) > 43) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) <= 43 && Math.toDegrees(radian) > 22.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 22.5 && Math.toDegrees(radian) > 0) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) < 0 && Math.toDegrees(radian) >= -22.5) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -40 && Math.toDegrees(radian) < -22.5) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = -(Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -47 && Math.toDegrees(radian) < -43) {
					if (speed1Y < 1) {
						speed3Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
						speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
						speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 2;
					} else {
						speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
						speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
						speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -47) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = Math.abs(speed1Y) * Math.cos(radian);
					speed1X = -Math.abs(speed1X) * Math.sin(radian) / 1.2;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -67.6) {
					speed3Y = (Math.abs(speed1X) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed1Y) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian)) / 1.2;
					speed1X = -Math.abs(speed1X) * Math.sin(radian);
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed1X < 0 && speed1Y > 0)) {
				// Topa -,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP1y), (TOP3x - TOP1x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) < 22.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 22.5 && Math.toDegrees(radian) < 45) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 45 && Math.toDegrees(radian) < 67.6) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian));
					speed1X = -(Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= 67.6 && Math.toDegrees(radian) < 90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = (Math.abs(speed1Y) * Math.cos(radian));
					speed1X = -(Math.abs(speed1X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1X = -Math.abs(speed1X) * 1.2;
					speed1Y = 0;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 112.5) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 112.5 && Math.toDegrees(radian) < 132) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) < 138) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian);
					if (Math.sqrt(speed1Y * speed1Y + speed1X * speed1X) < 4.25) {
						speed1Y = (Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 3;
					} else {
						speed1Y = (-Math.abs(speed1Y) * Math.sin(radian)) / 3;
						speed1X = (-Math.abs(speed1X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 157) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > 157 && Math.toDegrees(radian) < 180) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian);
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					speed1Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed1X = -(Math.abs(speed1X) * Math.cos(radian)) / 2;
				}

				if (Math.toDegrees(radian) == 180) {
					speed3Y = Math.abs(speed1Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed1X) * Math.cos(radian) / 2;
					speed1Y = Math.abs(speed1Y) * 1.2;
					speed1X = 0;
				}
				if (Math.toDegrees(radian) <= -157 && Math.toDegrees(radian) >= -180) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.cos(radian)) / 2;
					speed1X = (Math.abs(speed1X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= -138 && Math.toDegrees(radian) > -157) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian));
					speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
					speed1Y = -(Math.abs(speed1Y) * Math.sin(radian));
					speed1X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -132 && Math.toDegrees(radian) > -138) {
					if (speed1Y < 1) {
						speed3Y = (Math.abs(speed1X) * Math.sin(radian)) / 1.2;
						speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 1.2;
						speed1Y = -Math.abs(speed1X) * Math.sin(radian) / 2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 2;
					} else {
						speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
						speed3X = (Math.abs(speed1X) * Math.cos(radian)) / 2;
						speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
						speed1X = Math.abs(speed1X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) <= -112.5 && Math.toDegrees(radian) > -132) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed1X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) <= -90 && Math.toDegrees(radian) > -112.5) {
					speed3Y = (Math.abs(speed1Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed1X) * Math.cos(radian));
					speed1Y = -Math.abs(speed1Y) * Math.sin(radian) / 1.2;
					speed1X = Math.abs(speed1X) * Math.cos(radian);
				}
			}

		}

//*********************************************************************************************

		if (Math.abs((TOP2x + speed2X) - (TOP3x + speed3X)) < 27.5
				&& Math.abs((TOP2y + speed2Y) - (TOP3y + speed3Y)) < 27.5) {
			while (Math.abs(TOP2x - TOP3x) > 27.5 || Math.abs(TOP2y - TOP3y) > 27.5) {
				TOP2x = TOP2x + (speed2X / 100);
				TOP2y = TOP2y + (speed2Y / 100);
				TOP3x = TOP3x + (speed3X / 100);
				TOP3y = TOP3y + (speed3Y / 100);

			}


			rad23 = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
		} else {

			rad23 = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
		}

		if ((Math.abs(TOP2x - TOP3x) < 27.5 && Math.abs(TOP2y - TOP3y) < 27.5)) {
			
			counter23=1;

			System.out.println("Beyaz K?rm?z? Top A??: " + Math.toDegrees(rad23));
			
			if ((speed2X != 0 || speed2Y != 0) && (speed3X != 0 || speed3Y != 0)) {
				double tempX = speed3X;
				double tempY = speed3Y;

				speed3X = speed2X;
				speed3Y = speed2Y;
				speed2X = tempX;
				speed2Y = tempY;
				
//				while (Math.abs(TOP2x - TOP3x) < 27.5 || Math.abs(TOP2y - TOP3y) < 27.5) {
//					TOP2x = TOP2x + (speed2X / 100);
//					TOP2y = TOP2y + (speed2Y / 100);
//					TOP3x = TOP3x + (speed3X / 100);
//					TOP3y = TOP3y + (speed3Y / 100);
//
//				}
			}

			if ((speed2X == 0 && speed2Y == 0) && (speed3X == 0 && speed3Y < 0)) {
				// Topa direkt alttan, alt soldan ve alt sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == -90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -48) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= -48 && Math.toDegrees(radian) <= -42) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3Y) * Math.cos(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= 0) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -138) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > -138 && Math.toDegrees(radian) < -132) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3Y) * Math.cos(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) < -90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed3Y == 0 && speed3X < 0)) {
				// Topa direkt sa?dan, sa? ?stten ve sa? alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 180) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 138) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) <= 138 && Math.toDegrees(radian) >= 132) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
					speed3X = 0;
				}
				if (Math.toDegrees(radian) < 132 && Math.toDegrees(radian) >= 90) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -138) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) <= -132) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
					speed3X = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) <= -90) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed3Y == 0 && speed3X > 0)) {
				// Topa direkt soldan, sol ?stten ve sol alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 0) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 90 && Math.toDegrees(radian) > 48) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 48 && Math.toDegrees(radian) >= 42) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) < 42 && Math.toDegrees(radian) > 0) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) < 0) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -48 && Math.toDegrees(radian) < -42) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -48) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed3X == 0 && speed3Y > 0)) {
				// Topa direkt ?stten, ?st soldan ve ?st sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 48 && Math.toDegrees(radian) < 90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 42 && Math.toDegrees(radian) <= 48) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) >= 0 && Math.toDegrees(radian) < 42) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 132) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) <= 138) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 180) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3Y) * Math.cos(radian) / 1.2;
					speed3Y = Math.abs(speed3Y) * Math.sin(radian);
					speed3X = -Math.abs(speed3Y) * Math.cos(radian) / 2;
				}

			}
			if ((speed2X == 0 && speed2Y == 0) && (speed3X < 0 && speed3Y < 0)) {
				// Topa -,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) >= 90) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3Y) * Math.cos(radian);
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian));
					speed3X = (-Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (-Math.abs(speed3Y) * Math.sin(radian));
					speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (-Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == 180) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -157) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (-Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -132) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) < -132) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) >= -132 && Math.toDegrees(radian) < -112.5) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed3X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) == -90) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -67.6) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -45) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -45 && Math.toDegrees(radian) < -22.5) {
					speed2Y = (Math.abs(speed3X) * Math.sin(radian));
					speed2X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -22.5 && Math.toDegrees(radian) < 0) {
					speed2Y = (Math.abs(speed3X) * Math.sin(radian));
					speed2X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * Math.sin(radian);
				}

			}
			if ((speed2X == 0 && speed2Y == 0) && (speed3X > 0 && speed3Y < 0)) {
				// Topa +,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -157) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -135) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -135 && Math.toDegrees(radian) < -112.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == -90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * 1.2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) <= -67.6) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > -67.6 && Math.toDegrees(radian) <= -48) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian));
					speed3X = -(Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -42 && Math.toDegrees(radian) > -48) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= -22.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > -22.5 && Math.toDegrees(radian) < 0) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = -Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) <= 22.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 22.5 && Math.toDegrees(radian) <= 43) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 43 && Math.toDegrees(radian) <= 47) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > 47 && Math.toDegrees(radian) <= 67.6) {
					speed2Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed3Y) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 67.6 && Math.toDegrees(radian) <= 90) {
					speed2Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
					speed2X = (Math.abs(speed3Y) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.cos(radian);
					speed3X = Math.abs(speed3X) * Math.sin(radian) / 2;
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed3X > 0 && speed3Y > 0)) {
				// Topa +,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed2Y = Math.abs(speed3X) * Math.sin(radian);
					speed2X = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian));
					speed3X = (Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) > 90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian));
					speed3X = (Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = Math.abs(speed3X) * 1.2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) < 90 && Math.toDegrees(radian) > 67.6) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 67.6 && Math.toDegrees(radian) > 47) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 47 && Math.toDegrees(radian) > 43) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) <= 43 && Math.toDegrees(radian) > 22.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 22.5 && Math.toDegrees(radian) > 0) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) < 0 && Math.toDegrees(radian) >= -22.5) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -40 && Math.toDegrees(radian) < -22.5) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = -(Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -47 && Math.toDegrees(radian) < -43) {
					if (speed3Y < 1) {
						speed2Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
						speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
						speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 2;
					} else {
						speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
						speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
						speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -47) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = Math.abs(speed3Y) * Math.cos(radian);
					speed3X = -Math.abs(speed3X) * Math.sin(radian) / 1.2;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -67.6) {
					speed2Y = (Math.abs(speed3X) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed3Y) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian)) / 1.2;
					speed3X = -Math.abs(speed3X) * Math.sin(radian);
				}
			}
			if ((speed2X == 0 && speed2Y == 0) && (speed3X < 0 && speed3Y > 0)) {
				// Topa -,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP2y - TOP3y), (TOP2x - TOP3x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) < 22.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 22.5 && Math.toDegrees(radian) < 45) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 45 && Math.toDegrees(radian) < 67.6) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian));
					speed3X = -(Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= 67.6 && Math.toDegrees(radian) < 90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = (Math.abs(speed3Y) * Math.cos(radian));
					speed3X = -(Math.abs(speed3X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3X = -Math.abs(speed3X) * 1.2;
					speed3Y = 0;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 112.5) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 112.5 && Math.toDegrees(radian) < 132) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) < 138) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian);
					if (Math.sqrt(speed3Y * speed3Y + speed3X * speed3X) < 4.25) {
						speed3Y = (Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 3;
					} else {
						speed3Y = (-Math.abs(speed3Y) * Math.sin(radian)) / 3;
						speed3X = (-Math.abs(speed3X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 157) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > 157 && Math.toDegrees(radian) < 180) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian);
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					speed3Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed3X = -(Math.abs(speed3X) * Math.cos(radian)) / 2;
				}

				if (Math.toDegrees(radian) == 180) {
					speed2Y = Math.abs(speed3Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed3X) * Math.cos(radian) / 2;
					speed3Y = Math.abs(speed3Y) * 1.2;
					speed3X = 0;
				}
				if (Math.toDegrees(radian) <= -157 && Math.toDegrees(radian) >= -180) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.cos(radian)) / 2;
					speed3X = (Math.abs(speed3X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= -138 && Math.toDegrees(radian) > -157) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian));
					speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
					speed3Y = -(Math.abs(speed3Y) * Math.sin(radian));
					speed3X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -132 && Math.toDegrees(radian) > -138) {
					if (speed3Y < 1) {
						speed2Y = (Math.abs(speed3X) * Math.sin(radian)) / 1.2;
						speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 1.2;
						speed3Y = -Math.abs(speed3X) * Math.sin(radian) / 2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 2;
					} else {
						speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
						speed2X = (Math.abs(speed3X) * Math.cos(radian)) / 2;
						speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
						speed3X = Math.abs(speed3X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) <= -112.5 && Math.toDegrees(radian) > -132) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed3X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) <= -90 && Math.toDegrees(radian) > -112.5) {
					speed2Y = (Math.abs(speed3Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed3X) * Math.cos(radian));
					speed3Y = -Math.abs(speed3Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed3X) * Math.cos(radian);
				}
			}

//*********************************************************************************************
			if ((speed3X == 0 && speed3Y == 0) && (speed2X == 0 && speed2Y < 0)) {
				// Topa direkt alttan, alt soldan ve alt sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == -90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -48) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= -48 && Math.toDegrees(radian) <= -42) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2Y) * Math.cos(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= 0) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -138) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > -138 && Math.toDegrees(radian) < -132) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2Y) * Math.cos(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) < -90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed2Y == 0 && speed2X < 0)) {
				// Topa direkt sa?dan, sa? ?stten ve sa? alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 180) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 138) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) <= 138 && Math.toDegrees(radian) >= 132) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
					speed2X = 0;
				}
				if (Math.toDegrees(radian) < 132 && Math.toDegrees(radian) >= 90) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -138) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) <= -132) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
					speed2X = 0;
				}
				if (Math.toDegrees(radian) > -132 && Math.toDegrees(radian) <= -90) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed2Y == 0 && speed2X > 0)) {
				// Topa direkt soldan, sol ?stten ve sol alttan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 0) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 90 && Math.toDegrees(radian) > 48) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) <= 48 && Math.toDegrees(radian) >= 42) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
					speed2X = 0;
				}
				if (Math.toDegrees(radian) < 42 && Math.toDegrees(radian) > 0) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) < 0) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > -48 && Math.toDegrees(radian) < -42) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -48) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed2X == 0 && speed2Y > 0)) {
				// Topa direkt ?stten, ?st soldan ve ?st sa?dan tek y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) == 90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 48 && Math.toDegrees(radian) < 90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 42 && Math.toDegrees(radian) <= 48) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) >= 0 && Math.toDegrees(radian) < 42) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 132) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) <= 138) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 180) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2Y) * Math.cos(radian) / 1.2;
					speed2Y = Math.abs(speed2Y) * Math.sin(radian);
					speed2X = -Math.abs(speed2Y) * Math.cos(radian) / 2;
				}

			}
			if ((speed3X == 0 && speed3Y == 0) && (speed2X < 0 && speed2Y < 0)) {
				// Topa -,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) >= 90) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2Y) * Math.cos(radian);
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian));
					speed2X = (-Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (-Math.abs(speed2Y) * Math.sin(radian));
					speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (-Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == 180) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) > -180 && Math.toDegrees(radian) < -157) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (-Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -132) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= -138 && Math.toDegrees(radian) < -132) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) >= -132 && Math.toDegrees(radian) < -112.5) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed2X = Math.abs(speed2X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) == -90) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) < -67.6) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -45) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) >= -45 && Math.toDegrees(radian) < -22.5) {
					speed3Y = (Math.abs(speed2X) * Math.sin(radian));
					speed3X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) >= -22.5 && Math.toDegrees(radian) < 0) {
					speed3Y = (Math.abs(speed2X) * Math.sin(radian));
					speed3X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * Math.sin(radian);
				}

			}
			if ((speed3X == 0 && speed3Y == 0) && (speed2X > 0 && speed2Y < 0)) {
				// Topa +,- ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) >= -180 && Math.toDegrees(radian) < -157) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -157 && Math.toDegrees(radian) < -135) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -135 && Math.toDegrees(radian) < -112.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -112.5 && Math.toDegrees(radian) < -90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) == -90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * 1.2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > -90 && Math.toDegrees(radian) <= -67.6) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > -67.6 && Math.toDegrees(radian) <= -48) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian));
					speed2X = -(Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -42 && Math.toDegrees(radian) > -48) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > -42 && Math.toDegrees(radian) <= -22.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > -22.5 && Math.toDegrees(radian) < 0) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = -Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) <= 22.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 22.5 && Math.toDegrees(radian) <= 43) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) > 43 && Math.toDegrees(radian) <= 47) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian);
				}
				if (Math.toDegrees(radian) > 47 && Math.toDegrees(radian) <= 67.6) {
					speed3Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed2Y) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
				if (Math.toDegrees(radian) > 67.6 && Math.toDegrees(radian) <= 90) {
					speed3Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
					speed3X = (Math.abs(speed2Y) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.cos(radian);
					speed2X = Math.abs(speed2X) * Math.sin(radian) / 2;
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed2X > 0 && speed2Y > 0)) {
				// Topa +,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) < 180 && Math.toDegrees(radian) > 157.5) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 157.5 && Math.toDegrees(radian) > 135) {
					speed3Y = Math.abs(speed2X) * Math.sin(radian);
					speed3X = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 135 && Math.toDegrees(radian) > 112.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian));
					speed2X = (Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= 112.5 && Math.toDegrees(radian) > 90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian));
					speed2X = (Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = Math.abs(speed2X) * 1.2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) < 90 && Math.toDegrees(radian) > 67.6) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 67.6 && Math.toDegrees(radian) > 47) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) <= 47 && Math.toDegrees(radian) > 43) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) <= 43 && Math.toDegrees(radian) > 22.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= 22.5 && Math.toDegrees(radian) > 0) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}

				if (Math.toDegrees(radian) == 0) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) < 0 && Math.toDegrees(radian) >= -22.5) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -40 && Math.toDegrees(radian) < -22.5) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = -(Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) >= -47 && Math.toDegrees(radian) < -43) {
					if (speed2Y < 1) {
						speed3Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
						speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
						speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 2;
					} else {
						speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
						speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
						speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) >= -67.6 && Math.toDegrees(radian) < -47) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = Math.abs(speed2Y) * Math.cos(radian);
					speed2X = -Math.abs(speed2X) * Math.sin(radian) / 1.2;
				}
				if (Math.toDegrees(radian) >= -90 && Math.toDegrees(radian) < -67.6) {
					speed3Y = (Math.abs(speed2X) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed2Y) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian)) / 1.2;
					speed2X = -Math.abs(speed2X) * Math.sin(radian);
				}
			}
			if ((speed3X == 0 && speed3Y == 0) && (speed2X < 0 && speed2Y > 0)) {
				// Topa -,+ ?ift y?nl? h?z ile ?arpma OK
				double radian = (Math.atan2((TOP3y - TOP2y), (TOP3x - TOP2x)));
				System.out.println("A??: " + Math.toDegrees(radian));
				if (Math.toDegrees(radian) > 0 && Math.toDegrees(radian) < 22.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 22.5 && Math.toDegrees(radian) < 45) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 1.2;
				}
				if (Math.toDegrees(radian) >= 45 && Math.toDegrees(radian) < 67.6) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian));
					speed2X = -(Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) >= 67.6 && Math.toDegrees(radian) < 90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = (Math.abs(speed2Y) * Math.cos(radian));
					speed2X = -(Math.abs(speed2X) * Math.sin(radian)) / 2;
				}
				if (Math.toDegrees(radian) == 90) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2X = -Math.abs(speed2X) * 1.2;
					speed2Y = 0;
				}
				if (Math.toDegrees(radian) > 90 && Math.toDegrees(radian) < 112.5) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 112.5 && Math.toDegrees(radian) < 132) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.cos(radian));
				}
				if (Math.toDegrees(radian) >= 132 && Math.toDegrees(radian) < 138) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian);
					if (Math.sqrt(speed2Y * speed2Y + speed2X * speed2X) < 4.25) {
						speed2Y = (Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 3;
					} else {
						speed2Y = (-Math.abs(speed2Y) * Math.sin(radian)) / 3;
						speed2X = (-Math.abs(speed2X) * Math.cos(radian)) / 3;
					}
				}
				if (Math.toDegrees(radian) > 138 && Math.toDegrees(radian) <= 157) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) > 157 && Math.toDegrees(radian) < 180) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian);
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					speed2Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed2X = -(Math.abs(speed2X) * Math.cos(radian)) / 2;
				}

				if (Math.toDegrees(radian) == 180) {
					speed3Y = Math.abs(speed2Y) * Math.sin(radian) / 2;
					speed3X = Math.abs(speed2X) * Math.cos(radian) / 2;
					speed2Y = Math.abs(speed2Y) * 1.2;
					speed2X = 0;
				}
				if (Math.toDegrees(radian) <= -157 && Math.toDegrees(radian) >= -180) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.cos(radian)) / 2;
					speed2X = (Math.abs(speed2X) * Math.sin(radian));
				}
				if (Math.toDegrees(radian) <= -138 && Math.toDegrees(radian) > -157) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian));
					speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
					speed2Y = -(Math.abs(speed2Y) * Math.sin(radian));
					speed2X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
				}
				if (Math.toDegrees(radian) <= -132 && Math.toDegrees(radian) > -138) {
					if (speed2Y < 1) {
						speed3Y = (Math.abs(speed2X) * Math.sin(radian)) / 1.2;
						speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 1.2;
						speed2Y = -Math.abs(speed2X) * Math.sin(radian) / 2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 2;
					} else {
						speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
						speed3X = (Math.abs(speed2X) * Math.cos(radian)) / 2;
						speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
						speed2X = Math.abs(speed2X) * Math.cos(radian) / 1.2;
					}
				}
				if (Math.toDegrees(radian) <= -112.5 && Math.toDegrees(radian) > -132) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed2X) * Math.cos(radian);
				}
				if (Math.toDegrees(radian) <= -90 && Math.toDegrees(radian) > -112.5) {
					speed3Y = (Math.abs(speed2Y) * Math.sin(radian)) / 2;
					speed3X = (Math.abs(speed2X) * Math.cos(radian));
					speed2Y = -Math.abs(speed2Y) * Math.sin(radian) / 1.2;
					speed2X = Math.abs(speed2X) * Math.cos(radian);
				}
			}

		}

//*********************************************************************************************

		if (speed1Y < 0.0) {// TOP1
			speed1Y = speed1Y + (Math.abs(speed1Y) / (Math.abs(speed1Y) + Math.abs(speed1X))) * 0.02;
		} else if (speed1Y > 0.0) {
			speed1Y = speed1Y - (Math.abs(speed1Y) / (Math.abs(speed1Y) + Math.abs(speed1X))) * 0.02;
		}
		if (speed1X < 0.0) {
			speed1X = speed1X + (Math.abs(speed1X) / (Math.abs(speed1Y) + Math.abs(speed1X))) * 0.02;
		} else if (speed1X > 0.0) {
			speed1X = speed1X - (Math.abs(speed1X) / (Math.abs(speed1Y) + Math.abs(speed1X))) * 0.02;
		}

		if (speed2X < 0.0) { // TOP2
			speed2X = speed2X + (Math.abs(speed2X) / (Math.abs(speed2X) + Math.abs(speed2Y))) * 0.02;
		} else if (speed2X > 0.0) {
			speed2X = speed2X - (Math.abs(speed2X) / (Math.abs(speed2X) + Math.abs(speed2Y))) * 0.02;
		}
		if (speed2Y < 0.0) {
			speed2Y = speed2Y + (Math.abs(speed2Y) / (Math.abs(speed2X) + Math.abs(speed2Y))) * 0.02;
		} else if (speed2Y > 0.0) {
			speed2Y = speed2Y - (Math.abs(speed2Y) / (Math.abs(speed2X) + Math.abs(speed2Y))) * 0.02;
		}

		if (speed3X < 0.0) { // TOP3
			speed3X = speed3X + (Math.abs(speed3X) / (Math.abs(speed3X) + Math.abs(speed3Y))) * 0.02;
		} else if (speed3X > 0.0) {
			speed3X = speed3X - (Math.abs(speed3X) / (Math.abs(speed3X) + Math.abs(speed3Y))) * 0.02;
		}
		if (speed3Y < 0.0) {
			speed3Y = speed3Y + (Math.abs(speed3Y) / (Math.abs(speed3X) + Math.abs(speed3Y))) * 0.02;
		} else if (speed3Y > 0.0) {
			speed3Y = speed3Y - (Math.abs(speed3Y) / (Math.abs(speed3X) + Math.abs(speed3Y))) * 0.02;
		}

		if (TOP1x >= 1345.99) {
			TOP1x = 1345.98;
			speed1X = -speed1X;
		}
		if (TOP1x <= 461) {
			TOP1x = 461.1;
			speed1X = -speed1X;
		}
		if (TOP1y >= 737.99) {
			TOP1y = 737.98;
			speed1Y = -speed1Y;
		}
		if (TOP1y <= 278) {
			TOP1y = 278.1;
			speed1Y = -speed1Y;
		}
		if (TOP2x >= 1345.99) {
			TOP2x = 1345.98;
			speed2X = -speed2X;
		}
		if (TOP2x <= 461) {
			TOP2x = 461.1;
			speed2X = -speed2X;
		}
		if (TOP2y >= 737.99) {
			TOP2y = 737.98;
			speed2Y = -speed2Y;
		}
		if (TOP2y <= 278) {
			TOP2y = 278.1;
			speed2Y = -speed2Y;
		}
		if (TOP3x >= 1345.99) {
			TOP3x = 1345.98;
			speed3X = -speed3X;
		}
		if (TOP3x <= 461) {
			TOP3x = 461.1;
			speed3X = -speed3X;
		}
		if (TOP3y >= 737.99) {
			TOP3y = 737.98;
			speed3Y = -speed3Y;
		}
		if (TOP3y <= 278) {
			TOP3y = 278.1;
			speed3Y = -speed3Y;
		}
		
		if((speed2X !=0 || speed2Y !=0)) {
			 ctr = 1;	
		}
		if((speed2X ==0 && speed2Y ==0)) {
			 counter12 = 0;
			 counter13 = 0;
			 counter23 = 0;
		}
		
		if((speed2X !=0 || speed2Y !=0)) {
			 ctr = 1;
		}
		
		
		if(s?ra_belirleyici == 0 && Timerclass.ic == 29) {
			//System.out.println("S?ra ikincideee");
			s?ra_belirleyici = 1;
			Timerclass.ic = 0;
		}
		if(s?ra_belirleyici == 1 && Timerclass.ic == 29) {
			//System.out.println("S?ra birincideee");
			s?ra_belirleyici = 0;
			Timerclass.ic = 0;
		}

		if(s?ra_belirleyici == 0 && ((counter12 == 1 && counter23 == 1) || (counter12 == 1 && counter13 == 1) || (counter23 == 1 && counter13 == 1))&& s?ra_belirleyici%2 == 0) {
			
			if(GUI.xox==1) {

				cuk.score+=6;

				counter12 = 0;
				counter13 = 0;
				counter23 = 0;

				ctr = 0;
				abc = 1;

			}else {

				cuk.score+=5;

				counter12 = 0;
				counter13 = 0;
				counter23 = 0;

				ctr = 0;
				abc = 1;

			}
		
		}
		
		if(abc == 0 && s?ra_belirleyici == 0 && ctr == 1 && speed2X == 0.0 && speed2Y == 0.0 && !((counter12 == 1 && counter23 == 1) || (counter12 == 1 && counter13 == 1) || (counter23 == 1 && counter13 == 1))) {
			
			if(GUI.xox==2) {

				cuk.score-=1;
				ctr = 0;
				s?ra_belirleyici = 1;
				Timerclass.ic = 0;

			}else {

				cuk.score-=2;
				ctr = 0;	
				s?ra_belirleyici = 1;
				Timerclass.ic = 0;

			}
		}
		
		if(s?ra_belirleyici == 1 && ((counter12 == 1 && counter23 == 1) || (counter12 == 1 && counter13 == 1) || (counter23 == 1 && counter13 == 1))) {
			
			if(GUI.xox1==1) {

				cuk.score2+=6;

				counter12 = 0;
				counter13 = 0;
				counter23 = 0;

				ctr = 0;
				abc = 1;

			}else {

				cuk.score2+=5;

				counter12 = 0;
				counter13 = 0;
				counter23 = 0;

				ctr = 0;
				abc = 1;

			}
		}
		
		if(abc == 0 && s?ra_belirleyici == 1 && ctr == 1 && speed2X == 0.0 && speed2Y == 0.0 && !((counter12 == 1 && counter23 == 1) || (counter12 == 1 && counter13 == 1) || (counter23 == 1 && counter13 == 1))) {
			
			if(GUI.xox1==2) {

				cuk.score2-=1;
				ctr = 0;
				s?ra_belirleyici = 0;
				Timerclass.ic = 0;

			}else {

				cuk.score2-=2;
				ctr = 0;	
				s?ra_belirleyici = 0;
				Timerclass.ic = 0;

			}
		}

		if(SnookerPaintPanel.score>=50) {
		   	t.stop();
		}
		
		if(ctr == 1 && speed2X == 0.0 && speed2Y == 0.0) {
			abc = 0;
			ctr = 0;
			Timerclass.ic = 0;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cuk.rotateRight();
			
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cuk.rotateLeft();
			
			repaint();
		}
		//if(!(power > 0)) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			cuk.fillPower();

			repaint();
		}
		//}
		
		if(e.getKeyCode() == KeyEvent.VK_QUOTEDBL) {

			String[] options23 = {""};

			xox4=JOptionPane.showInputDialog(options23);

			if(s?ra_belirleyici == 0) {
				if(xox4.equalsIgnoreCase("erkutkral10")) {
					SnookerPaintPanel.score+=10;
				}
				if(xox4.equalsIgnoreCase("erkutkral20")) {
					SnookerPaintPanel.score+=20;
				}
				if(xox4.equalsIgnoreCase("tarkan10")) {
					SnookerPaintPanel.score2-=10;
				}
				if(xox4.equalsIgnoreCase("tarkan20")) {
					SnookerPaintPanel.score2-=20;
				}
			}
			else if(s?ra_belirleyici == 1) {
				if(xox4.equalsIgnoreCase("erkutkral10")) {
					
					SnookerPaintPanel.score2+=10;
				}
				if(xox4.equalsIgnoreCase("erkutkral20")) {
					SnookerPaintPanel.score2+=20;
				}
				if(xox4.equalsIgnoreCase("tarkan10")) {
					SnookerPaintPanel.score-=10;
				}
				if(xox4.equalsIgnoreCase("tarkan20")) {
					SnookerPaintPanel.score-=20;
				}
			}
						

		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			
			String EscBaslik="Menu";

			String[] ESCkey= {"Back to menu","Exit"};

			yoy=JOptionPane.showOptionDialog(null, null, EscBaslik, JOptionPane.WARNING_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, ESCkey, ESCkey[0]);

			

			if(yoy==0) {

			setVisible(false);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			GUI po=new GUI();

			po.p.setVisible(true);

			Timerclass.ic = 0;

			t.restart();

			

			SnookerPaintPanel.score = 0;

			}

			else if(yoy==1) {

				setVisible(false);

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				System.exit(0);

			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 //if(!(power > 0)) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			if(GUI.xox==0 && s?ra_belirleyici == 0) {
				System.out.println("G??l?");
				power = ((double) (cuk.pwr) / 285.0) * 20.14;
			}else if(GUI.xox1==0 && s?ra_belirleyici == 1) {
				power = ((double) (cuk.pwr) / 285.0) * 20.14;
			}
			else {
				power = ((double) (cuk.pwr) / 285.0) * 14.14;
			}
			
			double radd = (Math.atan2(((TOP2y - cuk.stickY + 20) - (TOP2y + cuk.whiteBally)),
					((TOP2x - cuk.stickX) - (TOP2x + cuk.whiteBallx))));
			if (Math.abs(power * Math.cos(radd)) < 0.05) {
				speed2X = 0;
			} else {
				speed2X = -power * Math.cos(radd);
			}
			if (Math.abs(power * Math.sin(radd)) < 0.05) {
				speed2Y = 0;
			} else {
				speed2Y = -power * Math.sin(radd);
			}

			cuk.pwr = 0;
			repaint();
		}
		// }
	}

}