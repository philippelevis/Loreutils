package net.mcreator.playertracker.procedures;

import org.checkerframework.checker.units.qual.min;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.playertracker.network.PlayertrackerModVariables;
import net.mcreator.playertracker.PlayertrackerMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;




public class SeenCommandTotalTimeProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		double sec = 0;
		double min = 0;
		double hour = 0;
		double milis = 0;
		milis = ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(PlayertrackerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayertrackerModVariables.PlayerVariables())).been_online;
		sec = (milis / 1000) % 60;
		min = (milis / (1000 * 60)) % 60;
		hour = (milis / (1000 * 60 * 60)) % 24;

		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("played for" + Math.round(hour) + "hours, "+Math.round(min)+"minutes, "+Math.round(sec) + "seconds"), (false));

		
		
		//PlayertrackerMod.LOGGER.info(("played for" + Math.round(hour) + "hours, "+Math.round(min)+"minutes, "+Math.round(sec) + "seconds"));
	}
}
