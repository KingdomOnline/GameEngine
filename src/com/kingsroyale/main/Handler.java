package com.kingsroyale.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.kingsroyale.menus.HomeScreen;
import com.kingsroyale.objects.buildings.Building;
import com.kingsroyale.objects.shop.Shop;
import com.kingsroyale.objects.shop.ShopItem;

public class Handler {

	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	LinkedList<ShopItem> items = new LinkedList<ShopItem>();
	public static LinkedList<Building> buildings = new LinkedList<Building>();
	
	private HomeScreen hs;
	private Shop shop;
	
	public Handler(HomeScreen hs) {
		this.hs = hs;
	}
	
	
	public void setShop(Shop shop) {
		this.shop = shop;
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
					continue;
				} else {
					
					if (object.isShown()) object.render(g);
					
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
