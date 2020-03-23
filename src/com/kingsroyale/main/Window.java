package com.kingsroyale.main;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 140864808419304893L;
	private static JFrame frame;
	private static boolean fullScreen = true;
	
	public Window (String title, Game game) {
		
		//JFrame = frame of the window
		frame = new JFrame(title);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		frame.setFocusable(true);
		game.start();
	
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static void setFullScreen(boolean fullScreenBool) {
		fullScreen = fullScreenBool;
	}
	
	public static boolean isFullScreen() {
		return fullScreen;
	}
}
