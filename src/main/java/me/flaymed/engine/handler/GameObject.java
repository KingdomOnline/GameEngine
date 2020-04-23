package me.flaymed.engine.handler;

import me.flaymed.engine.enums.ObjectID;

import java.awt.Graphics;

public abstract class GameObject {

    protected double x, y;
    protected ObjectID id;
    protected double xVel, yVel;
    protected boolean shown;

    public GameObject(double x, double y, ObjectID id, boolean shown) {
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

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    //Getter & Setter for xVel & yVel

    public void setxVel(double xVel) {
        this.xVel = xVel;
    }

    public double getxVel() {
        return xVel;
    }

    public void setyVel(double yVel) {
        this.yVel = yVel;
    }
    public double getyVel() {
        return yVel;
    }

    //Getter & Setter for shown

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public boolean isShown() {
        return shown;
    }

}
