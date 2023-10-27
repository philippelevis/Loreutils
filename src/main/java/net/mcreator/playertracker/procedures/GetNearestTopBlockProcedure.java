package net.mcreator.playertracker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetNearestTopBlockProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double i = 0;
		while (!world.isEmptyBlock(new BlockPos(x, y + i, z))) {
			i = i + 1;
		}
		return i;
	}
}
