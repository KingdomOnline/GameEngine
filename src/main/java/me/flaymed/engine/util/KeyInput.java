package me.flaymed.engine.util;

import me.flaymed.engine.Game;
import me.flaymed.engine.menu.Menu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class KeyInput extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        List<Menu> menus = Game.getMenus();

        for (Menu menu : menus) {
            menu.buttonPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
