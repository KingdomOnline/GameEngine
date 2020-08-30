package me.flaymed.engine.entity.environment;

import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;
import java.awt.Graphics;
import java.awt.Color;

public class Lake extends GameObject {

    private int width, height;

    public Lake(int x, int y, int width, int height) {
        super(x, y, ObjectID.LivingEntity, false);

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.drawOval(getX(), getY(), getWidth(), getHeight());
    }
}
