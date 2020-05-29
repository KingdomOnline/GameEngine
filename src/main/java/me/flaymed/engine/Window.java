package me.flaymed.engine;

import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Window {

    private JFrame frame;

    public Window (String title, Game game) {

        //JFrame = frame of the window
        frame = new JFrame(title);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);


        //requiered to set full screen on linux.
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(frame);


        frame.setVisible(true);
        frame.setFocusable(true);

        game.start();
    }

    public JFrame getFrame() {
        return frame;
    }

}
