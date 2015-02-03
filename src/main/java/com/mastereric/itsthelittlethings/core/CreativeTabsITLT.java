package com.mastereric.itsthelittlethings.core;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsITLT extends CreativeTabs {
	//Create the Creative Tab.
	public CreativeTabsITLT (String tabLabel) {
		//Set the label to what was specified.
		super(tabLabel);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		//Set the icon for the tab to be the icon from the Item Holder.
		return Item.getItemFromBlock(ItsTheLittleThings.blockItemHolder);
	}
}
