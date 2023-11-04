package net.mcreator.playertracker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.extensions.IForgeLivingEntity;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At;

import net.mcreator.playertracker.PlayertrackerMod;
// THIS DOES NOT WORK FOR MCREATOR REASONS, STUPID MCREATOR CANT HANDLE MIXINS :skuII:
@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity{
	@ModifyVariable(method="tryAddSoulSpeed", at= @At(value="STORE", ordinal=0))
	private int modifyI(int i){
		 PlayertrackerMod.LOGGER.info("'i' meant to change");
		 return i++;
	}
}
