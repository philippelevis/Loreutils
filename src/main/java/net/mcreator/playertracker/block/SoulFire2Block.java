
package net.mcreator.playertracker.block;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;
import net.minecraft.world.level.block.SoulFireBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;

public class SoulFire2Block extends SoulFireBlock {
	public SoulFire2Block() {
		super(BlockBehaviour.Properties.of(Material.FIRE).sound(SoundType.SOUL_SOIL).strength(1f, 10f));
	}

	 public BlockState updateShape(BlockState p_56659_, Direction p_56660_, BlockState p_56661_, LevelAccessor p_56662_, BlockPos p_56663_, BlockPos p_56664_) {
      return this.canSurvive(p_56659_, p_56662_, p_56663_) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

   	public boolean canSurvive(BlockState p_56655_, LevelReader p_56656_, BlockPos p_56657_) {
      	return canSurviveOnBlock(p_56656_.getBlockState(p_56657_.below()));
   	}

   	public static boolean canSurviveOnBlock(BlockState p_154651_) {
      	return true;
   	}

   	protected boolean canBurn(BlockState p_56668_) {
		return true;
   	}
}
