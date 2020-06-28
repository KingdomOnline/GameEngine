package me.flaymed.engine.event;

public class Listener {
    public Listener() {
        EventManager.registerListener(this);
    }
}
