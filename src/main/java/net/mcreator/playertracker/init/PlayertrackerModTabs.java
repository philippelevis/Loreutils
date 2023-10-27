
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playertracker.init;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class PlayertrackerModTabs {
	public static CreativeModeTab TAB_LORE_UTILS;

	public static void load() {
		TAB_LORE_UTILS = new CreativeModeTab("tablore_utils") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.SUGAR_CANE);
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
