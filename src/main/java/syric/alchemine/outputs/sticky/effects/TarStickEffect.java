package syric.alchemine.outputs.sticky.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import syric.alchemine.outputs.general.alchemicaleffects.AlchemicalEffect;
import syric.alchemine.outputs.general.alchemicaleffects.PlacementSet;
import syric.alchemine.outputs.general.alchemicaleffects.placementpatterns.FlatDiscPattern;
import syric.alchemine.outputs.general.alchemicaleffects.placementpatterns.PlacementPattern;
import syric.alchemine.setup.AlchemineBlocks;

public class TarStickEffect implements AlchemicalEffect {

    @Override
    public void detonate(UseOnContext context) {
        BlockPos pos = AlchemicalEffect.getOrigin(context);
        Level level = context.getLevel();

        PlacementPattern place = new FlatDiscPattern(pos, 2.5F);
        new PlacementSet(level).addPattern(place).cull(PlacementSet.BLOCK_REPLACEABLE).placeImmediate(AlchemineBlocks.TAR_STICK, true);

    }

    @Override
    public String toString() { return "Tar Stick"; }

}
