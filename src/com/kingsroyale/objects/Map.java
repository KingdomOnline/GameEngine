package com.kingsroyale.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Map extends GameObject { 
	
	public Map(int x, int y, ID id) {
		super(x, y, id);
		
	}

	@Override
	public void tick() {
		
		//TODO: Add icon selection logic
		//TODO: Add icons 
	}
	 
	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, Game.width, Game.height);
	}

	public void toggleMap() {
		
		if (this.shown) {
			this.shown = false;
		} else {
			this.shown = true;
		}
		
	}

}
