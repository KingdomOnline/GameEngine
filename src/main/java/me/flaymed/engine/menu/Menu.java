package me.flaymed.engine.menu;

import me.flaymed.engine.Game;
import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public abstract class Menu extends GameObject {

    private int width, height;
    private int keycode;
    private LinkedList<Button> buttons;

    public Menu(int x, int  y, int width, int height, int keycode, Class<? extends Button>... buttons) {
        super(x, y, ObjectID.Menu, false);

        this.width = width;
        this.height = height;
        this.keycode = keycode;

        Game.getMainHandler().addObject(this);
        setUpButtons(buttons);
    }

    public void buttonPressed(KeyEvent e) {
        if (e.getKeyCode() == getKeycode())
            toggled();
    }

    public abstract void toggled();

    @Override
    public void render(Graphics g) {
        //TEMP
        g.setColor(Color.white);
        g.fillRect(this.x, this.y, this.width, this.height);
    }


    private void setUpButtons(Class<? extends Button>... buttons) {
        LinkedList<Button> buttonSet = new LinkedList<>();
        for (Class<? extends Button> button : buttons) {
            try {

                Button newButton = button.newInstance();
                buttonSet.add(newButton);

            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        this.buttons = buttonSet;

    }

    /**
     * This method assumes the buttons should be in a list!!!
     * @param x || x for where the buttons should start being listed
     * @param y || y for where the buttons should start being listed
     */
    public void configureButtonPosition(int x, int y) {

        int BUTTONS_PER_PAGE = 5;
        //start with the first button
        int buttonCount = 1;

        //Space between buttons in pixels
        int offset = 20;

        //New Y for button
        int buttonY;

        for (int i = 0; i < this.buttons.size(); i++) {

            Button button = this.buttons.get(i);

            if (buttonCount >= BUTTONS_PER_PAGE)
                buttonCount = 1;

            Button prevButton = this.buttons.get(i - 1);


            buttonY =  (prevButton.getY() + prevButton.getHeight()) + offset;
            button.setY(buttonY);

            if (buttonCount == 1)
                button.setY(y);

        }

    }

    public LinkedList<Button> getButtons() {
        return buttons;
    }

    @Override
    public void tick() {
        //You can override this if you need to use it, but this just cleans up any class that extends menu.
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getKeycode() {
        return keycode;
    }

}
