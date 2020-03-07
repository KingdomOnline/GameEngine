package com.kingsroyale.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
//import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -2371765415379829617L;

	private Thread thread;
	private boolean running = false;
	static private Toolkit tk = Toolkit.getDefaultToolkit();
	static int width = (int) tk.getScreenSize().getWidth();
	static int height = (int) tk.getScreenSize().getHeight();
	
	public static String title = "Kings Royale";
	
	private Handler handler;
	//private Random r;
	
	
	public Game() {
		handler = new Handler();
		Player kingdomOwner = new Player(width/2 - 32, height/2 - 32, ID.Player);
		this.addKeyListener(new KeyInput(handler, kingdomOwner));
	
		
		new Window(title, this);
		
		//r = new Random();
		
		//generate 2000 test objects [stress test] (SUCCESS: 2,000+ frames)
		/*for (int i = 0; i < 2000; i++) {
			handler.addObject(new Player(r.nextInt(width), r.nextInt(height), ID.Player));
		}*/
		
		handler.addObject(kingdomOwner);
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
	
	public void run() {
		//Game Loop
		long lastTime = System.nanoTime();
		double tickCount = 60.0;
		double ns = 1000000000 / tickCount;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
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
				updateFPS(frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void updateFPS(int frames) {
		JFrame frame = Window.getFrame();
		JLabel fps = new JLabel("Frames Per Second");
		fps.setText(String.format("FPS: %s", frames));
		frame.getContentPane().add(fps);
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
		
		Graphics g = bs.getDrawGraphics();
		
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
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
