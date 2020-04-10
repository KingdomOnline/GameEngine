package com.kingsroyale.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.kingsroyale.menus.Button;
import com.kingsroyale.menus.HomeScreen;
import com.kingsroyale.objects.shop.Shop;

public class MouseInput implements MouseListener {
	
	public Rectangle playButton = HomeScreen.playButton;
	public Rectangle helpButton = HomeScreen.helpButton;
	public Rectangle quitButton = HomeScreen.quitButton;

	public Button nextButton = Shop.nextButton;
	public Button prevButton = Shop.prevButton;

	private HomeScreen hs;
	private Shop shop;

	public MouseInput (HomeScreen hs, Shop shop) {
		this.hs = hs;
		this.shop = shop;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

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

		//Shop Prev & Next

		if (shop.isShown()) {
			//Next button
			if (mx >= nextButton.x && mx <= nextButton.x - 100 && my >= nextButton.y && my <= nextButton.y + 50) {
				shop.activePage += 1;
			}
			//Prev Button
			if (mx >= prevButton.x && mx <= prevButton.x - 100 && my >= prevButton.y && my <= prevButton.y + 50) {
				shop.activePage -=1;

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
