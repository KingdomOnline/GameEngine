package me.flaymed.engine.text;

import me.flaymed.engine.handler.ObjectID;
import me.flaymed.engine.handler.GameObject;

import java.awt.*;
import java.util.ArrayList;

public class TextItem extends GameObject {

    private ArrayList<String> textItems;
    private int fontsize;
    private String font;
    private Color color;
    private int fontStyle;

    public TextItem(ArrayList<String> textItems, int x, int y, int fontsize, String font, Color color, int fontStyle) {
        super(x, y, ObjectID.Text, false);
        this.textItems = textItems;
        this.fontsize = fontsize;
        this.font = font;
        this.color = color;
        this.fontStyle = fontStyle;
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setFont(new Font(font, fontStyle, fontsize));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < textItems.size(); i++) {
            g2.drawString(textItems.get(i), x, y + (i * fontsize));
        }
    }
}
