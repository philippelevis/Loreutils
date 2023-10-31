package net.mcreator.playertracker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.world.entity.ai.behavior.AnimalPanic;

public class PanicMobsProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		double x = 0;
		double y = 0;
		double z = 0;
		Entity player = null;
		player = new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity();
		x = player.getX();
		y = player.getY();
		z = player.getZ();
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((DoubleArgumentType.getDouble(arguments, "dx")) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				AnimalPanic.start(world, entityiterator, (long) 100);
			}
		}
	}
}
