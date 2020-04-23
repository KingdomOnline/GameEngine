package me.flaymed.engine;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

    private boolean running = false;
    private Window gameWindow;
    private Thread windowThread;

    public Game(String title) {
        this.gameWindow = new Window(title, this);
    }

    public synchronized void start() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public synchronized void stop() {
        try {
            windowThread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {

    }

    public Window getGameWindow() {
        return gameWindow;
    }

}
