
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

public class HEVChargerBeatsItem extends RecordItem {
	public HEVChargerBeatsItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("playertracker:hl_hev_beat")), new Item.Properties().tab(PlayertrackerModTabs.TAB_LORE_UTILS).stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("HEV chargers, lifeline's grace,"));
		list.add(Component.literal("Half-life lore, Combine's embrace."));
		list.add(Component.literal("Power surges, resistance found,"));
		list.add(Component.literal("Worlds collide, in silence profound."));
	}
}
