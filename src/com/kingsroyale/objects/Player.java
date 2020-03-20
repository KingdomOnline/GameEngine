package com.kingsroyale.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;
import com.kingsroyale.objects.buildings.Building;
import com.kingsroyale.main.Handler;

public class Player extends GameObject {
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	
	}

	@Override
	public void tick() {
		
		//Movement
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.width - 32);
		y = Game.clamp(y, 0, Game.height - 64);
		
		for (Building building : Handler.buildings) {
			
			int bx = building.getX();
			int by = building.getY();
			
			if (x < bx + 250 + 10 && x > bx - 10 &&  y < by + 250 + 10 && y > by - 10) {
				building.setTestColor(Color.red);
			} else {
				normalColor(building);
			}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 64);
		
	}
	
	public void normalColor(Building building) {
		building.setTestColor(Color.blue);
	}
	
	

}
