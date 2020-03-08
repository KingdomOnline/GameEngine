package com.kingsroyale.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Player extends GameObject {
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	
	}

	public void tick() {
		
		//Movement
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.width - 32);
		y = Game.clamp(y, 0, Game.height - 64);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 64);
		
	}
	
	

}
