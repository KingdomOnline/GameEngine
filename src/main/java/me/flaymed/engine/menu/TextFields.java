package me.flaymed.engine.menu;

import me.flaymed.engine.text.TextField;

import java.util.List;

//For Menus or Buttons you want to add TextFields to.
public interface TextFields {

    List<TextField> getTextFields();

    default void arrangeTextFieldsVertically() {
        List<TextField> fields = getTextFields();
        for (TextField field : fields) {

        }
    }

}
