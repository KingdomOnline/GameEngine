package me.flaymed.engine.entity.type;

import me.flaymed.engine.entity.LivingEntity;

public interface Predator {

    Class<? extends LivingEntity> getAnimalFood();

}
