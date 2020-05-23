package me.flaymed.engine.menu.shop;

import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.menu.Button;

import java.awt.Graphics;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class ShopItem extends GameObject {

    private Set<Button> buttons;
    private String description;
    private int cost;

    public ShopItem(int x, int y, String description, int cost, Class<? extends Button>... buttons) {
        super(x, y, ObjectID.Menu, false);

        this.description = description;
        this.cost = cost;

        setUpButtons(buttons);
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

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        //temp

        g.setColor(Color.green);
        g.fillRect(0, 0, 10, 10);
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
}
