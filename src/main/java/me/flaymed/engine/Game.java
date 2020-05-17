package me.flaymed.engine;

import me.flaymed.engine.enums.GameState;
import me.flaymed.engine.handler.Handler;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

    private boolean running = false;
    private Window gameWindow;
    private Thread windowThread;
    private GameState state;
    private Handler mainHandler;

    public Game(String title) {
        this.gameWindow = new Window(title, this);
        this.state = GameState.Menu;
        this.mainHandler = new Handler();
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

    public Handler getMainHandler() {
        return mainHandler;
    }

}
