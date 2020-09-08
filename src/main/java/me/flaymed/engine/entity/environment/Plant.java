package me.flaymed.engine.entity.environment;

import me.flaymed.engine.entity.LivingEntity;
import java.awt.Graphics;

public class Plant extends EnvironmentObject {

    public Plant(int x, int y) {
        super(x, y, 20, 20);
    }

    @Override
    public void interact(LivingEntity entity) {
        remove();
        entity.modifyHunger(10);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
