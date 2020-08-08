package me.flaymed.engine.listeners;

import me.flaymed.engine.event.EventHandler;
import me.flaymed.engine.event.Listener;
import me.flaymed.engine.event.menu.MenuToggleEvent;
import me.flaymed.engine.menu.Menu;
import me.flaymed.engine.menu.TextFields;
import me.flaymed.engine.text.TextField;

public class MenuToggleListener extends Listener {

    @EventHandler
    public void menuToggled(MenuToggleEvent e) {
        Menu menu = e.getMenu();
        if (menu instanceof TextFields) {
            for (TextField field : ((TextFields) menu).getTextFields()) {
                field.setShown(menu.isShown());
            }
        }
    }
}
