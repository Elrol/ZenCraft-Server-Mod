package dev.elrol.zencraft.libs;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    public static ItemStack addLore(ItemStack item, Component line) {
        CompoundTag tag = item.getOrCreateTag();
        CompoundTag display = tag.getCompound(ItemStack.TAG_DISPLAY);
        ListTag lore = display.getList(ItemStack.TAG_LORE, 8);
        lore.add(StringTag.valueOf(Component.Serializer.toJson(line)));
        display.put(ItemStack.TAG_LORE, lore);
        tag.put(ItemStack.TAG_DISPLAY, display);
        item.setTag(tag);
        return item;
    }

    public List<Component> getLore(ItemStack item) {
        List<Component> list = new ArrayList<>();
        CompoundTag tag = item.getTag();
        if(tag != null) {
            for (Tag tag1 : tag.getCompound(ItemStack.TAG_DISPLAY).getList(ItemStack.TAG_LORE, 8)) {
                StringTag stringTag = ((StringTag) tag1);
                Component line = Component.Serializer.fromJson(stringTag.getAsString());
                if(line != null) list.add(line);
            }
        }
        return list;
    }

}
