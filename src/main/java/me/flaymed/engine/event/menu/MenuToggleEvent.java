package me.flaymed.engine.event.menu;

import me.flaymed.engine.event.Event;
import me.flaymed.engine.menu.Menu;

public class MenuToggleEvent extends Event {

    private Menu menu;

    public MenuToggleEvent(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
}
