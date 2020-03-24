package com.kingsroyale.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.kingsroyale.menus.HomeScreen;

public class MouseInput implements MouseListener {
	
	public Rectangle playButton = HomeScreen.playButton;
	public Rectangle helpButton = HomeScreen.helpButton;
	public Rectangle quitButton = HomeScreen.quitButton;

	private HomeScreen hs;
	
	public MouseInput (HomeScreen hs) {
		this.hs = hs;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		/*
		public Rectangle playButton = new Rectangle((Game.width / 2) - 50, (Game.height/4) + 50, 100, 50);
		public Rectangle helpButton = new Rectangle((Game.width / 2) - 50, (Game.height/4) + 125, 100, 50);
		public Rectangle quitButton = new Rectangle((Game.width / 2) - 50, (Game.height/4) + 200, 100, 50);
		*/

		//Home Screen
		if (hs.isShown()) {
			//Play button
			if (mx >= playButton.x && mx <= playButton.x + 100 && my >= playButton.y && my <= playButton.y + 50) {
				//Pressed Play
				hs.setShown(false);
			}

			//Help button
			if (mx >= helpButton.x && mx <= helpButton.x + 100 && my >= playButton.y && my<= playButton.y + 50) {
				//Pressed Help
			}
			
			//quitButton
			if (mx >= quitButton.x && mx <= quitButton.x + 100 && my >= quitButton.y && my<= quitButton.y + 50) {
				//Pressed quit
				System.exit(0);
			}
			
		}


		
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
