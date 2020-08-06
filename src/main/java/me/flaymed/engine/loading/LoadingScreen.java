package me.flaymed.engine.loading;

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
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
