package com.kingsroyale.objects.shop;

public class ShopItem {
	
	private int x;
	private int y;
	private String name;
	private String desc;
	private String icon;
	private int cost;
	private int width = 350;
	private int height = 300;
	
	
	public ShopItem(int x, int y, String name, String desc, String icon, int cost) {
		
		this.setX(x);
		this.setY(y);
		this.name = name;
		this.desc = desc;
		this.icon = icon;
		this.cost = cost;
		
	}
	
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getIcon() {
		return icon;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
}
