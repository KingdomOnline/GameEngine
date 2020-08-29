package me.flaymed.engine.event.entity;

import me.flaymed.engine.entity.LivingEntity;
import me.flaymed.engine.event.Cancellable;
import me.flaymed.engine.event.Event;

public class EntitySpawnEvent extends Event implements Cancellable {

    private boolean cancelled;
    private LivingEntity entity;

    public EntitySpawnEvent(LivingEntity livingEntity) {
        this.cancelled = false;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean var) {
        this.cancelled = var;
    }
}
