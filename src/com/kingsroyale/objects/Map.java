package com.kingsroyale.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Map extends GameObject {
	
	private boolean hidden; 
	
	public Map(int x, int y, ID id, boolean hidden) {
		super(x, y, id);
	
		this.hidden = hidden;
		
	}

	@Override
	public void tick() {
		
		//TODO: Add icon selection logic
		//TODO: Add icons 
	}
	
	@Override
	public void render(Graphics g) {
		if (!isHidden()) {
			g.setColor(Color.green);
			g.fillRect(x, y, Game.width, Game.height);
		}
	}
	
	public void toggleMap() {
		if(this.hidden) {
			this.hidden = false;
		} else {
			this.hidden = true;
		}
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	

}
