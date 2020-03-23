package com.kingsroyale.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import com.kingsroyale.menus.HomeScreen;
import com.kingsroyale.objects.Map;
import com.kingsroyale.objects.Player;
import com.kingsroyale.objects.buildings.Building;
import com.kingsroyale.objects.buildings.BuildingType;
import com.kingsroyale.objects.shop.Shop;
import com.kingsroyale.objects.shop.ShopItem;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -2371765415379829617L;

	private Thread thread;
	private boolean running = false;
	static private Toolkit tk = Toolkit.getDefaultToolkit();
	public static int width = (int) tk.getScreenSize().getWidth();
	public static int height = (int) tk.getScreenSize().getHeight();
	public static Window gameWindow;
	public static String title = "Kings Royale";


	private Handler handler;
	//private Random r;
	
	
	public Game() {
		HomeScreen hs = new HomeScreen(0, 0, ID.Menu, null);
		handler = new Handler(hs);
		
		Player kingdomOwner = new Player(width/2 - 32, height/2 - 32, ID.Player);
		Map iconMap = new Map(0, 0, ID.Map, true);
		Shop mainShop = new Shop(0, 0, ID.Shop, true);
		gameWindow = new Window(title, this);
		this.addKeyListener(new KeyInput(handler, hs, kingdomOwner, iconMap, mainShop));
		this.addMouseListener(new MouseInput(hs));
		

		
		setShopItems("filler text");

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				Building townSquare = new Building(30, 30, ID.Building, BuildingType.Resident, "icon", "description", "province", Color.blue);
				//Add Building to building list for player collision.
				handler.addBuilding(townSquare);
				//Add Building to Object List for rendering
				handler.addObject(townSquare);
			} else {
				//250 + 20px gap between each building
				Building townSquare = new Building(30 + (270 * i), 30, ID.Building, BuildingType.Resident, "icon", "description", "province", Color.blue);
				//Add Building to building list for player collision.
				handler.addBuilding(townSquare);
				//Add Building to Object List for rendering
				handler.addObject(townSquare);
			}
		}
		
		
		handler.addObject(kingdomOwner);
		//iconMap & mainShop must be lowest to ensure no other gameObjects render
		handler.addObject(iconMap);
		handler.addObject(mainShop);
		handler.addObject(hs);

	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int frames = 0;
	public void run() {
		//Game Loop
		long lastTime = System.nanoTime();
		double tickCount = 60.0;
		double ns = 1000000000 / tickCount;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			
			if (running) 
				render(); 
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	private void updateFrames(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Dialog", Font.BOLD, 18));
		g.drawString("FPS: " + frames, 10, 20);
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		final Graphics g = bs.getDrawGraphics();
		
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		updateFrames(g);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public void setShopItems(String items) {
		//TODO parse string form of json data
		
		for (int i = 0; i < 2; i++) {
			//Don't add 300px for first item
			if (i == 0) {
				ShopItem item = new ShopItem(40, (height/2) - 300, "Farm", "A hut for your people", null, 100); 
				handler.addItem(item);
			} else {
				//Add 20 to 300 for a 20px gap between each shop item
				ShopItem item = new ShopItem(40, (height/2) + (i * 20), "Farm", "A hut for your people", null, 100); 
				handler.addItem(item);
			}
		}
	}
	
	public static int clamp(int var, int min, int max) {
		if (var >= max) return var = max;
		else if (var <= min) return var = min;
		else return var;
	}
	
	public static void main(String args[]) {
		new Game();
	}

}
