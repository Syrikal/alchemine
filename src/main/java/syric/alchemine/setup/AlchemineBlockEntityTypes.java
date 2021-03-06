package syric.alchemine.setup;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import syric.alchemine.Alchemine;
import syric.alchemine.brewing.cauldron.AlchemicalCauldronBlockEntity;
import syric.alchemine.brewing.laboratory.*;
import syric.alchemine.outputs.bouncy.blocks.ShellSlimeBlockEntity;
import syric.alchemine.outputs.general.sludges.StygianSludgeBlockEntity;

public final class AlchemineBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Alchemine.MODID);

    //Cauldron
    public static final RegistryObject<BlockEntityType<AlchemicalCauldronBlockEntity>> ALCHEMICAL_CAULDRON = BLOCK_ENTITIES.register("alchemical_cauldron", () -> BlockEntityType.Builder.of(AlchemicalCauldronBlockEntity::new, AlchemineBlocks.ALCHEMICAL_CAULDRON.get()).build(null));

    //Lab Blocks
    public static final RegistryObject<BlockEntityType<AlchemicalGrinderBlockEntity>> GRINDER = BLOCK_ENTITIES.register("alchemical_grinder", () -> BlockEntityType.Builder.of(AlchemicalGrinderBlockEntity::new, AlchemineBlocks.ALCHEMICAL_GRINDER.get()).build(null));
    public static final RegistryObject<BlockEntityType<AlchemicalCrucibleBlockEntity>> CRUCIBLE = BLOCK_ENTITIES.register("alchemical_crucible", () -> BlockEntityType.Builder.of(AlchemicalCrucibleBlockEntity::new, AlchemineBlocks.ALCHEMICAL_CRUCIBLE.get()).build(null));
    public static final RegistryObject<BlockEntityType<AlchemicalAlembicBlockEntity>> ALEMBIC = BLOCK_ENTITIES.register("alchemical_alembic", () -> BlockEntityType.Builder.of(AlchemicalAlembicBlockEntity::new, AlchemineBlocks.ALCHEMICAL_ALEMBIC.get()).build(null));

    //Utility
    public static final RegistryObject<BlockEntityType<ShellSlimeBlockEntity>> SHELL_SLIME = BLOCK_ENTITIES.register("shell_slime", () -> BlockEntityType.Builder.of(ShellSlimeBlockEntity::new, AlchemineBlocks.SHELL_SLIME.get()).build(null));
    public static final RegistryObject<BlockEntityType<StygianSludgeBlockEntity>> STYGIAN = BLOCK_ENTITIES.register("stygian_sludge", () -> BlockEntityType.Builder.of(StygianSludgeBlockEntity::new, AlchemineBlocks.STYGIAN_SLUDGE.get()).build(null));

    static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }

}