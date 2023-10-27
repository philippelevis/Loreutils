
package net.mcreator.playertracker.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.playertracker.init.PlayertrackerModTabs;

import java.util.List;

public class ValleyOfFoolsItem extends RecordItem {
	public ValleyOfFoolsItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("playertracker:valley_of_fools")), new Item.Properties().tab(PlayertrackerModTabs.TAB_LORE_UTILS).stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("V-1, a force of one, unmatched in might,"));
		list.add(Component.literal("Through battles fierce, he claims the fight."));
		list.add(Component.literal("A warrior lone, with valor untold,"));
		list.add(Component.literal("In epic tales, his legend unfolds."));
	}
}
