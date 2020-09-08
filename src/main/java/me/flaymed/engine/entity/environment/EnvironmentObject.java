package me.flaymed.engine.entity.environment;

import me.flaymed.engine.Game;
import me.flaymed.engine.entity.LivingEntity;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;

import java.awt.*;

public abstract class EnvironmentObject extends GameObject {

    private int width, height;

    public EnvironmentObject(int x, int y, int width, int height) {
        super(x, y, ObjectID.EnvironmentObject, false);

        this.width = width;
        this.height = height;

        Game.getMainHandler().addObject(this);
    }

    public abstract void interact(LivingEntity entity);

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void remove() {
        Game.getMainHandler().removeObject(this);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
