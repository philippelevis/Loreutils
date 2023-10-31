package net.mcreator.playertracker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.mcreator.playertracker.PlayertrackerMod;

import javax.annotation.Nullable;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteractSpecific;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import java.util.Comparator;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;

@Mod.EventBusSubscriber
public class WearinessProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteractSpecific event) {
	LevelAccessor world = event.getLevel();
	double x = event.getPos().getX();
	double y = event.getPos().getY();
	double z = event.getPos().getZ();
	if 	(event.getTarget() instanceof Animal animal && animal.isFood(event.getItemStack())){
		int i = animal.getAge();
		if (i==0 && animal.canFallInLove()&& (new Object() {public int getScore(String score, Entity _ent) {Scoreboard _sc = _ent.getLevel().getScoreboard();Objective _so = _sc.getObjective(score);if (_so != null)return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();return 0;}}.getScore("weariness", ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).stream().sorted(new Object() {Comparator<Entity> compareDistOf(double _x, double _y, double _z) {return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));}}.compareDistOf(x, y, z)).findFirst().orElse(null))) == 1)){
			PlayertrackerMod.LOGGER.info("no breeding 4 u");
			}
		}
	}
}
