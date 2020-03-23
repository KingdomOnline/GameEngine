package com.kingsroyale.menus;


import java.awt.*;
import java.util.LinkedList;

import com.kingsroyale.main.Game;
import com.kingsroyale.main.GameObject;
import com.kingsroyale.main.ID;

public class HomeScreen extends GameObject {
	
	private LinkedList<Button> buttons;
	private boolean shown = true;
	
	public static Rectangle playButton = new Rectangle((Game.width / 2) - 50, (Game.height/4) + 50, 100, 50);
	public static Rectangle helpButton = new Rectangle((Game.width / 2) - 50, (Game.height/4) + 125, 100, 50);
	public static Rectangle quitButton = new Rectangle((Game.width / 2) - 50, (Game.height/4) + 200, 100, 50);
	
	public HomeScreen(int x, int y, ID id, LinkedList<Button> buttons) {
		super(x, y, id);
		
		this.buttons = buttons;
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.setColor(Color.decode("#388BFF"));
		g.drawString("Kings Royale", (Game.width/2) - 145, Game.height/4);
		
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Play", playButton.x + 20, playButton.y + 35);
		g.drawString("Help", helpButton.x + 20, helpButton.y + 35);
		g.drawString("Quit", quitButton.x + 20, quitButton.y + 35);
		
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(quitButton);
		
	}

	public boolean isShown() {
		return shown;
	}

	public void setShown(boolean shown) {
		this.shown = shown;
	}
	
	

}
