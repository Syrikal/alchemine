package syric.alchemine.setup;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import syric.alchemine.Alchemine;
import syric.alchemine.outputs.items.FullFlaskItem;

public class AlchemineItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Alchemine.MODID);

    //TOOLS
    public static final RegistryObject<Item> ALCHEMICAL_FLASK = ITEMS.register("alchemical_flask",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ALCHEMICAL_FLASK_FULL = ITEMS.register("alchemical_flask_full",
            () -> new FullFlaskItem(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> CAULDRON_DEBUG_STICK = ITEMS.register("debug_stick",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> CAULDRON_EMPTY_STICK = ITEMS.register("empty_stick",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));



    //INGREDIENTS (58 Items)
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ASH = ITEMS.register("ash",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> POTASH = ITEMS.register("potash",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> CHALK = ITEMS.register("chalk",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> PURE_SALT = ITEMS.register("pure_salt",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> PURIFIED_CHARCOAL = ITEMS.register("purified_charcoal",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SAL_ALCHIMIAE = ITEMS.register("sal_alchimiae",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> NIGREDO = ITEMS.register("nigredo",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ALBEDO = ITEMS.register("albedo",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> RUBEDO = ITEMS.register("rubedo",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> CITRINITAS = ITEMS.register("citrinitas",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ALKAHEST = ITEMS.register("alkahest",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> STONE_DUST = ITEMS.register("stone_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> DEEPSLATE_DUST = ITEMS.register("deepslate_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> GRANITE_DUST = ITEMS.register("granite_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ANDESITE_DUST = ITEMS.register("andesite_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> OBSIDIAN_DUST = ITEMS.register("obsidian_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ULTRAMARINE = ITEMS.register("ultramarine",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> GROUND_NETHER_STAR = ITEMS.register("ground_nether_star",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> FISH_OIL = ITEMS.register("fish_oil",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> REFINED_OIL = ITEMS.register("refined_oil",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SLIME_RESIN = ITEMS.register("slime_resin",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SLIME_OIL = ITEMS.register("slime_oil",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> GUM_ARABIC = ITEMS.register("gum_arabic",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> AZALEA_PETALS = ITEMS.register("azalea_petals",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> LUMINOUS_SPORES = ITEMS.register("luminous_spores",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> FROGLIGHT_GEL = ITEMS.register("froglight_gel",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> OAK_HEARTWOOD = ITEMS.register("oak_heartwood",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> ANTIMONY = ITEMS.register("antimony",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> NITRE = ITEMS.register("nitre",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> PHOSPHORUS = ITEMS.register("phosphorus",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> BITUMEN = ITEMS.register("bitumen",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> TAR = ITEMS.register("tar",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> BRASS_DUST = ITEMS.register("brass_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SILVER_DUST = ITEMS.register("silver_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> LEAD = ITEMS.register("lead",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> PURIFIED_GOLD = ITEMS.register("purified_gold",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> FULMINATING_GOLD = ITEMS.register("fulminating_gold",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> FULMINATING_SILVER = ITEMS.register("fulminating_silver",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> QUICKLIME = ITEMS.register("quicklime",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> QUICKSILVER = ITEMS.register("quicksilver",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> CINNABAR = ITEMS.register("cinnabar",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> REALGAR = ITEMS.register("realgar",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> PHLOGISTON = ITEMS.register("phlogiston",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SALAMANDER_OIL = ITEMS.register("salamander_oil",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> INFERNO_POWDER = ITEMS.register("inferno_powder",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SPIRIT_OF_WINTER = ITEMS.register("spirit_of_winter",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> FROSTFLAME_DUST = ITEMS.register("frostflame_dust",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> VITRIOL = ITEMS.register("vitriol",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> SPIRIT_OF_SALT = ITEMS.register("spirit_of_salt",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> AQUA_FORTIS = ITEMS.register("aqua_fortis",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));

    public static final RegistryObject<Item> SOUL_ASH = ITEMS.register("soul_ash",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> WITHERBONE = ITEMS.register("witherbone",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> ENDER_SALT = ITEMS.register("ender_salt",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));
    public static final RegistryObject<Item> END_BLOSSOM = ITEMS.register("end_blossom",
            () -> new Item(new Item.Properties().tab(AlchemineCreativeTabs.ALCHEMY)));









    //OUTPUTS



    static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
