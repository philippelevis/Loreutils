package net.mcreator.playertracker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.playertracker.network.PlayertrackerModVariables;

import javax.annotation.Nullable;

import java.util.Calendar;

@Mod.EventBusSubscriber
public class SeenCommandonLeaveProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = Calendar.getInstance().getTimeInMillis();
			entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.last_disconnect = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayertrackerModVariables.PlayerVariables())).last_disconnect
					- (entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayertrackerModVariables.PlayerVariables())).last_login
					+ (entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayertrackerModVariables.PlayerVariables())).been_online;
			entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.been_online = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = new java.text.SimpleDateFormat("mm-hh-dd-MM-yyyy").format(Calendar.getInstance().getTime());
			entity.getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lastLoginDate = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
