package com.kingsroyale.menus;

import javax.swing.JFrame;

public class Button {

	private String value;
	private JFrame frame;
	private int x;
	private int y;
	
	public Button (JFrame frame, String value, int x, int y) {
		this.value = value;
		this.frame = frame;
		this.x = x;
		this.y = y;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
