package me.flaymed.engine.loading;

import me.flaymed.engine.Game;
import me.flaymed.engine.GameState;
import me.flaymed.engine.event.EventManager;
import me.flaymed.engine.event.loading.LoadingFinishEvent;
import me.flaymed.engine.event.loading.LoadingScreenCreateEvent;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;
import me.flaymed.engine.tasks.Task;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class LoadingScreen extends GameObject {

    private List<Task> tasks;
    private int completedTasks;

    public LoadingScreen() {
        super(0, 0, ObjectID.Menu, true);

        if(!EventManager.callEvent(new LoadingScreenCreateEvent(this))) {
            try {
                this.finalize();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } else {
            Game.getMainHandler().addObject(this);
            Game.getInstance().setState(GameState.LOADING);
        }

        this.completedTasks = 0;
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        getTasks().add(task);
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getTaskCount() {
        return getTasks().size();
    }

    public void executeTasks() {
        for (Task task: getTasks()) {
            task.execute();
            completedTasks++;
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventManager.callEvent(new LoadingFinishEvent(this));
        Game.getMainHandler().removeObject(this);
        try {
            this.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        int height = Game.getInstance().getWindowHeight();
        int width = Game.getInstance().getWindowWidth();
        double percentDone = (double) getCompletedTasks()/getTaskCount();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        //loading bar
        g.setColor(Color.WHITE);
        g.fillRect(0, height - 50, width, height);
        g.setColor(Color.RED);
        g.fillRect(0, height - 50, (int) (percentDone * width), height);

    }
}
