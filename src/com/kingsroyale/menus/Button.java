package com.kingsroyale.menus;

import java.awt.Graphics;

import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Button extends GameObject {

	private String value;
	
	public Button (int x, int y, ID id, String value) {
		super(x, y, id);
		
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
