package me.flaymed.engine.entity;

public class EntityManager {

    private static EntityManager INSTANCE;

    public EntityManager() {
        INSTANCE = this;
    }

    public static EntityManager getInstance() {
        return INSTANCE;
    }

}
