package dev.elrol.zencraft.enchantment;


import dev.elrol.zencraft.ZenCraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ZenCraft.MODID);

    public static RegistryObject<Enchantment> LIGHTNING_STRIKER =
            ENCHANTMENTS.register("lightning_striker",
                    ()-> new LightningStrikerEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> EXPLOSION_STRIKER =
            ENCHANTMENTS.register("explosion_striker",
                    ()-> new ExplosionStrikerEnchantment(
                            Enchantment.Rarity.COMMON,
                            EnchantmentCategory.WEAPON,
                            EquipmentSlot.MAINHAND
                    ));

    public static void register(IEventBus bus) {
        ZenCraft.LOGGER.info("Registering Enchantments");
        ENCHANTMENTS.getEntries().forEach(e-> ZenCraft.LOGGER.info(e.getId()));
        ENCHANTMENTS.register(bus);
    }

}
