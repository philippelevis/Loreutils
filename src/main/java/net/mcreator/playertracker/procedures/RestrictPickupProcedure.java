package net.mcreator.playertracker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RestrictPickupProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getEntity(), event.getItem().getItem());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity.getDisplayName().getString()).equals(itemstack.getOrCreateTag().getString("Crafter")) && itemstack.getOrCreateTag().getBoolean("bound")) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
		if (event != null && event.hasResult()) {
			event.setResult(Event.Result.DEFAULT);
		}
	}
}
