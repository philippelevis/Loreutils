
package net.mcreator.playertracker.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraft.core.Direction;
import net.mcreator.playertracker.init.PlayertrackerModTabs;

public class AccumultorItem extends Item {
	private static final int MAX_ENERGY = 1000000;
    
    public AccumultorItem() {
        super(new Item.Properties().tab(PlayertrackerModTabs.TAB_LORE_UTILS).stacksTo(1).rarity(Rarity.COMMON));
    }
    
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
        return new ICapabilityProvider() {
            // Create a new LazyOptional for the IEnergyStorage capability
            private final LazyOptional<IEnergyStorage> energyCapability = LazyOptional.of(() -> new EnergyStorage(MAX_ENERGY));

            @Override
            public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                // Check if the requested capability is ENERGY
                if (cap == CapabilityEnergy.ENERGY) {
                    return energyCapability.cast(); // Return the energyCapability as the requested capability
                }
                return LazyOptional.empty(); // Return an empty optional for any other capability
            }
        };
    }
}