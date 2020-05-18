package me.flaymed.engine.menu;

import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.util.KeyManager;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public abstract class Menu extends GameObject implements KeyManager {

    private double width, height;
    private int keycode;
    private Set<Button> buttons;

    public Menu(double x, double y, double width, double height, int keycode, Class<? extends Button>... buttons) {
        super(x, y, ObjectID.Menu, false);

        this.width = width;
        this.height = height;
        this.keycode = keycode;

        setUpButtons(buttons);
    }


    public abstract void toggledOn();


    @Override
    public void render(Graphics g) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressedKey = e.getKeyCode();

        if (pressedKey == keycode)
            toggledOn();
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
