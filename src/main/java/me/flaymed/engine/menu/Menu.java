package me.flaymed.engine.menu;

import me.flaymed.engine.Game;
import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public abstract class Menu extends GameObject {

    private int width, height;
    private int keycode;
    private Set<Button> buttons;

    public Menu(int x, int  y, int width, int height, int keycode, Class<? extends Button>... buttons) {
        super(x, y, ObjectID.Menu, true);

        this.width = width;
        this.height = height;
        this.keycode = keycode;

        Game.getMainHandler().addObject(this);
        setUpButtons(buttons);
    }

    public void buttonPressed(KeyEvent e) {
        if (e.getKeyCode() == this.keycode)
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
        Set<Button> buttonSet = new HashSet<>();
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

    public Set<Button> getButtons() {
        return buttons;
    }

}
