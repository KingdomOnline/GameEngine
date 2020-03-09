package com.kingsroyale.objects.shop;

public class ShopItem {
	
	private String name;
	private String desc;
	private String icon;
	private int cost;
	
	public ShopItem(String name, String desc, String icon, int cost) {
		
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
	
}
