package cofh.thermal.foundation.data;

import cofh.thermal.lib.common.ThermalIDs;
import com.google.gson.JsonElement;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.lib.util.helpers.DatapackHelper.datapackProvider;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.lib.FeatureHelper.createOreFeature;
import static cofh.thermal.lib.common.ThermalIDs.*;

public final class TFndFeatures {

    public static JsonCodecProvider<PlacedFeature> dataGenFeatures(DataGenerator gen, ExistingFileHelper exFileHelper, RegistryOps<JsonElement> regOps) {

        return datapackProvider(ID_THERMAL, gen, exFileHelper, regOps, Registry.PLACED_FEATURE_REGISTRY, generateFeatures(regOps.registryAccess.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY)));
    }

    private static Map<ResourceLocation, PlacedFeature> generateFeatures(Registry<PlacedFeature> featureRegistry) {

        Map<ResourceLocation, PlacedFeature> featureMap = new HashMap<>();

        generateOres(featureMap);

        return featureMap;
    }

    private static void generateOres(Map<ResourceLocation, PlacedFeature> featureMap) {

        createOreFeature(featureMap, ID_APATITE_ORE, 3, -16, 96, 9);
        createOreFeature(featureMap, ID_CINNABAR_ORE, 1, -16, 48, 5);
        createOreFeature(featureMap, ID_NITER_ORE, 2, -16, 64, 7);
        createOreFeature(featureMap, ID_SULFUR_ORE, 2, -16, 32, 7);

        createOreFeature(featureMap, ID_TIN_ORE, 6, -20, 60, 9);
        createOreFeature(featureMap, ID_LEAD_ORE, 6, -60, 40, 8);
        createOreFeature(featureMap, ID_SILVER_ORE, 4, -60, 40, 8);
        createOreFeature(featureMap, ID_NICKEL_ORE, 4, -40, 120, 8);

        createOreFeature(featureMap, List.of(
                OreConfiguration.target(SAND, BLOCKS.get(ID_OIL_SAND).defaultBlockState()),
                OreConfiguration.target(RED_SAND, BLOCKS.get(ID_OIL_RED_SAND).defaultBlockState())
        ), ThermalIDs.ID_OIL_SAND, 2, 40, 80, 24);
    }

    public static final RuleTest SAND = new BlockMatchTest(Blocks.SAND);
    public static final RuleTest RED_SAND = new BlockMatchTest(Blocks.RED_SAND);

}
