package me.flaymed.engine.menu.shop;

import me.flaymed.engine.menu.Button;
import me.flaymed.engine.menu.Menu;

import java.util.LinkedList;

public class Shop extends Menu {

    private NextButton nextButton;
    private PreviousButton previousButton;
    private int buttonPerPage = 5;
    private int MAX_PAGES;

    //Default to page 1
    private int pageCount;

    private int buttonCount;

    public Shop(int x, int y, int width, int height, int keycode, Class<? extends Button>... buttons) {
        super(x, y, width, height, keycode, buttons);

        MAX_PAGES = (int) Math.ceil(getButtons().size()/buttonPerPage);

        //Subtract 120 to get a 20px gap between the button and the edge of the shop
        this.nextButton = new NextButton(this.getWidth() - 170, this.getHeight() - 95, 150, 75, this);
        this.previousButton = new PreviousButton(this.getX() + 20, this.getY() - 95, 150, 75, this);

        //Buttons start 200 pixels in, 300 pixels down.
        configureButtonPosition(200, 300);
    }

    @Override
    public void toggled() {

        this.nextButton.toggleShown();
        this.previousButton.toggleShown();

        pageCount = 1;
        buttonCount = 0;

        toggleShown();

        LinkedList<Button> buttons = getButtons();

        for (Button button : buttons) {
            buttonCount++;

            if (buttonCount <= (pageCount * buttonPerPage) && buttonCount >= ((pageCount - 1) * buttonPerPage))
                button.toggleShown();

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
