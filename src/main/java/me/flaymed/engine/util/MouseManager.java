package me.flaymed.engine.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface MouseManager extends MouseListener {

    @Override
    void mouseClicked(MouseEvent mouseEvent);

    @Override
    void mousePressed(MouseEvent mouseEvent);

    @Override
    void mouseReleased(MouseEvent mouseEvent);

    @Override
    void mouseEntered(MouseEvent mouseEvent);

    @Override
    void mouseExited(MouseEvent mouseEvent);
}
