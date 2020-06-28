package me.flaymed.engine.event;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean var);
}
