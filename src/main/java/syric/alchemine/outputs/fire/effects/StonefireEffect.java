package syric.alchemine.outputs.fire.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import syric.alchemine.outputs.fire.blocks.AbstractAlchemicalFireBlock;
import syric.alchemine.outputs.general.alchemicaleffects.AlchemicalEffect;
import syric.alchemine.outputs.general.alchemicaleffects.PlacementSet;
import syric.alchemine.outputs.general.alchemicaleffects.placementpatterns.PlacementPattern;
import syric.alchemine.outputs.general.alchemicaleffects.placementpatterns.SpherePattern;
import syric.alchemine.setup.AlchemineBlocks;

public class StonefireEffect implements AlchemicalEffect{

    @Override
    public void detonate(UseOnContext context) {
        BlockPos pos = AlchemicalEffect.getOrigin(context);
        Level level = context.getLevel();

        PlacementPattern pattern = new SpherePattern(pos, 3F);
        new PlacementSet(level).addPattern(pattern).cull(PlacementSet.AIR_ONLY).cull(PlacementSet.randomFilter(0.4F)).placeContextualFire((AbstractAlchemicalFireBlock) AlchemineBlocks.STONE_FIRE.get());


    }

    @Override
    public String toString() { return "Stonefire"; }

}
