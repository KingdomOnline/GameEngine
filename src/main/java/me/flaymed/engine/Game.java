package me.flaymed.engine;

import java.awt.*;

public class Game extends Canvas {

    private Window gameWindow;
    private Thread windowThread;

    public Game(String title) {
        this.gameWindow = new Window(title, this);
    }

    public synchronized void start() {
        
    }

}
