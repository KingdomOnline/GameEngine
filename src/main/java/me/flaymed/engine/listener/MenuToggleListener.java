package me.flaymed.engine.listener;

import me.flaymed.engine.event.EventHandler;
import me.flaymed.engine.event.Listener;
import me.flaymed.engine.event.menu.MenuToggleEvent;

public class MenuToggleListener extends Listener {

    @EventHandler
    public void menuToggled(MenuToggleEvent e) {
        System.out.println(e.getMenu().isShown());
    }
}
