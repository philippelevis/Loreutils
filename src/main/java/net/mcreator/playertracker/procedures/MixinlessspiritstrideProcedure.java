package net.mcreator.playertracker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.playertracker.network.PlayertrackerModVariables;
import net.mcreator.playertracker.PlayertrackerMod;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class MixinlessspiritstrideProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		PlayertrackerMod.LOGGER.debug(("" + (entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayertrackerModVariables.PlayerVariables())).spiritstrideActive));
		if ((entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayertrackerModVariables.PlayerVariables())).spiritstrideActive
				&& ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.SOUL_SAND || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.SOUL_SOIL)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("d3a53e6a-2b5f-4e1e-8b1d-bf8e3ef9d4c"), "SOULSPEEDBUFF", 0.03F * (1.0F + 0.35F), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("d3a53e6a-2b5f-4e1e-8b1d-bf8e3ef9d4c"), "SOULSPEEDBUFF", 0.03F * (1.0F + 0.35F), AttributeModifier.Operation.ADDITION)));
		} else {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.removeModifier((new AttributeModifier(UUID.fromString("d3a53e6a-2b5f-4e1e-8b1d-bf8e3ef9d4c"), "SOULSPEEDBUFF", 0.03F * (1.0F + 0.35F), AttributeModifier.Operation.ADDITION)));
		}
	}
}
