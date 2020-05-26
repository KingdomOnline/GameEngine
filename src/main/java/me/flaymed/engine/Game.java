package me.flaymed.engine;

import me.flaymed.engine.enums.GameState;
import me.flaymed.engine.handler.Handler;
import me.flaymed.engine.menu.Button;
import me.flaymed.engine.menu.Menu;
import me.flaymed.engine.util.KeyInput;
import me.flaymed.engine.util.MouseInput;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.List;

public class Game extends Canvas implements Runnable{

    private boolean running = false;
    private Window gameWindow;
    private Thread windowThread;
    private GameState state;
    private static Handler mainHandler;
    private int width, height;
    private static List<Menu> menus;
    private static List<Button> buttons;

    public Game(String title, int width, int height) {
        this.gameWindow = new Window(title, this);
        this.state = GameState.Menu;
        this.mainHandler = new Handler();
        this.width = width;
        this.height = height;
        this.menus = new LinkedList<>();
        this.buttons = new LinkedList<>();

        setUpListeners();
    }

    public synchronized void start() {
        running = true;
        windowThread = new Thread(this);
        windowThread.start();
    }

    public synchronized void stop() {
        try {
            System.exit(0);
            windowThread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        //TODO: Add a basic gameloop for this (not player loop)

        while(isRunning()) {
            render();
        }

    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        final Graphics g = bs.getDrawGraphics();

        //background
        g.setColor(Color.red);
        g.fillRect(0, 0, width, height);

        //render objects
        mainHandler.render(g);

        g.dispose();
        bs.show();
    }

    private void setUpListeners() {
        this.addKeyListener(new KeyInput());
        this.addMouseListener(new MouseInput());
    }

    public Window getGameWindow() {
        return gameWindow;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public boolean isRunning() {
       return running;
    }

    public static Handler getMainHandler() {
        if (mainHandler == null)
            return new Handler();
        else
            return mainHandler;
    }

    public int getWindowWidth() {
        return width;
    }

    public int getWindowHeight() {
         return height;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public static List<Menu> getMenus() {

        //Shouldn't happen
        if (menus == null) {
            menus = new LinkedList<>();
        }
        return menus;
    }

    public void addButton(Button button) {
        this.buttons.add(button);
    }

    public static List<Button> getButtons() {

        //Shouldn't happen
        if (buttons == null)
            buttons = new LinkedList<>();

        return buttons;
    }

}
