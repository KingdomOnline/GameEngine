package me.flaymed.engine.handler;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Handler {

    private List<GameObject> objects;

    public Handler() {
        this.objects = new LinkedList<>();
    }

    public void tick() {
        for (GameObject object : objects) {
            object.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject object : objects) {
            object.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

}
