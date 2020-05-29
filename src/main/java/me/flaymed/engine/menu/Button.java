package me.flaymed.engine.menu;

import me.flaymed.engine.Game;
import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;
import java.awt.Graphics;
import java.awt.Color;

public abstract class Button extends GameObject {

    private int width, height;
    //TODO: variable for image

    public Button(int x, int y, int width, int height) {
        super(x, y, ObjectID.Button, false);

        this.width = width;
        this.height = height;

        //Your not creating a button before the Game therefore this should always return the mainHandler defined when Game was constructed.
        Game.getMainHandler().addObject(this);
        Game.getButtons().add(this);
        //TODO: create an Image class for pulling the button off a sprite sheet.
    }

    @Override
    public void tick() {
        //Buttons won't change (I think) so this method is left empty, it can always be overridden with @Override
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect(this.x, this.y, this.width, this.height);

        //TODO: render the image set for this button

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void onClick();

}
