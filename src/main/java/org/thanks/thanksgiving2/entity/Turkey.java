package org.thanks.thanksgiving2.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class Turkey extends PathAwareEntity {
    public Turkey(EntityType<? extends PathAwareEntity> entityType, World world){
        super(entityType,world);
    }
}
