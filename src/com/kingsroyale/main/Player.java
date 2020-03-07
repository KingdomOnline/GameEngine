package com.kingsroyale.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	
		
	}

	public void tick() {
		
		//Movement
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.width - 32);
		y = Game.clamp(y, 0, Game.height - 32);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}
	
	

}
