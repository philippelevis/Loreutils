
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playertracker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.playertracker.block.SoulFire2Block;
import net.mcreator.playertracker.block.PainBlock;
import net.mcreator.playertracker.PlayertrackerMod;

public class PlayertrackerModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PlayertrackerMod.MODID);
	public static final RegistryObject<Block> SOUL_FIRE_2 = REGISTRY.register("soul_fire_2", () -> new SoulFire2Block());
	public static final RegistryObject<Block> PAIN = REGISTRY.register("pain", () -> new PainBlock());
}
