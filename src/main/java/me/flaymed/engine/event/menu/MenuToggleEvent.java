package me.flaymed.engine.event.menu;

import me.flaymed.engine.event.Cancellable;
import me.flaymed.engine.event.Event;
import me.flaymed.engine.menu.Menu;

public class MenuToggleEvent extends Event implements Cancellable {

    private Menu menu;
    private boolean cancelled = false;

    public MenuToggleEvent(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean var) {
        this.cancelled = var;
    }
}
