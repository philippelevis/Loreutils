package net.mcreator.playertracker.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.playertracker.PlayertrackerMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CircleProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		BlockState block = Blocks.AIR.defaultBlockState();
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double radius = 0;
		double distance = 0;
		PlayertrackerMod.LOGGER.info("creating a circle!");
		dx = new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "coords").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX();
		dy = new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "coords").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY();
		dz = new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "coords").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ();
		radius = DoubleArgumentType.getDouble(arguments, "radius");
		block = (BlockStateArgument.getBlock(arguments, "block").getState());
		for (double xi = (double) ((-1) * radius); xi <= (double) radius; xi++) {
			for (double zi = (double) ((-1) * radius); zi <= (double) radius; zi++) {
				distance = Math.sqrt(Math.pow(xi, 2) + Math.pow(zi, 2));
				if (distance >= radius - 1 && distance <= radius) {
					PlayertrackerMod.LOGGER.debug(("placing block at " + dx + xi + ", " + dy + GetNearestTopBlockProcedure.execute(world, dx + xi, dy, dz + zi) + ", " + dz + zi + "to continue the circle"));
					world.setBlock(new BlockPos(dx + xi, dy + GetNearestTopBlockProcedure.execute(world, dx + xi, dy, dz + zi), dz + zi), block, 3);
				}
			}
		}
	}
}
