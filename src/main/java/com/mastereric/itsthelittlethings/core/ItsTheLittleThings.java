package com.mastereric.itsthelittlethings.core;

import com.mastereric.itsthelittlethings.blocks.BlockItemHolder;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ItsTheLittleThings.MODID, name = "It's The Little Things", version = ItsTheLittleThings.VERSION)
public class ItsTheLittleThings
{
    public static final String MODID = "ItsTheLittleThings";
    public static final String VERSION = "0.2 TESTING";
    
	public static Block blockItemHolder;
	
	public static CreativeTabs tabITLT = new CreativeTabsITLT("tabITLT");
	
	//public static Item tutorialItem;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing ITLT version " + VERSION + "...");
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		blockItemHolder = new BlockItemHolder().setBlockName("blockItemHolder");
		
		GameRegistry.registerBlock(blockItemHolder, MODID + (blockItemHolder.getUnlocalizedName().substring(5)));

		
	}
}
