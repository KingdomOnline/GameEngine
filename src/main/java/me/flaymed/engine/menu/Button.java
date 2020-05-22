package me.flaymed.engine.menu;

import me.flaymed.engine.Game;
import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;

import java.awt.*;
import java.awt.event.MouseEvent;

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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public abstract void onClick();

    public void mouseClicked(MouseEvent mouseEvent) {
        int mx = mouseEvent.getX();
        int my = mouseEvent.getY();

        if (mx >= this.x && mx <= this.x + getWidth() && my >= this.y && my < this.y + getHeight())
            onClick();

    }
}
