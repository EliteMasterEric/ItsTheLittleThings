package com.mastereric.itsthelittlethings.core;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ItsTheLittleThings.MODID, version = ItsTheLittleThings.VERSION)
public class ItsTheLittleThings
{
    public static final String MODID = "ItsTheLittleThings";
    public static final String VERSION = "0.1 TESTING";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
