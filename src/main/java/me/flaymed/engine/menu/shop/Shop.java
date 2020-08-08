package me.flaymed.engine.menu.shop;

import me.flaymed.engine.menu.Button;
import me.flaymed.engine.menu.Menu;

import java.awt.*;
import java.util.LinkedList;

public class Shop extends Menu {

    private NextButton nextButton;
    private PreviousButton previousButton;
    private int buttonPerPage = 5;
    private int MAX_PAGES;

    //Default to page 1
    private int pageCount;

    private int buttonCount;

    public Shop(int x, int y, int width, int height, int keycode, Color color, Class<? extends Button>... buttons) {
        super(x, y, width, height, keycode, color, buttons);

        MAX_PAGES = (int) Math.ceil(getButtons().size()/buttonPerPage);

        //Subtract 120 to get a 20px gap between the button and the edge of the shop
        this.nextButton = new NextButton(this.getWidth() - 170, this.getHeight() - 95, 150, 75, this);
        this.previousButton = new PreviousButton(this.getX() + 20, this.getY() - 95, 150, 75, this);

        //Buttons start 200 pixels in, 300 pixels down with a 20 pixel gap between buttons.
        listButtonsVertically(200, 300, 20);
    }

    @Override
    public void toggledOn() {
        this.nextButton.setShown(true);
        this.previousButton.setShown(true);

        pageCount = 1;
        buttonCount = 0;

        LinkedList<Button> buttons = getButtons();

        for (Button button : buttons) {
            buttonCount++;

            if (buttonCount <= (pageCount * buttonPerPage) && buttonCount >= ((pageCount - 1) * buttonPerPage))
                button.setShown(true);
            else
                button.setShown(false);

        }
    }

    @Override
    public void toggledOff() {
        this.nextButton.setShown(false);
        this.previousButton.setShown(false);
        for (Button button : getButtons()) {
            button.setShown(false);
        }
    }


    public void nextPage() {
        if (this.pageCount == this.MAX_PAGES)
            return;
        else
            this.pageCount++;
    }

    public void previousPage() {
        if (this.pageCount <= 1)
            this.pageCount = 0;
        else
            this.pageCount--;
    }

}
