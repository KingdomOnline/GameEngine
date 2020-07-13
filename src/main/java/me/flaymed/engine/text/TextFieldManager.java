package me.flaymed.engine.text;

import java.util.ArrayList;
import java.util.List;

public class TextFieldManager {

    private static TextFieldManager instance;
    private List<TextField> textFields;

    public TextFieldManager() {
        instance = this;
        this.textFields = new ArrayList<>();
    }

    public void addTextField(TextField textField) {
        this.textFields.add(textField);
    }

    public List<TextField> getTextFields() {
        return textFields;
    }

    public static TextFieldManager getInstance() {
        return instance;
    }

}
