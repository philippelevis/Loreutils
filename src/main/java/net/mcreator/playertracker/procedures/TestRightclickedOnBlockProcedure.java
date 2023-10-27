package net.mcreator.playertracker.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class TestRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			itemstack.getOrCreateTag().putDouble("x", x);
			itemstack.getOrCreateTag().putDouble("y", y);
			itemstack.getOrCreateTag().putDouble("z", z);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("sucessfully bound to " + itemstack.getOrCreateTag().getDouble("x") + ", " + itemstack.getOrCreateTag().getDouble("y") + ", " + itemstack.getOrCreateTag().getDouble("z")
						+ " and now drawing energy from a pool of " + (new Object() {
							public int getEnergyStored(LevelAccessor level, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								BlockEntity _ent = level.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(world, new BlockPos(x, y, z))) + "/" + (new Object() {
							public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								BlockEntity _ent = level.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
								return _retval.get();
							}
						}.getMaxEnergyStored(world, new BlockPos(x, y, z))))), (false));
		}
	}
}
