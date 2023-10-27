
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

public class ShipOfFoolsItem extends RecordItem {
	public ShipOfFoolsItem() {
		super(8, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("playertracker:death_odyssey")), new Item.Properties().tab(PlayertrackerModTabs.TAB_LORE_UTILS).stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("coins spin, swift and sharp,"));
		list.add(Component.literal("a martial art, a hidden arc."));
		list.add(Component.literal("with flick of wrist, precision's grace,"));
		list.add(Component.literal("fortune's dance, in every space."));
	}
}
