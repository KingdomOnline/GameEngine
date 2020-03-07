package com.kingsroyale.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private Player player;
	
	public KeyInput(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//vertical movement
		if(key == KeyEvent.VK_W) player.setVelY(-5);
		if(key == KeyEvent.VK_S) player.setVelY(5);
		
		//horizontal movement
		if(key == KeyEvent.VK_A) player.setVelX(-5);
		if(key == KeyEvent.VK_D) player.setVelX(5);
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
