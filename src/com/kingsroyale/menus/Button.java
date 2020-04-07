package com.kingsroyale.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Button extends GameObject {

	private String value;
	private int width;
	private int height;
	private Rectangle buttonShape;
	
	public Button (int x, int y, ID id, String value, int width, int height) {
		super(x, y, id);
		
		this.value = value;
		this.width = width;
		this.height = height;
		this.buttonShape = new Rectangle(x, y, width, height);
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
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(Color.decode("#388BFF"));
		g.drawString(this.value, this.x + 18, this.y + 35);
		
		g2d.draw(buttonShape);
	
	}
	
}
