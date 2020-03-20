package com.kingsroyale.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.kingsroyale.objects.buildings.Building;
import com.kingsroyale.objects.shop.*;

public class Handler {

	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	LinkedList<ShopItem> items = new LinkedList<ShopItem>();
	public static LinkedList<Building> buildings = new LinkedList<Building>();
	
	public void drawShopItems(Graphics g) {
		for (int i = 0; i < items.size(); i++) {
			
			ShopItem item = items.get(i);
			int offset = item.getName().length() / 2;
			
			g.setColor(Color.LIGHT_GRAY);
			if (i == 0) {
				g.fillRect(120, 120, 100, 100); 
				g.setColor(Color.cyan);
				g.drawString(item.getName(), 155 - (offset * 5), (120 * 1) + 20);
				
			} else {
				g.fillRect(120, 120 * i, 100, 100);
				g.setColor(Color.cyan);
				g.drawString(item.getName(), 155 - (offset * 5), (120 * i) + 20);
				
			}
			
		}
	}
	
	//Updates GameObjects
	public void tick() {
		for (GameObject object : objects) {
			object.tick();
		}
	}
	
	//Draws GameObjects to the screen
	public void render(Graphics g) {
		for (GameObject object : objects) {
			
			object.render(g);
			if (object.id == ID.Shop && !((Shop) object).isHidden()) {
				drawShopItems(g);
			}
	
		}
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
	
	public void addItem(ShopItem item) {
		this.items.add(item);
	}
	
	public void removeItem(ShopItem item) {
		this.items.remove(item);
	}
	
	public void addBuilding(Building building) {
		this.buildings.add(building);
	}
	
}
