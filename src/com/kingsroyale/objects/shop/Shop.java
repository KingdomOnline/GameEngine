package com.kingsroyale.objects.shop;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Shop extends GameObject{
	
	private LinkedList<ShopPage> pages = new LinkedList<ShopPage>();
	private int activePage = 0;

	public Shop(int x, int y, ID id) {
		super(x, y, id);
	}
	
	public ShopPage getPage(int n) {
		return pages.get(n);
	}
	
	public void addPage(ShopPage page) {
		this.pages.add(page);
	}
	
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x, y, Game.width, Game.height);
		
	}

	public void toggleShop() {
	
		if (this.shown) {
			this.shown = false;
			this.pages.get(activePage).setShown(false);
			for (ShopItem item : this.pages.get(activePage).getItems()) {
				item.setShown(false);
			}
		} else {
			this.shown = true;
			this.pages.get(activePage).setShown(true);
		}
		
	}
	

}
