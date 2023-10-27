
package net.mcreator.playertracker.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.playertracker.procedures.TestWhileBaubleIsEquippedTickProcedure;
import net.mcreator.playertracker.procedures.TestRightclickedProcedure;
import net.mcreator.playertracker.procedures.TestRightclickedOnBlockProcedure;
import net.mcreator.playertracker.procedures.TestBaubleIsUnequippedProcedure;
import net.mcreator.playertracker.procedures.TestBaubleIsEquippedProcedure;
import net.mcreator.playertracker.procedures.MayflyitemMakeItemGlowProcedure;
import net.mcreator.playertracker.init.PlayertrackerModTabs;

public class TestItem extends Item implements ICurioItem {
	public TestItem() {
		super(new Item.Properties().tab(PlayertrackerModTabs.TAB_LORE_UTILS).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return MayflyitemMakeItemGlowProcedure.execute(itemstack);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		TestRightclickedProcedure.execute(entity, itemstack);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TestRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		TestWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level, slotContext.entity(), stack);
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		TestBaubleIsEquippedProcedure.execute(slotContext.entity(), stack);
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		TestBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}
