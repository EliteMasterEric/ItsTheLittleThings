package com.mastereric.itsthelittlethings.blocks;

import com.mastereric.itsthelittlethings.core.ItsTheLittleThings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockItemHolder extends Block {

	IIcon texture;
	
	public BlockItemHolder() {
		//Set the material type of the item.
		//Requires an iron pick to pick up?
		super(Material.iron);
		this.setCreativeTab(ItsTheLittleThings.tabITLT);
		setBlockTextureName(ItsTheLittleThings.MODID + ":" + "blockItemHolder");
	}

	@Override
	public IIcon getIcon(int i, int j) {
		//Top or Bottom
		if (i == 1 || i == 0) {
			return texture;
		//Sides
		} else {
			return texture;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		texture = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolder");
	}
}
