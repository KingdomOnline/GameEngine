package me.flaymed.engine;

import me.flaymed.engine.handler.Handler;
import me.flaymed.engine.listener.MenuToggleListener;
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

public class Game extends Canvas {

    private boolean running = false;
    private Window gameWindow;
    private GameState state;
    private static Handler mainHandler;
    private int width, height;
    private static List<Menu> menus;
    private static List<Button> buttons;
    private Thread tickThread;
    private Thread renderThread;
    private static Game instance = null;

    public Game(String title, int width, int height) {

        setUpListeners();
        registerThreads();

        this.mainHandler = new Handler();
        this.gameWindow = new Window(title, this);
        this.state = GameState.Menu;
        this.width = width;
        this.height = height;
        this.menus = new LinkedList<>();
        this.buttons = new LinkedList<>();
        instance = this;
    }

    //This method will never be called before the game is constructed, therefor we don't need a null pointer check.
    //Makes no sense to make a new game instance if it's null because we cannot create a new game without knowing the size or title
    public static Game getInstance() {
        return instance;
    }

    public synchronized void start() {
        tickThread.start();
        renderThread.start();
        running = true;
        System.out.println("Game started!");
    }

    public synchronized void stop() {
        try {
            System.exit(0);
            tickThread.join();
            renderThread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerThreads() {
        tickThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Tick Loop
                int frames = 0;
                long lastTime = System.nanoTime();
                double tickCount = 60.0;
                double ns = 200000000 / tickCount;
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
                        delta--;
                    }

                    if (running) {
                        frames++;
                    }
                    if (System.currentTimeMillis() - timer > 1000) {
                        timer += 1000;
                        frames = 0;
                    }
                }
                stop();
            }
        });

        renderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning()) {
                    render();
                }
            }
        });
    }

    public void tick() {
        mainHandler.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        final Graphics g = bs.getDrawGraphics();

        //background
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        //render objects
        mainHandler.render(g);

        g.dispose();
        bs.show();
    }

    private void setUpListeners() {
        this.addKeyListener(new KeyInput());
        this.addMouseListener(new MouseInput());
        new MenuToggleListener();
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
