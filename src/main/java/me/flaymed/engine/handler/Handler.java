package me.flaymed.engine.handler;

import java.util.LinkedList;
import java.util.List;

public class Handler {

    List<GameObject> objects;

    public Handler() {
        this.objects = new LinkedList<>();
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

}
