package me.flaymed.engine.listeners;

import me.flaymed.engine.event.EventHandler;
import me.flaymed.engine.event.Listener;
import me.flaymed.engine.event.menu.MenuRegisterEvent;

public class MenuRegisterListener extends Listener {

    @EventHandler
    public void menuRegistered(MenuRegisterEvent e) {
        System.out.println(String.format("[KingsRoyale] Registered Menu: %s", e.getMenuName()));
    }

}
