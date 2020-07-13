package me.flaymed.engine.util;

import me.flaymed.engine.Game;
import me.flaymed.engine.GameState;
import me.flaymed.engine.menu.Menu;
import me.flaymed.engine.text.TextField;
import me.flaymed.engine.text.TextFieldManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class KeyInput extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (Game.getInstance().getState() == GameState.TYPING) checkTextFields(e);
        else checkMenus(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void checkMenus(KeyEvent e) {
        List<Menu> menus = Game.getMenus();

        for (Menu menu : menus) {
            if (e.getKeyCode() == menu.getKeycode()) menu.buttonPressed();
        }
    }

    private void checkTextFields(KeyEvent e) {
        List<TextField> textFields = TextFieldManager.getInstance().getTextFields();

        for (TextField textField : textFields) {
            if (textField.isShown())
                textField.addChar(e.getKeyChar());
        }

    }
}
