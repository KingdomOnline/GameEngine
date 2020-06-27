package me.flaymed.engine.entity.interactables;

import me.flaymed.engine.entity.LivingEntity;
import me.flaymed.engine.entity.damage.DamageType;

public interface Damageable {

    void onDamage();

    default void setDamageCause(LivingEntity entity, DamageType damageType) {

    }

    default void getDamageCause() {

    }

}
