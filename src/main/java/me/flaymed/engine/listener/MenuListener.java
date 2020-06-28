package me.flaymed.engine.listener;

import me.flaymed.engine.event.EventHandler;
import me.flaymed.engine.event.Listener;
import me.flaymed.engine.event.menu.MenuToggleEvent;

public class MenuListener extends Listener {

    public MenuListener() {

    }

    @EventHandler
    public void menuToggleEvent(MenuToggleEvent e) {
        System.out.println("It works!");
        e.setCancelled(true);
    }

}
