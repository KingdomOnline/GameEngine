package me.flaymed.engine.event.loading;

import me.flaymed.engine.event.Event;
import me.flaymed.engine.loading.LoadingScreen;

public class LoadingFinishEvent extends Event {

    private LoadingScreen screen;

    public LoadingFinishEvent(LoadingScreen screen) {
        this.screen = screen;
    }

    public LoadingScreen getScreen() {
        return screen;
    }

}
