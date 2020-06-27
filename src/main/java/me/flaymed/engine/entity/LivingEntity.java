package me.flaymed.engine.entity;

import me.flaymed.engine.Game;
import me.flaymed.engine.enums.ObjectID;
import me.flaymed.engine.handler.GameObject;
import java.awt.Graphics;

public class LivingEntity extends GameObject {

    private int width,height;
    private int mx, my;

    public LivingEntity(int x, int y) {
        super(x, y, ObjectID.LivingEntity, false);

        Game.getMainHandler().addObject(this);
    }

    private int clamp(int var, int min, int max) {
        if (var >= max) return var = max;
        else if (var <= min) return var = min;
        else return var;
    }

    public void move(int mx, int my) {

        int currentXCenter = (int) (x  + (0.5 * width));
        int currentYCenter = (int) (y + (0.5 * height));
        int newXCenter = (int) (mx - (0.5 * width));
        int newYCenter = (int) (my - (0.5 * height));

        if (mx > currentXCenter)
            xVel = 1;

        if (mx < currentXCenter)
            xVel = -1;

        if (my > currentYCenter)
            yVel = 1;

        if (my < currentYCenter)
            yVel = -1;

        this.mx = newXCenter;
        this.my = newYCenter;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {

    }
}
