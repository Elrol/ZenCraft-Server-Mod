package dev.elrol.zencraft.events;

import dev.elrol.zencraft.ZenCraft;
import dev.elrol.zencraft.enchantment.ModEnchantments;
import dev.elrol.zencraft.libs.Methods;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEventHandler {

    @SubscribeEvent
    public void onAnvilRepiar(AnvilRepairEvent event) {
        ItemStack item = event.getLeft();
        ItemStack book = event.getRight();
        ItemStack output = event.getOutput();

        if(book.is(Items.ENCHANTED_BOOK)) {
            EnchantmentHelper.deserializeEnchantments(EnchantedBookItem.getEnchantments(book)).forEach((ench,lvl)->
                    ModEnchantments.ENCHANTMENTS.getEntries().forEach(obj-> {
                        if(ench.equals(obj.get())) {
                            if(ench.canEnchant(output)) {
                                MutableComponent component = (MutableComponent) ench.getFullname(lvl);
                                component.setStyle(Style.EMPTY.withItalic(false).withColor(ChatFormatting.GRAY));
                                //TODO replace old enchant lore with new one
                                Methods.addLore(output, component);
                            } else {
                                ZenCraft.LOGGER.info(ench.getFullname(lvl) + " can't be added to " + output.getDisplayName());
                            }
                        } else {
                            ZenCraft.LOGGER.info(ench.getFullname(lvl) + " isn't " + obj.get().getFullname(lvl));
                        }
                    }));
        }
        ZenCraft.LOGGER.info("Called Event:" + item.getItem().getDescriptionId() + " + " + book.getItem().getDescriptionId() + " = " + output.getItem().getDescriptionId());
    }

}
