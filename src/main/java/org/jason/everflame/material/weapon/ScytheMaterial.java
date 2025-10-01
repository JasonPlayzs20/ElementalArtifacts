package org.jason.everflame.material.weapon;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import static net.minecraft.item.Items.NETHERITE_SCRAP;

public class ScytheMaterial implements ToolMaterial{
//    public static final ToolMaterial SCYTHE_MATERIAL = new ToolMaterial(1255, (float)1, 8  , 45, ItemTags.DIAMOND_TOOL_MATERIALS);

    @Override
    public int getDurability() {
        return 1255;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6;
    }

    @Override
    public float getAttackDamage() {
        return 8;
    }

    @Override
    public int getMiningLevel() {
        return 8;
    }

    @Override
    public int getEnchantability() {
        return 45;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
