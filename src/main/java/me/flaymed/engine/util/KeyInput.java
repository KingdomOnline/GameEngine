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
        GameState gameState = Game.getInstance().getState();

        if (gameState == GameState.LOADING || gameState == GameState.Closing) return;
        if (gameState == GameState.TYPING) checkTextFields(e);
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER) Game.getInstance().setState(GameState.DEFAULT);

        List<TextField> textFields = TextFieldManager.getInstance().getTextFields();

        for (TextField textField : textFields) {
            if (textField.isShown())
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) textField.removeLastChar();
                else textField.addChar(e.getKeyChar());
        }

    }
}
