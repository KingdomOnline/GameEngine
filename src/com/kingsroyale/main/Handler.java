package com.kingsroyale.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import com.kingsroyale.menus.HomeScreen;
import com.kingsroyale.objects.buildings.Building;
import com.kingsroyale.objects.shop.*;

public class Handler {

	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	LinkedList<ShopItem> items = new LinkedList<ShopItem>();
	public static LinkedList<Building> buildings = new LinkedList<Building>();
	
	private HomeScreen hs;
	
	public Handler(HomeScreen hs) {
		this.hs = hs;
	}
	
	public void drawShopItems(Graphics g) {
		for (int i = 0; i < items.size(); i++) {
			
			ShopItem item = items.get(i);
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(item.getX(), item.getY(), item.getWidth(), item.getHeight()); 
			g.setColor(Color.black);
			g.setFont(new Font("MS PGothic", Font.PLAIN, 36));
			g.drawString(item.getName(), item.getX() + 20, item.getY() + 45);
		
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
		if (hs.isShown()) {
			hs.render(g);
		} else {
			for (GameObject object : objects) {
				
				if (object == hs) {
					return;
				} else {
					object.render(g);
					if (object.id == ID.Shop && !((Shop) object).isHidden()) {
						drawShopItems(g);
					}
				}
		
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
	
	public static LinkedList<Building> getBuildings() {
		return buildings;
	}
	
}
