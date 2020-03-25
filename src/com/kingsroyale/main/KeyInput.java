package com.kingsroyale.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.kingsroyale.menus.HomeScreen;
import com.kingsroyale.objects.Map;
import com.kingsroyale.objects.Player;
import com.kingsroyale.objects.shop.Shop;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private HomeScreen hs;
	private Player player;
	private Map map;
	private Shop shop;
	private JFrame frame = Window.getFrame();
	
	public void toggleHs() {
		if (hs.isShown()) {
			hs.setShown(false);
		} else {
			hs.setShown(true);
		}
	}
	
	public void toggleFullScreen() {
		
		if (Window.isFullScreen()) {
			frame.setExtendedState(JFrame.NORMAL);
			frame.setUndecorated(false);
			Window.setFullScreen(false);
		} else {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			Window.setFullScreen(true);
		}
		
		//frame.pack();
	}
	
	public KeyInput(Handler handler, HomeScreen hs, Player player, Map map, Shop shop) {
		this.handler = handler;
		this.hs = hs;
		this.player = player;  
		this.map = map;
		this.shop = shop;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (!hs.isShown()) {
			//toggle map
			if(key == KeyEvent.VK_F11) toggleFullScreen();
			if(key == KeyEvent.VK_M) map.toggleMap();
			if(key == KeyEvent.VK_P) shop.toggleShop();
			
			//player can only move if map is hidden
			if (!map.isShown() && !shop.isShown()) {
				
				//vertical movement
				if(key == KeyEvent.VK_W) player.setVelY(-5);
				if(key == KeyEvent.VK_S) player.setVelY(5);
				
				//horizontal movement
				if(key == KeyEvent.VK_A) player.setVelX(-5);
				if(key == KeyEvent.VK_D) player.setVelX(5);
			}
		}
		
		//quit (TEMP)
		if(key == KeyEvent.VK_ESCAPE) toggleHs();
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		//vertical movement
		if(key == KeyEvent.VK_W) player.setVelY(0);
		if(key == KeyEvent.VK_S) player.setVelY(0);
				
		//horizontal movement
		if(key == KeyEvent.VK_A) player.setVelX(0);
		if(key == KeyEvent.VK_D) player.setVelX(0);
	}
	
}
