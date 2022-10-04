package dev.elrol.zencraft.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class LightningStrikerEnchantment extends ModEnchantment {

    public LightningStrikerEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super("Lightning Striker", rarity, category, slots);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity attacker, @NotNull Entity target, int level) {
        if(!attacker.level.isClientSide) {
            ServerLevel world = ((ServerLevel) attacker.level);
            BlockPos pos = target.blockPosition();

            if(level == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
            } else if(level == 2) {
                for(int i = 0; i < 5; i++) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, pos, MobSpawnType.TRIGGERED, true, true);
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

}
