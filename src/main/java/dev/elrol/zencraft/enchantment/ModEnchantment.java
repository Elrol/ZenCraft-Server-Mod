package dev.elrol.zencraft.enchantment;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class ModEnchantment extends Enchantment {

    public final String name;

    public ModEnchantment(String name, Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super(rarity, category, slots);
        this.name = name;
    }


    public @NotNull Component getFullname(int p_44701_) {
        MutableComponent mutablecomponent = Component.literal(name);
        if (this.isCurse()) {
            mutablecomponent.withStyle(ChatFormatting.RED);
        } else {
            mutablecomponent.withStyle(ChatFormatting.GRAY);
        }

        if (p_44701_ != 1 || this.getMaxLevel() != 1) {
            mutablecomponent.append(" ").append(Component.translatable("enchantment.level." + p_44701_));
        }

        return mutablecomponent;
    }
}
