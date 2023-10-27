package net.mcreator.playertracker.procedures;

import net.minecraft.world.item.ItemStack;

public class MayflyitemMakeItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("active");
	}
}
