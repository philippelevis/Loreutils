
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playertracker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.playertracker.PlayertrackerMod;

public class PlayertrackerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PlayertrackerMod.MODID);
	public static final RegistryObject<SoundEvent> SWEED = REGISTRY.register("sweed", () -> new SoundEvent(new ResourceLocation("playertracker", "sweed")));
	public static final RegistryObject<SoundEvent> FINE_PRINT = REGISTRY.register("fine_print", () -> new SoundEvent(new ResourceLocation("playertracker", "fine_print")));
	public static final RegistryObject<SoundEvent> AMOURPLASTIQUE = REGISTRY.register("amourplastique", () -> new SoundEvent(new ResourceLocation("playertracker", "amourplastique")));
	public static final RegistryObject<SoundEvent> AIR_MAX_VIOLIN = REGISTRY.register("air_max_violin", () -> new SoundEvent(new ResourceLocation("playertracker", "air_max_violin")));
	public static final RegistryObject<SoundEvent> HL_HEV_BEAT = REGISTRY.register("hl_hev_beat", () -> new SoundEvent(new ResourceLocation("playertracker", "hl_hev_beat")));
	public static final RegistryObject<SoundEvent> SWEET_DREAMS = REGISTRY.register("sweet_dreams", () -> new SoundEvent(new ResourceLocation("playertracker", "sweet_dreams")));
	public static final RegistryObject<SoundEvent> AR1A_M4TH = REGISTRY.register("ar1a_m4th", () -> new SoundEvent(new ResourceLocation("playertracker", "ar1a_m4th")));
	public static final RegistryObject<SoundEvent> DEATH_ODYSSEY = REGISTRY.register("death_odyssey", () -> new SoundEvent(new ResourceLocation("playertracker", "death_odyssey")));
	public static final RegistryObject<SoundEvent> VALLEY_OF_FOOLS = REGISTRY.register("valley_of_fools", () -> new SoundEvent(new ResourceLocation("playertracker", "valley_of_fools")));
	public static final RegistryObject<SoundEvent> RECONSTRUCTING_SCIENCE = REGISTRY.register("reconstructing_science", () -> new SoundEvent(new ResourceLocation("playertracker", "reconstructing_science")));
}
