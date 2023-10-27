package net.mcreator.playertracker.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class TestRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			itemstack.getOrCreateTag().putBoolean("active", (!itemstack.getOrCreateTag().getBoolean("active")));
		}
	}
}
