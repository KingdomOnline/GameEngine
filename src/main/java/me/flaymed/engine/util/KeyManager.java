package me.flaymed.engine.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface KeyManager extends KeyListener {

    void keyPressed(KeyEvent e);
    void keyReleased(KeyEvent e);
}
