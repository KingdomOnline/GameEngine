package com.kingsroyale.objects.shop;

import java.awt.Graphics;
import java.util.LinkedList;

import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class ShopPage extends GameObject{
 
	private int pNumber;
	private LinkedList<ShopItem> items = new LinkedList<ShopItem>();
	
	public ShopPage(int x, int y, ID id, int pNumber) {
		super(x, y, id);
		
		this.pNumber = pNumber;
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}
	
	public LinkedList<ShopItem> getItems() {
		return items;
	}
	
	public void addItem(ShopItem item) {
		this.items.add(item);
	}
	
	public void removeItem(ShopItem item) {
		this.items.remove(item);
	}

	public void tick() {}

	public void render(Graphics g) {}
	
}
