package com.mastereric.itsthelittlethings.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemBlockItemHolder extends ItemBlock {

	public ItemBlockItemHolder(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	//Add item lore, the text under the item name
	//that tells how many slots the Item Holder has.
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean bool) {
		lore.add(EnumChatFormatting.AQUA + "Slots: " + (stack.getItemDamage() + 1));
	}
	
	//Add all the possible damage values
	//to the Creative menu.
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 9; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    @Override
    public int getMetadata (int damageValue) {
    	return damageValue;
    }
}
