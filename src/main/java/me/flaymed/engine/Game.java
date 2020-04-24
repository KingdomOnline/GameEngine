package me.flaymed.engine;

import me.flaymed.engine.enums.GameState;
import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

    private boolean running = false;
    private Window gameWindow;
    private Thread windowThread;
    private GameState state;


    public Game(String title) {
        this.gameWindow = new Window(title, this);
        this.state = GameState.Menu;
    }

    public synchronized void start() {
        running = true;
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

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
       return running;
    }

}
