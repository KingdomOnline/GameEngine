package me.flaymed.engine.entity.environment;

import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;

import java.awt.Graphics;

public class Plant extends GameObject {

    public Plant(int x, int y) {
        super(x, y, ObjectID.LivingEntity, false);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
