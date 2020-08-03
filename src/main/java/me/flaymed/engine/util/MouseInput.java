package me.flaymed.engine.util;

import me.flaymed.engine.Game;
import me.flaymed.engine.GameState;
import me.flaymed.engine.menu.Button;
import me.flaymed.engine.text.TextField;
import me.flaymed.engine.text.TextFieldManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MouseInput implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int mx = mouseEvent.getX();
        int my = mouseEvent.getY();

        List<Button> buttons = Game.getButtons();

        for (Button button : buttons) {
            if (mx >= button.getX() && mx <= button.getX() + button.getWidth() && my >= button.getY() && my < button.getY() + button.getHeight() && button.isShown())
                button.onClick();
        }

        for (TextField textField : TextFieldManager.getInstance().getTextFields()) {
            if (mx >= textField.getX() && mx <= textField.getX() + textField.getWidth() && my >= textField.getY() && my < textField.getY() + textField.getHeight() && textField.isShown()) {
                Game.getInstance().setState(GameState.TYPING);
                textField.setSelected(true);
            } else {
                Game.getInstance().setState(GameState.DEFAULT);
                textField.setSelected(false);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
