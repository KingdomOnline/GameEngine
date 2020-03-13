package com.kingsroyale.objects.shop;

import java.awt.Color;
import java.awt.Graphics;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Shop extends GameObject{
	
	private boolean hidden;

	public Shop(int x, int y, ID id, boolean hidden) {
		super(x, y, id);
		
		this.hidden = hidden;
	}

	
	public void toggleShop() {
		if (hidden) {
			this.hidden = false;
		} else {
			this.hidden = true;
		}
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		
		if (!isHidden()) {
			g.setColor(Color.red);
			g.fillRect(x, y, Game.width, Game.height);

		}
		
		
	}
	

}
