package com.kingsroyale.menus;

import java.awt.Graphics;
import java.util.LinkedList;

import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class Menu extends GameObject {
	
	private LinkedList<Button> buttons = new LinkedList<Button>();

	public Menu(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	public void tick() {}
	public void render(Graphics g) {}

	public LinkedList<Button> getButtons() {
		return buttons;
	}
	
	public void addButton(Button b) {
		this.buttons.add(b);
	}
	
	public void removeButton(Button b) {
		this.buttons.remove(b);
	};

}
