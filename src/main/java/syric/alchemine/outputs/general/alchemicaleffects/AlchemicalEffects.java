package syric.alchemine.outputs.general.alchemicaleffects;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;
import syric.alchemine.Alchemine;
import syric.alchemine.outputs.bouncy.effects.CrashPadEffect;
import syric.alchemine.outputs.bouncy.effects.InstantShelterEffect;
import syric.alchemine.outputs.fire.effects.*;
import syric.alchemine.outputs.general.alchemicaleffects.testeffects.StoneBlobEffect;
import syric.alchemine.outputs.general.alchemicaleffects.testeffects.StoneSphereEffect;
import syric.alchemine.outputs.slippery.effects.OilSlickEffect;
import syric.alchemine.outputs.slippery.effects.WallSlideEffect;
import syric.alchemine.outputs.sticky.effects.FoamsnareEffect;
import syric.alchemine.outputs.sticky.effects.GlueStickEffect;
import syric.alchemine.outputs.sticky.effects.TarStickEffect;
import syric.alchemine.outputs.sticky.effects.WebsnareEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AlchemicalEffects {


    private static boolean isInitialized = false;

    public static final DeferredRegister<AlchemicalEffect> ALCHEMICAL_EFFECTS = DeferredRegister.create(new ResourceLocation(Alchemine.MODID, "alchemical_effects"), Alchemine.MODID);

    public static final List<AlchemicalEffect> EFFECT_LIST = new ArrayList<>();


    //Bouncy
    public static final RegistryObject<AlchemicalEffect> CRASH_PAD = registerEffect("crash_pad_effect",
            CrashPadEffect::new);
    public static final RegistryObject<AlchemicalEffect> INSTANT_SHELTER = registerEffect("instant_shelter_effect",
            InstantShelterEffect::new);

    //Sticky
    public static final RegistryObject<AlchemicalEffect> FOAMSNARE = registerEffect("foamsnare_effect",
            FoamsnareEffect::new);
    public static final RegistryObject<AlchemicalEffect> WEBSNARE = registerEffect("websnare_effect",
            WebsnareEffect::new);
    public static final RegistryObject<AlchemicalEffect> TAR_STICK = registerEffect("tar_stick_effect",
            TarStickEffect::new);
    public static final RegistryObject<AlchemicalEffect> GLUE_STICK = registerEffect("glue_stick_effect",
            GlueStickEffect::new);

    //Slippery
    public static final RegistryObject<AlchemicalEffect> OIL_SLICK = registerEffect("oil_slick_effect",
            OilSlickEffect::new);
    public static final RegistryObject<AlchemicalEffect> WALL_SLIDE = registerEffect("wall_slide_effect",
            WallSlideEffect::new);

    //Fire
    public static final RegistryObject<AlchemicalEffect> FIREBLOSSOM = registerEffect("fireblossom_effect",
            FireblossomEffect::new);
    public static final RegistryObject<AlchemicalEffect> FLASHFIRE = registerEffect("flashfire_effect",
            FlashfireEffect::new);
    public static final RegistryObject<AlchemicalEffect> STONEFIRE = registerEffect("stonefire_effect",
            StonefireEffect::new);
    public static final RegistryObject<AlchemicalEffect> FELLFIRE = registerEffect("fellfire_effect",
            FellfireEffect::new);
    public static final RegistryObject<AlchemicalEffect> SUNFIRE = registerEffect("sunfire_effect",
            SunfireEffect::new);
    public static final RegistryObject<AlchemicalEffect> WARDINGFIRE = registerEffect("warding_fire_effect",
            WardingFireEffect::new);
    public static final RegistryObject<AlchemicalEffect> MAGMA_VEIN = registerEffect("magma_vein_effect",
            MagmaVeinEffect::new);
    public static final RegistryObject<AlchemicalEffect> SMOKE_CLOUD = registerEffect("smoke_cloud_effect",
            SmokeCloudEffect::new);
    public static final RegistryObject<AlchemicalEffect> ASH_CLOUD = registerEffect("ash_cloud_effect",
            AshCloudEffect::new);
    public static final RegistryObject<AlchemicalEffect> INCENDIARY_CLOUD = registerEffect("incendiary_cloud_effect",
            IncendiaryCloudEffect::new);


    //Misc
    public static final RegistryObject<AlchemicalEffect> STONE_BLOB = registerEffect("stone_blob_effect",
            StoneBlobEffect::new);
    public static final RegistryObject<AlchemicalEffect> STONE_SPHERE = registerEffect("stone_sphere_effect",
            StoneSphereEffect::new);



    public static void register(final IEventBus modEventBus) {
        ALCHEMICAL_EFFECTS.makeRegistry(RegistryBuilder::new);
        ALCHEMICAL_EFFECTS.register(modEventBus);
        LogUtils.getLogger().info("Effects register created");
    }

    private static <T extends AlchemicalEffect> RegistryObject<T> registerEffect(String name, Supplier<T> effect) {
        RegistryObject<T> ret = ALCHEMICAL_EFFECTS.register(name, effect);
//        LogUtils.getLogger().info("Registered " + name);
        return ret;
    }

    public static void fillList() {
        if (isInitialized) {
            throw new IllegalStateException("Ingredients already initialized");
        }
        for (RegistryObject<AlchemicalEffect> effect : ALCHEMICAL_EFFECTS.getEntries() ) {
            EFFECT_LIST.add(effect.get());
//            LogUtils.getLogger().info("Adding " + effect.get().toString() + " to effects list");
        }
        isInitialized = true;
    }


}
