package net.mcreator.playertracker.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class TestWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player player && player.getAbilities().flying && new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, new BlockPos(itemstack.getOrCreateTag().getDouble("x"), itemstack.getOrCreateTag().getDouble("y"), itemstack.getOrCreateTag().getDouble("z"))) > 20) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(itemstack.getOrCreateTag().getDouble("x"), itemstack.getOrCreateTag().getDouble("y"), itemstack.getOrCreateTag().getDouble("z")));
				int _amount = 20;
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		} else if (entity instanceof Player player && player.getAbilities().flying) {
			entity.hurt(DamageSource.LIGHTNING_BOLT, 1);
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = (false);
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = (false);
				_player.onUpdateAbilities();
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(itemstack.getOrCreateTag().getDouble("x"), itemstack.getOrCreateTag().getDouble("y"), itemstack.getOrCreateTag().getDouble("z")));
				int _amount = new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(itemstack.getOrCreateTag().getDouble("x"), itemstack.getOrCreateTag().getDouble("y"), itemstack.getOrCreateTag().getDouble("z")));
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		}
	}
}
