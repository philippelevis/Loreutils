package net.mcreator.playertracker.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class TestBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().mayfly = (false);
			_player.onUpdateAbilities();
		}
		if (entity instanceof Player _player) {
			_player.getAbilities().flying = (false);
			_player.onUpdateAbilities();
		}
	}
}
