package me.flaymed.engine.text;

import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;

import java.awt.*;

public class TextField extends GameObject {

    private String label;
    private int width, height;
    private Color color = Color.WHITE;
    private char[] characters;
    private int fontsize;
    private int margin;

    public TextField(String label, int x, int y, int width, int height, int fontsize, int margin) {
        super(x, y, ObjectID.Text, false);

        this.label = label;
        this.width = width;
        this.height = height;
        this.fontsize = fontsize;
        this.margin = margin;

        TextFieldManager.getInstance().addTextField(this);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addChar(char character) {
        characters[characters.length] = character;
    }

    public char[] getCharacters() {
        return characters;
    }

    public int getMargin() {
        return margin;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setFont(new Font(null, Font.PLAIN, fontsize));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString(getLabel(), getX() - (fontsize * getLabel().length()) - margin, (float) (getY() + (0.5 * getWidth()) - (0.5 * fontsize)));
        for (int i = 0; i < getCharacters().length; i++) {
            g2.drawString(String.valueOf(getCharacters()[i]), getX() + getMargin() + (i * fontsize), getY());
        }
    }
}
