package me.flaymed.engine.entity;

import me.flaymed.engine.Game;
import me.flaymed.engine.handler.ObjectID;
import me.flaymed.engine.handler.GameObject;

public abstract class LivingEntity extends GameObject {

    private int width,height;
    private int mx, my;
    private double MAX_HP;
    private double hp;

    public LivingEntity(int x, int y, int MAX_HP, int hp, int width, int height) {
        super(x, y, ObjectID.LivingEntity, false);
        this.MAX_HP = MAX_HP;
        this.hp = hp;
        this.width = width;
        this.height = height;

        Game.getMainHandler().addObject(this);
    }

    abstract String getName();
    abstract EntityType getEntityType();

    private int clamp(int var, int min, int max) {
        if (var >= max) return var = max;
        else if (var <= min) return var = min;
        else return var;
    }

    public void moveIfNotMoving(int mx, int my) {
        if (getxVel() == 0 && getyVel() == 0)
            move(mx, my);
    }

    public void move(int mx, int my) {
        int currentXCenter = (int) (x  + (0.5 * getWidth()));
        int currentYCenter = (int) (y + (0.5 * getHeight()));
        int newXCenter = (int) (mx - (0.5 * getWidth()));
        int newYCenter = (int) (my - (0.5 * getHeight()));

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
        if (my == y)
            yVel = 0;

        if (mx == x)
            xVel = 0;

        x += xVel;
        y += yVel;
        x = clamp(x, 0, Game.getInstance().getWindowWidth() - getWidth());
        y = clamp(y, 0, Game.getInstance().getWindowHeight() - getHeight());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addHealth(double health) {
        this.hp += health;
    }

    public void subtractHealth(double health) {
        this.hp -= health;
    }

    public double getMAX_HP() {
        return MAX_HP;
    }

    public double getHp() {
        return hp;
    }

    public int getHpAsInteger() {
        return (int) getHp();
    }

    private void kill() {
        //Doesn't remove the object from game object lists so we can "revive" entities in the future.
        setShown(false);
    }

    public boolean isAlive() {
        return getHp() <= 0;
    }


}
