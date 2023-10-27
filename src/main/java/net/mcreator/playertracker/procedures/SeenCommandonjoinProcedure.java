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
public class SeenCommandonjoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
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
				capability.last_login = _setval;
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
