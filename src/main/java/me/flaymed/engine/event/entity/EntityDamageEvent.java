package me.flaymed.engine.event.entity;

import me.flaymed.engine.entity.LivingEntity;
import me.flaymed.engine.entity.damage.DamageType;
import me.flaymed.engine.event.Cancellable;
import me.flaymed.engine.event.Event;

public class EntityDamageEvent extends Event implements Cancellable {

    private boolean cancelled;
    private LivingEntity entity;
    private double damageAmount;
    private DamageType damageCause;

    public EntityDamageEvent(LivingEntity entity, double amount, DamageType damageCause) {
        this.entity = entity;
        this.damageAmount = amount;
        this.damageCause = damageCause;
        this.cancelled = false;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public double getDamageAmount() {
        return damageAmount;
    }

    public DamageType getDamageCause() {
        return damageCause;
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
