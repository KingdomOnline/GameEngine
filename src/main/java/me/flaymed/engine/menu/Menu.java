package me.flaymed.engine.menu;

import me.flaymed.engine.Game;
import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public abstract class Menu extends GameObject {

    int BUTTONS_PER_PAGE = 5;
    int buttonCount;

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
     * @param offset || distance in pixels between buttons
     */
    public void listButtonsVertically(int x, int y, int offset) {
        //start with the first button
        this.buttonCount = 1;

        //New Y for button
        int buttonY;

        for (int i = 0; i < this.buttons.size(); i++) {
            Button button = this.buttons.get(i);

            if (this.buttonCount >= BUTTONS_PER_PAGE)
                this.buttonCount = 1;

            if (this.buttonCount == 1)
                buttonY = y;
            else {
                Button prevButton = this.buttons.get(i - 1);
                buttonY =  (prevButton.getY() + prevButton.getHeight()) + offset;
            }

            button.setY(buttonY);
            //Buttons have a uniform X
            button.setX(x);

            this.buttonCount++;
        }

    }

    /**
     *
     * @param x || x for where buttons should start being listed
     * @param y || y for where buttons should start being listed
     * @param offset || distance in pixels between buttons
     */
    public void listButtonsHorizontally(int x, int y, int offset) {
        //start with the first button
        this.buttonCount = 1;

        //New X for button
        int buttonX;

        for (int i = 0; i < getButtons().size(); i++) {
            Button button = getButtons().get(i);

            if (this.buttonCount >= BUTTONS_PER_PAGE)
                this.buttonCount = 1;


            if (this.buttonCount == 1)
                buttonX = x;
            else {
                Button prevButton = getButtons().get(i - 1);
                buttonX = (prevButton.getX() + prevButton.getWidth()) + offset;
            }

            button.setX(buttonX);
            //Buttons will have uniform y
            button.setY(y);

            this.buttonCount++;
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
