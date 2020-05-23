package me.flaymed.engine.menu.shop;

import me.flaymed.engine.menu.Button;

public class PreviousButton extends Button {

    private Shop shop;

    public PreviousButton(int x, int y, int width, int height, Shop shop) {
        super(x, y, width, height);

        this.shop = shop;

    }

    @Override
    public void onClick() {
        getShop().previousPage();
    }

    public Shop getShop() {
        return shop;
    }
}
