package com.kingsroyale.objects.shop;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;
import com.kingsroyale.menus.Button;

public class Shop extends GameObject{
	
	private LinkedList<ShopPage> pages = new LinkedList<ShopPage>();
	public int activePage = 0;
	public static Button nextButton = new Button(Game.width - 150, Game.height - 150, ID.Menu, "Next", 100, 50);
	public static Button prevButton = new Button(50, Game.height - 150, ID.Menu, "Prev", 100, 50);
	//private Rectangle nextButton = new Rectangle(Game.width - 150, Game.height - 150, 100, 100);
	//private Rectangle prevButton = new Rectangle(150, 150, 100, 100);

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
		
		g.setColor(Color.black);
		g.fillRect(x, y, Game.width, Game.height);
		
		nextButton.render(g);
		prevButton.render(g);
		
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
			for (ShopItem item : this.pages.get(activePage).getItems()) {
				item.setShown(true);
			}
		}
		
	}
	

}
