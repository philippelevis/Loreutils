
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playertracker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.playertracker.item.ValleyOfFoolsItem;
import net.mcreator.playertracker.item.TestItem;
import net.mcreator.playertracker.item.SweetDreamsItem;
import net.mcreator.playertracker.item.ShipOfFoolsItem;
import net.mcreator.playertracker.item.HEVChargerBeatsItem;
import net.mcreator.playertracker.item.FinePrintItem;
import net.mcreator.playertracker.item.AmourPlastiqueItem;
import net.mcreator.playertracker.item.AirMaxViolinItem;
import net.mcreator.playertracker.item.AccumultorItem;
import net.mcreator.playertracker.PlayertrackerMod;

public class PlayertrackerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PlayertrackerMod.MODID);
	public static final RegistryObject<Item> SOUL_FIRE_2 = block(PlayertrackerModBlocks.SOUL_FIRE_2, PlayertrackerModTabs.TAB_LORE_UTILS);
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
	public static final RegistryObject<Item> PAIN = block(PlayertrackerModBlocks.PAIN, PlayertrackerModTabs.TAB_LORE_UTILS);
	public static final RegistryObject<Item> ACCUMULTOR = REGISTRY.register("accumultor", () -> new AccumultorItem());
	public static final RegistryObject<Item> FINE_PRINT = REGISTRY.register("fine_print", () -> new FinePrintItem());
	public static final RegistryObject<Item> SHIP_OF_FOOLS = REGISTRY.register("ship_of_fools", () -> new ShipOfFoolsItem());
	public static final RegistryObject<Item> HEV_CHARGER_BEATS = REGISTRY.register("hev_charger_beats", () -> new HEVChargerBeatsItem());
	public static final RegistryObject<Item> VALLEY_OF_FOOLS = REGISTRY.register("valley_of_fools", () -> new ValleyOfFoolsItem());
	public static final RegistryObject<Item> SWEET_DREAMS = REGISTRY.register("sweet_dreams", () -> new SweetDreamsItem());
	public static final RegistryObject<Item> AIR_MAX_VIOLIN = REGISTRY.register("air_max_violin", () -> new AirMaxViolinItem());
	public static final RegistryObject<Item> AMOUR_PLASTIQUE = REGISTRY.register("amour_plastique", () -> new AmourPlastiqueItem());
	public static final RegistryObject<Item> DEADSEED = block(PlayertrackerModBlocks.DEADSEED, PlayertrackerModTabs.TAB_LORE_UTILS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
