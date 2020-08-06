package me.flaymed.engine.event.loading;

import me.flaymed.engine.event.Cancellable;
import me.flaymed.engine.event.Event;
import me.flaymed.engine.loading.LoadingScreen;

public class LoadingScreenCreateEvent extends Event implements Cancellable {

    private LoadingScreen screen;
    private boolean isCancelled = false;

    public LoadingScreenCreateEvent(LoadingScreen screen) {
        this.screen = screen;
    }

    public LoadingScreen getScreen() {
        return screen;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean var) {
        this.isCancelled = var;
    }
}
