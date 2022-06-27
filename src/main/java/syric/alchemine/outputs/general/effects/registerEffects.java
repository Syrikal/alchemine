package syric.alchemine.outputs.general.effects;

import org.checkerframework.checker.units.qual.A;
import syric.alchemine.outputs.bouncy.effects.CrashPadEffect;
import syric.alchemine.outputs.bouncy.effects.InstantShelterEffect;
import syric.alchemine.outputs.sticky.effects.FoamsnareEffect;
import syric.alchemine.outputs.sticky.effects.GlueStickEffect;
import syric.alchemine.outputs.sticky.effects.TarStickEffect;
import syric.alchemine.outputs.sticky.effects.WebsnareEffect;

public class registerEffects {

    public static final AlchemicalEffect CRASH_PAD_EFFECT = new CrashPadEffect();
    public static final AlchemicalEffect INSTANT_SHELTER_EFFECT = new InstantShelterEffect();
    public static final AlchemicalEffect FOAMSNARE_EFFECT = new FoamsnareEffect();
    public static final AlchemicalEffect WEBSNARE_EFFECT = new WebsnareEffect();
    public static final AlchemicalEffect TAR_STICK_EFFECT = new TarStickEffect();
    public static final AlchemicalEffect GLUE_STICK_EFFECT = new GlueStickEffect();
    public static final AlchemicalEffect STONE_BLOB_EFFECT = new StoneBlobEffect();

}