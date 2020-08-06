package me.flaymed.engine.loading;

import me.flaymed.engine.Game;
import me.flaymed.engine.GameState;
import me.flaymed.engine.event.EventManager;
import me.flaymed.engine.event.loading.LoadingFinishEvent;
import me.flaymed.engine.event.loading.LoadingScreenCreateEvent;
import me.flaymed.engine.handler.GameObject;
import me.flaymed.engine.handler.ObjectID;
import me.flaymed.engine.tasks.Task;
import java.util.List;
import java.awt.Graphics;
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

        EventManager.callEvent(new LoadingFinishEvent(this));
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
