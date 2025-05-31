package org.thanks.thanksgiving2.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings ){
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("thanksgiving2", name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    //food componenets
    public static final FoodComponent UNCOOKED_STUFFING_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(3).build();
    public static final FoodComponent COOKED_STUFFING_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(6).build();
    public static final FoodComponent RAW_TURKEY_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(3).build();
    public static final FoodComponent COOKED_TURKEY_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(7).build();
    public static final FoodComponent CRANBERRY_SAUCE_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(6).build();
    public static final FoodComponent THANKSGIVING_MEAL_FOOD_COMPONENT = new FoodComponent.Builder().nutrition(16).alwaysEdible().build();

    // effect status components
    public static final ConsumableComponent POISON_FOOD_COMPONENT = ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 30*20, 0), 0.7f)).build();
    public static final ConsumableComponent HEALTH_FOOD_COMPONENT = ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 30*20, 0), 1f)).build();


//    public static final Item COOL_ITEM = register("cool_item", Item::new, new Item.Settings());
    public static final Item HERB_PLANT = register("herb_plant", Item::new, new Item.Settings());
    public static final Item UNCOOKED_STUFFING = register("uncooked_stuffing", Item::new, new Item.Settings().food(UNCOOKED_STUFFING_FOOD_COMPONENT));
    public static final Item COOKED_STUFFING = register("cooked_stuffing", Item::new, new Item.Settings().food(COOKED_STUFFING_FOOD_COMPONENT));
    public static final Item RAW_TURKEY = register("raw_turkey", Item::new, new Item.Settings().food(RAW_TURKEY_FOOD_COMPONENT,POISON_FOOD_COMPONENT));
    public static final Item COOKED_TURKEY = register("cooked_turkey", Item::new, new Item.Settings().food(COOKED_TURKEY_FOOD_COMPONENT));
    public static final Item CRANBERRY_SAUCE = register("cranberry_sauce", Item::new, new Item.Settings().food(CRANBERRY_SAUCE_FOOD_COMPONENT));
    public static final Item THANKSGIVING_MEAL = register("thanksgiving_meal", Item::new, new Item.Settings().food(THANKSGIVING_MEAL_FOOD_COMPONENT,HEALTH_FOOD_COMPONENT));

    /*###########################*/
    // Notes
    // crafting unlocks
    // fix up the datagen +- full movement to datagen?
    // make fire actually cook our turkey
    /*##################################*/

    public static void initialize(){
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> itemGroup.add(ModItems.COOL_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> itemGroup.add(ModItems.HERB_PLANT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(ModItems.UNCOOKED_STUFFING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(ModItems.COOKED_STUFFING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(ModItems.RAW_TURKEY));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(ModItems.COOKED_TURKEY));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(ModItems.CRANBERRY_SAUCE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.add(ModItems.THANKSGIVING_MEAL));
    }


}
