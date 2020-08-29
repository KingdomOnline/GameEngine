package me.flaymed.engine.entity;

import me.flaymed.engine.Game;
import me.flaymed.engine.entity.damage.DamageType;
import me.flaymed.engine.event.EventManager;
import me.flaymed.engine.event.entity.EntityDamageEvent;
import me.flaymed.engine.event.entity.EntityDeathEvent;
import me.flaymed.engine.event.entity.EntitySpawnEvent;
import me.flaymed.engine.handler.ObjectID;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.util.RandomPositionGenerator;

public abstract class LivingEntity extends GameObject {

    private int width,height;
    private int mx, my;
    private double MAX_HP;
    private double hp;
    private double thirst;
    private double hunger;

    public LivingEntity(int x, int y, int MAX_HP, int hp, int width, int height) {
        super(x, y, ObjectID.LivingEntity, false);
        this.MAX_HP = MAX_HP;
        this.hp = hp;
        this.width = width;
        this.height = height;
        this.thirst = 100;
        this.hunger = 100;

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
        if (!isMoving())
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
        manageHunger();
        manageThirst();
        checkIfDead();
        manageMovement();
    }

    private void manageHunger() {

    }

    private void manageThirst() {

    }

    private void checkIfDead() {
        if (!isAlive()) kill();
    }

    private void manageMovement() {

        moveIfNotMoving(RandomPositionGenerator.generateRandomValue(0, Game.getInstance().getWindowWidth()), RandomPositionGenerator.generateRandomValue(0, Game.getInstance().getWindowHeight()));

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

    public void heal(double amount) {
        this.hp += amount;
        if (getHp() > getMAX_HP()) this.hp = getMAX_HP();
    }

    public void damage(double amount, DamageType type) {
        if (!EventManager.callEvent(new EntityDamageEvent(this, amount, type))) {
            this.hp -= amount;
            if (getHp() < 0) this.hp = 0;
        }
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

    public void spawn() {
        if (!EventManager.callEvent(new EntitySpawnEvent(this))) {
            this.hp = getMAX_HP();
            setShown(true);
            EntityManager.getInstance().registerEntity(this);
        }
    }

    public void kill() {
        if (!EventManager.callEvent(new EntityDeathEvent(this))) {
            this.hp = 0;
            setShown(false);
        }
    }

    public void removeFromGame() {
        EntityManager.getInstance().unregisterEntity(this);
        Game.getMainHandler().removeObject(this);
    }

    public boolean isAlive() {
        return getHp() <= 0;
    }

    public boolean isMoving() {
        return getxVel() == 0 && getyVel() == 0;
    }

}
