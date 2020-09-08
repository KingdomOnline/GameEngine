package me.flaymed.engine.entity.environment;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentManager {

    private static EnvironmentManager INSTANCE;
    private List<Lake> lakes;
    private List<Plant> plants;

    public EnvironmentManager() {
        INSTANCE = this;

        this.lakes = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    public void addLake(Lake lake) {
        this.lakes.add(lake);
    }

    public void removeLake(Lake lake) {
        this.lakes.remove(lake);
    }

    public List<Lake> getLakes() {
        return lakes;
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void removePlants(Plant plant) {
        this.plants.remove(plant);
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public static EnvironmentManager getINSTANCE() {
        return INSTANCE;
    }
}
