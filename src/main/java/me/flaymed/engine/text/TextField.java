package me.flaymed.engine.text;

import me.flaymed.engine.Game;
import me.flaymed.engine.GameState;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;
import me.flaymed.engine.menu.Button;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class TextField extends GameObject {

    private String label;
    private int width, height;
    private Color color;
    private String content;
    private int fontsize;
    private int margin;
    private String allowedChars = "1234567890qwertyuiopasdfghjklzxcvbnm_";

    public TextField(String label, int x, int y, int width, int height, int fontsize, int margin) {
        super(x, y, ObjectID.Text, false);

        this.color = Color.WHITE;
        this.label = label;
        this.width = width;
        this.height = height;
        this.fontsize = fontsize;
        this.margin = margin;
        this.content = "";

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
        if (!allowedChars.contains(String.valueOf(character).toLowerCase())) return;
        int length = getContent().length();
        if (length * (getFontsize()/2) - getMargin() >= getWidth()) return;
        this.content += character;
    }

    public void removeLastChar() {
        if (getContent().length() > 0) this.content = getContent().substring(0, getContent().length() - 1);
    }

    public String getContent() {
        return content;
    }

    public int getMargin() {
        return margin;
    }

    public String getLabel() {
        return label;
    }

    public int getFontsize() {
        return fontsize;
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
        g2.setFont(new Font(null, Font.BOLD, 25));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString(getLabel(), getX(), getY() - 30); //+5 to the font to account for the bold
        g2.setFont(new Font(null, Font.BOLD, getFontsize()));
        g2.drawString(getContent(), getX() + getMargin(), getY() + ((getHeight()/2) - (getFontsize()/2)));

    }

    public void onClick() {
        Game.getInstance().setState(GameState.TYPING);
    }

}
