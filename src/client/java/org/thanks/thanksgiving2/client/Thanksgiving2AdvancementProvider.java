package org.thanks.thanksgiving2.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.RecipeCraftedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.thanks.thanksgiving2.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class Thanksgiving2AdvancementProvider extends FabricAdvancementProvider {
    protected Thanksgiving2AdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(output, registryLookup);
    }
    // ***************** NOTE MILDLY OUTDATED
    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer){
//        AdvancementEntry getDirt = Advancement.Builder.create()
//                .display(
//                        Items.DIRT, // The display icon
//                        Text.literal("Your First Dirt Block"), // The title
//                        Text.literal("Now make a house from it"), // The description
//                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
//                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
//                        true, // Show the toast when completing it
//                        true, // Announce it to chat
//                        false // Hide it in the advancement tab until it's achieved
//                )
//                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
//                .criterion("got_dirt", InventoryChangedCriterion.Conditions.items(Items.DIRT))
//                // Give the advancement an id
//                .build(consumer, "thanksgiving2:get_dirt");
        AdvancementEntry thanksgiving_ad = Advancement.Builder.create()
                .display(
                    ModItems.HERB_PLANT,
                    Text.literal("Thanksgiving!"),
                    Text.literal("Obtain an herb plant by breaking grass"),
                    Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                    AdvancementFrame.TASK,
                    true,
                    true,
                    false
                )
                .criterion("thanksgiving_ad",InventoryChangedCriterion.Conditions.items(ModItems.HERB_PLANT))
                .build(consumer,"thanksgiving2:thanksgiving_ad");
        AdvancementEntry getTurkey_ad = Advancement.Builder.create()
                .parent(thanksgiving_ad)
                .display(
                        ModItems.RAW_TURKEY,
                        Text.literal("Turkey Trouble"),
                        Text.literal("Obtain raw turkey, a rare drop from chickens"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("get_turkey_ad",InventoryChangedCriterion.Conditions.items(ModItems.RAW_TURKEY))
                .build(consumer, "thanksgiving2:get_turkey_ad");
        AdvancementEntry cranberrySauce_ad = Advancement.Builder.create()
                .parent(thanksgiving_ad)
                .display(
                        ModItems.CRANBERRY_SAUCE,
                        Text.literal("Sweet and Sour"),
                        Text.literal("Make cranberry sauce"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                ).criterion("cranberry_sauce_ad", InventoryChangedCriterion.Conditions.items(ModItems.CRANBERRY_SAUCE))
                .build(consumer,"thanksgiving2:cranberry_sauce_ad");
        AdvancementEntry cookedStuffing_ad = Advancement.Builder.create()
                .parent(thanksgiving_ad)
                .display(
                        ModItems.COOKED_STUFFING,
                        Text.literal("Stuffed to the Brim"),
                        Text.literal("Cook a bowl of Thanksgiving stuffing"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("cooked_stuffing_ad",InventoryChangedCriterion.Conditions.items(ModItems.COOKED_STUFFING))
            .build(consumer,"thanksgiving2:cooked_stuffing_ad");
        AdvancementEntry thanksgiving_meal_ad = Advancement.Builder.create()
                .parent(cookedStuffing_ad)
                .display(
                        ModItems.THANKSGIVING_MEAL,
                        Text.literal("A Filling Meal"),
                        Text.literal("Cook up a delicious Thanksgiving meal!"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                ).criterion("thanksgiving_meal_ad",InventoryChangedCriterion.Conditions.items(ModItems.THANKSGIVING_MEAL))
                .build(consumer,"thanksgiving2:thanksgiving_meal_ad");


    }
}
