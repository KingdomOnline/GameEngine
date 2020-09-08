package me.flaymed.engine.entity.environment;

import me.flaymed.engine.entity.LivingEntity;
import java.awt.Graphics;
import java.awt.Color;

public class Lake extends EnvironmentObject {

    public Lake(int x, int y, int width, int height) {
        super(x, y, width, height);

    }

    @Override
    public void interact(LivingEntity entity) {
        entity.modifyThirst(10);
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
