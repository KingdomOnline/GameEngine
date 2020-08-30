package me.flaymed.engine.entity.interactables;

import me.flaymed.engine.entity.LivingEntity;
import me.flaymed.engine.entity.damage.DamageType;

public interface CanAttack {

    double getDamage();

    default void hitLivingEntity(LivingEntity entity) {
        entity.damage(getDamage(), DamageType.ATTACK);
    }

}
