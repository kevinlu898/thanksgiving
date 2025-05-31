package org.thanks.thanksgiving2.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class Thanksgiving2DataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(Thanksgiving2AdvancementProvider::new);

        // **************** DON'T RUN DATAGEN!!!!! IT WILL DELETE OTHER FILES.
    }
}
