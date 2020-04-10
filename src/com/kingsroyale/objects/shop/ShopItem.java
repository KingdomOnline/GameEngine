package com.kingsroyale.objects.shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class ShopItem extends GameObject {
	private String name;
	private String desc;
	private String icon;
	private int cost;
	private int width = 350;
	private int height = 300;
	
	public ShopItem(int x, int y, ID id, String name, String desc, String icon, int cost) {
		
		super(x, y, id);
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

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(Color.black);
		g.setFont(new Font("MS PGothic", Font.PLAIN, 36));
		g.drawString(getName(), getX() + 20, getY() + 45);
		
	}
	
}
