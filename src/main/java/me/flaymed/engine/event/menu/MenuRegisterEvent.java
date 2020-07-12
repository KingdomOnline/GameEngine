package me.flaymed.engine.event.menu;

import me.flaymed.engine.event.Event;
import me.flaymed.engine.menu.Menu;

public class MenuRegisterEvent extends Event {

    private Menu menu;
    private String menuName;

    public MenuRegisterEvent(Menu menu) {
        this.menu = menu;
        this.menuName = menu.getClass().getSimpleName();
    }

    public Menu getMenu() {
        return menu;
    }

    public String getMenuName() {
        return menuName;
    }
}
