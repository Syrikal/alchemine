package syric.alchemine.outputs.bouncy.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.extensions.IForgeBlock;
import org.jetbrains.annotations.Nullable;
import syric.alchemine.brewing.cauldron.AlchemicalCauldronBlockEntity;
import syric.alchemine.outputs.general.blocks.PossiblyPermanentBlock;
import syric.alchemine.setup.AlchemineBlockEntityTypes;
import syric.alchemine.setup.AlchemineBlocks;
import net.minecraft.world.item.Items;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static syric.alchemine.util.ChatPrint.chatPrint;

public class ShellSlimeBlock extends HalfTransparentBlock implements IForgeBlock, EntityBlock, PossiblyPermanentBlock {
    public static final IntegerProperty HEALTH = IntegerProperty.create("health", 1, 4);
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    protected static final VoxelShape ANVILSHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);


    public ShellSlimeBlock(BlockBehaviour.Properties properties) {
        super (properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HEALTH, 4).setValue(PossiblyPermanentBlock.PERMANENT, false));
    }

    public void destroy(LevelAccessor levelAccessor, BlockPos pos, BlockState state) {
        damage(levelAccessor, pos, state, 2);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (player.isCreative()) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
//            level.destroyBlock(pos, true);
        }
        return true;
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        damage(level, pos, state, 2);
        this.wasExploded(level, pos, explosion);
    }

    //Deals half the damage directly and attempts to dissipate the rest
    private void damage(LevelAccessor level, BlockPos pos, BlockState state, int damage) {
        if (state.getBlock() != this) {
            return;
        }
        if (level.isClientSide()) {
            return;
        }

        int rawDamage = damage;
        int directDamage = 0;
        int dissipateDamage = 0;
        int failedDissipate = 0;


        while (rawDamage > 0) {
            if (rawDamage % 2 == 1) {
                directDamage++;
            } else {
                dissipateDamage++;
            }
            rawDamage --;
        }

        if (level instanceof Level lv) {
//            chatPrint("Dealing " + directDamage + " direct and " + dissipateDamage + " dissipated damage", lv);
        }



        if (dissipateDamage > 0) {
            failedDissipate = distributeDamage(level, pos, state, dissipateDamage);
        }
        state = directDamage(level, pos, state, directDamage);
        if (failedDissipate > 0) {
            directDamage(level, pos, state, failedDissipate);
        }
    }

    //Reduces the blockstate by the specified amount and returns the new blockstate
    private BlockState directDamage(LevelAccessor level, BlockPos pos, BlockState state, int damage) {
        if (level instanceof Level lv) {
//            chatPrint("dealing " + damage + " direct damage to a shellslime block", lv);
        }
        if (level.isClientSide()) {
            return state;
        }
        if (state.getBlock().equals(this)) {
            if (state.getValue(HEALTH) <= damage) {
                level.destroyBlock(pos, false);
                return Blocks.AIR.defaultBlockState();
            } else {
                int newHealth = state.getValue(HEALTH) - damage;
                BlockState newState = state.setValue(HEALTH, newHealth);
                level.destroyBlock(pos, false);
                level.setBlock(pos, newState, 2);
                return newState;
            }
        }
        return state;
    }

    //Deals a certain amount of damage to other blocks. Returns the number of damage points it failed to dissipate.
    private int distributeDamage(LevelAccessor level, BlockPos pos, BlockState state, int damage) {
        if (level instanceof Level lv) {
//            chatPrint("dealing " + damage + " distributed damage to surrounding blocks", lv);
        }
        int damageToDistribute = damage;
        int damageSuccessfullyDistributed = 0;

        for (int i = 0; i < damageToDistribute; i++) {
            AtomicInteger blocksUsed = new AtomicInteger();
            BlockPos.betweenClosedStream(new AABB(pos).inflate(1))
                    .filter(c -> level.getBlockState(c).getBlock().equals(AlchemineBlocks.SHELL_SLIME.get()))
                    .filter(c -> c.above().equals(pos) || c.below().equals(pos) || c.east().equals(pos) || c.west().equals(pos) || c.north().equals(pos) || c.south().equals(pos))
                    .forEach(c -> {
                        directDamage(level, c, level.getBlockState(c), 1);
                        blocksUsed.getAndIncrement();
                    });
            if (blocksUsed.get() >= 4) {
                damageSuccessfullyDistributed++;
            }
        }
        if (level instanceof Level lv) {
//            chatPrint("Failed to distribute " + (damageToDistribute - damageSuccessfullyDistributed) + " damage", lv);
        }

        return damageToDistribute - damageSuccessfullyDistributed;
    }

    public void onProjectileHit(Level level, BlockState state, BlockHitResult result, Projectile projectile) {
        EntityType<?> type = projectile.getType();
        boolean kill = false;
        if (type == EntityType.ARROW) {
            damage(level, result.getBlockPos(), state, 1);
            kill = true;
        } else if (type == EntityType.FIREBALL) {
            damage(level, result.getBlockPos(), state, 6);
            kill = true;
        } else if (type == EntityType.WITHER_SKULL) {
            directDamage(level, result.getBlockPos(), state, 2);
            damage(level, result.getBlockPos(), state, 4);
            kill = true;
        } else if (type == EntityType.DRAGON_FIREBALL) {
            damage(level, result.getBlockPos(), state, 8);
            kill = true;
        } else if (projectile instanceof ThrownTrident trident) {
            double speed = trident.getDeltaMovement().length();
            if (speed > 0.5) {
//                chatPrint("Speed of trident: " + speed, level);
                directDamage(level, result.getBlockPos(), state, 4);
            }
        }
        if (kill) {
            projectile.kill();
        }
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        final var blockentity = (ShellSlimeBlockEntity) level.getBlockEntity(pos);

        if (entity instanceof Monster && blockentity != null) {
            blockentity.increaseBreakTime();
            int timeToBreak = blockentity.getTimeToBreak();
            int lastBreakProgress = blockentity.getLastBreakProgress();
            int breakTime = blockentity.getBreakTime();
            int i = (int)((float)breakTime / (float)timeToBreak * 10.0F);
            if (i != lastBreakProgress) {
                entity.level.destroyBlockProgress(entity.getId(), pos, i);
                blockentity.setLastBreakProgress(i);
            }

            if (breakTime == timeToBreak) {
                damage(level, pos, state, 2);
                blockentity.resetBreakTime();
            }


            if (entity instanceof Creeper creeper) {
                creeper.ignite();
            }

        }

        else if (entity instanceof FallingBlockEntity falling) {
            boolean isAnvil = falling.getBlockState().is(BlockTags.ANVIL);
            if (isAnvil) {
                directDamage(level, pos, state, 4);
            }
        }

        super.entityInside(state, level, pos, entity);
    }


    //Stuff relating to automatic destruction
    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state2, boolean bool) {
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 1200);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        super.tick(state, level, pos, source);
        if (!state.getValue(PERMANENT)) {
            level.destroyBlock(pos, false);
        }
//        chatPrint("Decay destroyed a Shellslime block", level);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return true;
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HEALTH, PossiblyPermanentBlock.PERMANENT);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext entityCollisionContext) {
            if (entityCollisionContext.getEntity() instanceof Monster) {
                return SHAPE;
            } else if (entityCollisionContext.getEntity() instanceof FallingBlockEntity fall) {
                if (fall.getBlockState().is(BlockTags.ANVIL)) {
                    float fallDist = (fall.getStartPos().getY() - pos.getY());
                    fallDist = Math.min(fallDist, 16);
                    int damage = (int) (fallDist / 2);
                    Level level = Objects.requireNonNull(((EntityCollisionContext) context).getEntity()).getLevel();
                    damage(level, pos, state, damage);

                    return Shapes.block();
                }
            }
        }
        return Shapes.block();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return AlchemineBlockEntityTypes.SHELL_SLIME.get().create(pos, state);
    }

}