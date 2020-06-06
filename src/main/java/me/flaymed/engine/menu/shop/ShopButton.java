package me.flaymed.engine.menu.shop;

import me.flaymed.engine.Game;
import me.flaymed.engine.menu.Button;
import java.util.List;

public class ShopButton extends Button {

    private ShopItem item;

    public ShopButton(int x, int y, int width, int height, ShopItem item, String itemName) {
        super(x, y, width, height, itemName);

        this.item = item;
    }

    @Override
    public void onClick() {
        getItem().toggleShown();

        List<Button> buttons = Game.getButtons();

        for (Button button : buttons) {
            if (button instanceof ShopButton)
                ((ShopButton) button).getItem().setShown(false);
        }

    }

    public ShopItem getItem() {
        return item;
    }
}
