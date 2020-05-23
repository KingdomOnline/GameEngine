package me.flaymed.engine.menu.shop;

import me.flaymed.engine.menu.Button;
import me.flaymed.engine.menu.Menu;

import java.util.Set;

public class Shop extends Menu {

    private int buttonPerPage = 5;
    private int MAX_PAGES;

    //Default to page 1
    private int pageCount;

    private int buttonCount;

    public Shop(int x, int y, int width, int height, int keycode, Class<? extends Button>... buttons) {
        super(x, y, width, height, keycode, buttons);

        MAX_PAGES = (int) Math.ceil(getButtons().size()/buttonPerPage);
    }

    @Override
    public void toggled() {

        pageCount = 1;
        buttonCount = 0;

        toggleShown();

        Set<Button> buttons = getButtons();

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
