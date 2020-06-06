package me.flaymed.engine.menu.shop;

import me.flaymed.engine.menu.Button;

public class NextButton extends Button {

    private Shop shop;

    public NextButton(int x, int y, int width, int height, Shop shop) {
        super(x, y, width, height, "Next");

        this.shop = shop;
    }

    @Override
    public void onClick() {
        getShop().nextPage();
    }

    public Shop getShop() {
        return shop;
    }
}
