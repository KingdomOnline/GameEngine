package me.flaymed.engine.loading;

import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;
import me.flaymed.engine.tasks.Task;
import java.util.List;
import java.awt.Graphics;
import java.util.ArrayList;

public class LoadingScreen extends GameObject {

    private List<Task> tasks;

    public LoadingScreen() {
        super(0, 0, ObjectID.Menu, true);

        this.tasks = new ArrayList<>();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
