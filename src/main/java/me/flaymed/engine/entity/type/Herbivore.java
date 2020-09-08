package me.flaymed.engine.entity.type;

import me.flaymed.engine.entity.environment.Plant;

public interface Herbivore {

    Class<? extends Plant> getPlantFood();

}
