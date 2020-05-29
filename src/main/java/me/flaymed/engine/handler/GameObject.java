package me.flaymed.engine.handler;

import me.flaymed.engine.enums.ObjectID;

import java.awt.Graphics;

public abstract class GameObject {

    protected int x, y;
    protected ObjectID id;
    protected int xVel, yVel;
    protected boolean shown;

    public GameObject(int x, int y, ObjectID id, boolean shown) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.shown = shown;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    //ObjectID wont change so we don't need to have a setter.

    public ObjectID getID() {
        return id;
    }

    //Getter & Setter for x & y

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    //Getter & Setter for xVel & yVel

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public int getxVel() {
        return xVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }
    public int getyVel() {
        return yVel;
    }

    //Getter & Setter for shown

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public void toggleShown() {
        if (isShown())
            this.shown = false;
        else
            this.shown = true;
    }

    public boolean isShown() {
        return shown;
    }

}
