package org.thanks.thanksgiving2;

import net.fabricmc.api.ModInitializer;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.SpawnGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//import org.thanks.thanksgiving2.entity.Turkey;
import org.thanks.thanksgiving2.item.ModItems;

public class Thanksgiving2 implements ModInitializer {

//    public static final EntityType<Turkey> TURKEY = Registry.register(
//            Registries.ENTITY_TYPE,
//            Identifier.of("thanksgiving2", "turkey"),
//            EntityType.Builder.create(Turkey::new, SpawnGroup.CREATURE).dimensions(0.75f,0.75f).build("turkey"));


    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}
