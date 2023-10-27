package net.mcreator.playertracker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;

public class BoostExecProcedure {
	public static void execute(LevelAccessor world, LivingEntity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new FireworkRocketEntity(entity.getLevel(), new ItemStack(Items.FIREWORK_ROCKET), entity);
			world.addFreshEntity(entityToSpawn);
		}
	}
}
