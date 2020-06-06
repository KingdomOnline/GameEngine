package me.flaymed.engine.menu;

import me.flaymed.engine.Game;
import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.text.TextItem;

import java.awt.*;
import java.util.ArrayList;

public abstract class Button extends GameObject {

    private int width, height;
    private TextItem textItem;
    private ArrayList<String> text = new ArrayList<String>();

    public Button(int x, int y, int width, int height, String name) {
        super(x, y, ObjectID.Button, false);

        text.add(name);

        this.width = width;
        this.height = height;
        this.textItem = new TextItem(text, getX() + (getWidth()/4), getY() + (getHeight()/3), 18, "MS PGothic", Color.BLACK, Font.PLAIN);

        //Your not creating a button before the Game therefore this should always return the mainHandler defined when Game was constructed.
        Game.getMainHandler().addObject(this);
        Game.getButtons().add(this);
    }

    @Override
    public void tick() {
        //Buttons won't change (I think) so this method is left empty, it can always be overridden with @Override
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect(this.x, this.y, this.width, this.height);
        textItem.render(g);

        //TODO: render the image set for this button

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TextItem getTextItem() {
        return textItem;
    }

    public void refactorTextItem(int x, int y) {
        getTextItem().setX(x + (getWidth()/4));
        getTextItem().setY(y + (getHeight()/2));
    }

    public abstract void onClick();

}
