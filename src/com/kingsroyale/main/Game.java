package com.kingsroyale.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.Queue;

import com.kingsroyale.menus.HomeScreen;
import com.kingsroyale.objects.Map;
import com.kingsroyale.objects.Player;
import com.kingsroyale.objects.buildings.Building;
import com.kingsroyale.objects.buildings.BuildingType;
import com.kingsroyale.objects.shop.Shop;
import com.kingsroyale.objects.shop.ShopItem;
import com.kingsroyale.objects.shop.ShopPage;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -2371765415379829617L;

	private Thread thread;
	private boolean running = false;
	static private Toolkit tk = Toolkit.getDefaultToolkit();
	public static int width = (int) tk.getScreenSize().getWidth();
	public static int height = (int) tk.getScreenSize().getHeight();
	public static Window gameWindow;
	public static String title = "Kings Royale";

	private HomeScreen hs;
	private Handler handler;
	private Shop mainShop;
	private LinkedList<ShopPage> pages = new LinkedList<>();
	
	private String[][] items = {{"Game1.", "Grows food for your village"}, {"Game2", "Grows food for your village"}, {"Game3", "Grows food for your village"}, {"Game4", "Grows food for your village"}, {"Game5", "Grows food for your village"}, {"Game6", "Grows food for your village"}, {"Game7", "Grows food for your village"}, {"Game8", "Grows food for your village"}};
	
	public Game() {
		
		hs = new HomeScreen(0, 0, ID.Menu, null);
		handler = new Handler(hs);
		
		mainShop = new Shop(0, 0, ID.Shop);
		mainShop.setShown(false);
		
		Player kingdomOwner = new Player(width/2 - 32, height/2 - 32, ID.Player);
		Map iconMap = new Map(0, 0, ID.Map);
		iconMap.setShown(false);
		handler.setShop(mainShop);
		gameWindow = new Window(title, this);
		this.addKeyListener(new KeyInput(handler, hs, kingdomOwner, iconMap, mainShop));
		this.addMouseListener(new MouseInput(hs, mainShop));

		//TODO: Make this generate buildings on province load. 
		for (int i = 0; i < 8; i++) {
			// <1920x1080
			if (Game.width < 1920) {
				if (i == 0) {
					Building townSquare = new Building(30, 30, ID.Building, BuildingType.Resident, "icon", "description", "province", Color.blue);
					handler.addBuilding(townSquare);
					handler.addObject(townSquare);
				} else {
					//250 + 20px gap between each building
					Building townSquare = new Building(30 + (170 * i), 30, ID.Building, BuildingType.Resident, "icon", "description", "province", Color.blue);
					handler.addBuilding(townSquare);
					handler.addObject(townSquare);
				}
			} else {
				// >=1920x1080
				if (i == 0) {
					Building townSquare = new Building(30, 30, ID.Building, BuildingType.Resident, "icon", "description", "province", Color.blue);
					//Add Building to building list for player collision.
					handler.addBuilding(townSquare);
					handler.addObject(townSquare);
				} else {
					//250 + 20px gap between each building
					Building townSquare = new Building(30 + (270 * i), 30, ID.Building, BuildingType.Resident, "icon", "description", "province", Color.blue);
					handler.addBuilding(townSquare);
					handler.addObject(townSquare);
				}
			}
		} 
		
		
		handler.addObject(kingdomOwner);
		//iconMap & mainShop must be lowest to ensure no other gameObjects render
		handler.addObject(iconMap);
		handler.addObject(mainShop);
		createShop();
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
	public Queue<Integer> frameQueue = new LinkedList<>();
	public int frames = 0;
	public void run() {
		//Game Loop
		long lastTime = System.nanoTime();
		double tickCount = 60.0;
		double ns = 1000000000 / tickCount;//16666666.6667
		double delta = 0;
		long timer = System.currentTimeMillis();
		long now;
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / ns;

//			System.out.println(String.format("last time: {%d} now:{%d} delta:{%g}",lastTime,now,delta));
			lastTime = now;
			while (delta >= 1) {
				tick();
				render();
				delta--;
			}
			
			if (running) {
				render();
			    frames++;
			}
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				if (frameQueue.size() >= 5){
					frameQueue.remove();
				}
				frameQueue.add(frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void updateFrames(Graphics g) {
		int avgframes =(frameQueue.size() == 0)?
				frames : frameQueue.parallelStream().mapToInt(
						frameCount -> frameCount).sum()/frameQueue.size();
		g.setColor(Color.red);
		g.setFont(new Font("Dialog", Font.BOLD, 18));
		g.drawString("FPS(avg 5): " + avgframes, 10, 20);//frames
		g.drawString("FPS: " + frames, 10, 40);//frames
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
	
	LinkedList<ShopItem> sendlist = new LinkedList<ShopItem>();
	
	public Shop createShop() {
		
		
		//Generate 1 page for every 6 items. 
		//If the amount of items doesn't split evenly, another page will be created for the 1 - 5 remaining items.
				
		double pageCount = Math.ceil(items.length/6.0);
		for (int i = 0; i < pageCount; i++) {
					
			ShopPage page = new ShopPage(40, 40, ID.Shop, i);
			page.setShown(false);
			pages.add(page);
			//handler.addObject(page);
			mainShop.addPage(page);
					
		}
		final int maxItemPerPage = 6;

		int itemsperpage = maxItemPerPage;
		for (int i = 0; i < pages.size(); i++) {
			if (i == pages.size() - 1) {// if its last page then do the remaining items
				itemsperpage = items.length%maxItemPerPage;
			}
			ShopPage page = pages.get(i);
			for (int n = 0; n < itemsperpage ; n++) {
				int itemNumber = i*maxItemPerPage + n;

				// i don't think ur 300 thing is needed idek up to u
				//Don't add 300px for first item
				/*if (n == 0) {
					ShopItem item = new ShopItem(40, (height/2) - 300, ID.Shop, items[itemNumber][0], items[itemNumber][1], null, 100);
					item.setShown(false);
					handler.addObject(item);
					page.addItem(item);
				} else {*/
					//System.out.println("i ="+ i + "n= "+n); check if it printed out the whole array
					//Add 20 to 300 for a 20px gap between each shop item

				//you could prob refactor this prettily
					Integer[] marginPos,basePos,itemPos,itemSize;
					marginPos = new Integer[]{40,20}; //arbitrary distance between objects
					basePos = new Integer[]{40, height / 2 - 300};//300 arbitrary starting point?40 abitrary too
					itemPos = new Integer[]{0,0};

					ShopItem item = new ShopItem(itemPos[0],itemPos[1], ID.Shop, items[itemNumber][0], items[itemNumber][1], null, 100);
				//300*2 top and bottom margin added up dere ^ maxitem -1 because we dont want the final margin between items
					int realSizeToFit = (height - (basePos[1]*2) - marginPos[1] * (maxItemPerPage -1))/maxItemPerPage;
					item.setHeight(realSizeToFit);


					itemSize = new Integer[]{item.getWidth(),item.getHeight()}; //x and y basically

					itemPos[0] = basePos[0] + (i * (itemSize[0] + marginPos[0]));
					itemPos[1] = basePos[1] + (n * (itemSize[1] + marginPos[1]));

					item.setX(itemPos[0]);//should have setPos(x,y) tbh
					item.setY(itemPos[1]);//should have setPos tbh

					item.setShown(false);
					handler.addItem(item);//addItem(item); or addObject? which one are you using?
					page.addItem(item);
				//}
			}	
		}
		
		return mainShop;

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
