package org.jason.everflame;

//import com.jason.weaponsmaxed.material.weapon.ScytheMaterial;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//import net.minecraft.component.type.AttributeModifiersComponent;
//import net.minecraft.component.type.WeaponComponent;
import net.minecraft.entity.ai.brain.task.MeleeAttackTask;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import org.jason.everflame.material.weapon.ScytheMaterial;

import java.util.EventListener;
import java.util.function.Function;
public class ModItems {
    public static Item register(String name, Item item) {
//        RegistryKey<Item> itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Everflame.MOD_ID, name));
//
//        Item item = itemFactory.apply(settings.registryKey(itemRegistryKey));
//        Registry.register(Registries.ITEM, itemRegistryKey, item);
        Identifier itemID = new Identifier(Everflame.MOD_ID, name);
        Item registeredItem = Registry.register(Registries.ITEM,itemID,item);
        return item;
    }
    public static final Item CLOWN_SCYTHE = register("clown_scythe", new AxeItem(new ScytheMaterial(), 1.1f,-2.6f, new FabricItemSettings()));

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, ModItemGroup.WEAPON_ITEM_GROUP_KEY, ModItemGroup.WEAPON_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.WEAPON_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CLOWN_SCYTHE);
        });
    }
}
