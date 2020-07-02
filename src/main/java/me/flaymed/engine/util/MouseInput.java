package me.flaymed.engine.util;

import me.flaymed.engine.Game;
import me.flaymed.engine.menu.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class MouseInput implements MouseListener, MouseMotionListener {
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

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        //TODO: Setup Logic for cursor hovering buildings.
    }
}
