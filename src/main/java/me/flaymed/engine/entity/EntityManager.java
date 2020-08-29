package me.flaymed.engine.entity;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private static EntityManager INSTANCE;
    private List<LivingEntity> entities;

    public EntityManager() {
        INSTANCE = this;

        this.entities = new ArrayList<>();
    }

    public List<LivingEntity> getEntities() {
        return entities;
    }

    public void registerEntity(LivingEntity entity) {
        getEntities().add(entity);
    }

    public void unregisterEntity(LivingEntity entity) {
        getEntities().remove(entity);
    }

    public static EntityManager getInstance() {
        return INSTANCE;
    }

}
