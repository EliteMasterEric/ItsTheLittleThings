package com.mastereric.itsthelittlethings.core;

import com.mastereric.itsthelittlethings.blocks.BlockItemHolder;
import com.mastereric.itsthelittlethings.guis.GuiHandler;
import com.mastereric.itsthelittlethings.items.ItemBlockItemHolder;
import com.mastereric.itsthelittlethings.tileentities.TileEntityItemHolder;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ItsTheLittleThings.MODID, name = "It's The Little Things", version = ItsTheLittleThings.VERSION)
public class ItsTheLittleThings
{
    public static final String MODID = "ItsTheLittleThings";
    public static final String VERSION = "0.2 TESTING";
    
	public static Block blockItemHolder;
	
	public static ItemStack stackItemHolder;
	
	public static CreativeTabs tabITLT = new CreativeTabsITLT("tabITLT");
	
	public static ItsTheLittleThings instance;
	
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing ITLT version " + VERSION + "...");
        instance = this;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//Create blocks.
		blockItemHolder = new BlockItemHolder().setBlockName("blockItemHolder");
		
		//Register blocks.
		GameRegistry.registerBlock(blockItemHolder, ItemBlockItemHolder.class,
				MODID + (blockItemHolder.getUnlocalizedName().substring(5)));
		//Register tile entities.
		GameRegistry.registerTileEntity(TileEntityItemHolder.class, 
				"itsthelittlethings.inventories.TileEntityItemHolder");
		//Register GUIs.
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        //Register recipes.
        //Item Holder
        GameRegistry.addShapedRecipe(new ItemStack(blockItemHolder, 1, 0),
        		"wbw", "bcb", "wbw",
        		'c', new ItemStack(Blocks.chest),
        		'b', new ItemStack(Blocks.iron_bars),
        		'w', new ItemStack(Blocks.planks));
        //Item Holder Shapeless Recipes
        RecipeSorter.register(MODID + ":itemholder", RecipeItemHolder.class,
        		Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeItemHolder());
	}
}
