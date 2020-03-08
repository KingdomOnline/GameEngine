package com.kingsroyale.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.kingsroyale.objects.Map;
import com.kingsroyale.objects.Player;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private Player player;
	private Map map;
	
	public KeyInput(Handler handler, Player player, Map map) {
		this.handler = handler;
		this.player = player;  
		this.map = map;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//toggle map
		if(key == KeyEvent.VK_M) map.toggleMap();
		
		//player can only move if map is hidden
		if (map.isHidden()) {
			
			//vertical movement
			if(key == KeyEvent.VK_W) player.setVelY(-5);
			if(key == KeyEvent.VK_S) player.setVelY(5);
			
			//horizontal movement
			if(key == KeyEvent.VK_A) player.setVelX(-5);
			if(key == KeyEvent.VK_D) player.setVelX(5);
		}
		
		//quit (TEMP)
		if(key == KeyEvent.VK_ESCAPE) System.exit(0);
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
