package com.kingsroyale.objects.buildings;

import java.awt.Color;
import java.awt.Graphics;

import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Building extends GameObject {
	
	private String icon;
	private String desc;
	private String province;
	private BuildingType type;
	private int width = 250;
	private int height = 250;
	
	public Building (int x, int y, ID id, BuildingType type, String icon, String description, String province) {
		super(x, y, id);
		
		this.icon = icon;
		this.desc = description;
		this.province = province;
		this.type = type;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		
		//temporary box to represent buildings
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setDescription(String description) {
		this.desc = description;
	}
	
	public String getDescription() {
		return desc;
	}
	
	//Cannot Change building location
	public String getProvince() {
		return province;
	}
	
	//Cannot change building type
	public BuildingType getType() {
		return type;
	}

}
