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
            if (object.isShown()) object.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject object : objects) {
            if (object.isShown())
                object.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

}
