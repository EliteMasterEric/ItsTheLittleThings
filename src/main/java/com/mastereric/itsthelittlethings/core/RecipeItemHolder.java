package com.mastereric.itsthelittlethings.core;

import java.util.ArrayList;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeItemHolder implements IRecipe {

	private ItemStack finalResult;
	
	//Making all the possible recipes for the Item Holder
	//would take too long and take way too much space,
	//so I use a method similar to how Fireworks recipes
	//are done. Use this type of recipe adding yourself
	//if you're making lots of repetitive recipes, like
	//adding stairs and slabs and doors and pressure plates
	//and planks for 20 different kinds of wood. You can just
	//return based on damage value.
	public RecipeItemHolder() {
		System.out.println("Adding Item Holder Recipes...");
	}
	
	//This method tells the game whether the current recipe
	//in the crafting window is one of the recipes that
	//should be handled by this class. If this method returns
	//true, the displayed output of the recipe should be the
	//item returned by getRecipeOutput or getCraftingResult.
	@Override
	public boolean matches(InventoryCrafting craftingWindow, World world) {
		finalResult = null;
		//Before going on, make sure everything exists...
		if(craftingWindow == null || world == null) {
			return false;
		}
		
		ArrayList<ItemStack> listOfItemHolders = new ArrayList<ItemStack>();
		
		//For each slot in the crafting window...
		for(int i = 0; i < craftingWindow.getSizeInventory(); i++) {
			//Check what item is in there.
			ItemStack itemstack = craftingWindow.getStackInSlot(i);
			//If the item exists,
			if(itemstack != null) {
				//and it is NOT an item holder,
				if(!itemstack.getItem().equals(ItsTheLittleThings.blockItemHolder)) {
					//Then this isn't a recipe we want to deal with get out now.
					return false;
				}
				//If you get here, it's an item holder, so increase the number of item holders.
				listOfItemHolders.add(itemstack);
			}
		}
		//Now that you have a list of all the item holders...
		//If the list is empty, just stop now. We're done here.
		if(listOfItemHolders.size() == 0) {
			return false;
		}
		//This code deals with "breaking down" recipes.
		if(listOfItemHolders.size() == 1) {
			//Get the item holder.
			ItemStack itemHolder = listOfItemHolders.get(0);
			//Now, switch which output to use based on the item's damage.
			switch(itemHolder.getItemDamage()) {
				case 0:
					//This is just a base item holder,
					//it can't be broken down!
					return false;
				case 1:
					//This is a 2 slot item holder,
					//so return 2 base item holders.
					//Give Item Holder, quantity 2, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 2, 0);
					return true;
				case 2:
					//This is a 3 slot item holder,
					//so return 3 base item holders.
					//Give Item Holder, quantity 3, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 3, 0);
				case 3:
					//This is a 4 slot item holder,
					//so return 4 base item holders.
					//Give Item Holder, quantity 4, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 4, 0);
				case 4:
					//This is a 5 slot item holder,
					//so return 5 base item holders.
					//Give Item Holder, quantity 5, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 5, 0);
				case 5:
					//This is a 6 slot item holder,
					//so return 6 base item holders.
					//Give Item Holder, quantity 6, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 6, 0);
				case 6:
					//This is a 7 slot item holder,
					//so return 7 base item holders.
					//Give Item Holder, quantity 7, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 7, 0);
				case 7:
					//This is a 8 slot item holder,
					//so return 8 base item holders.
					//Give Item Holder, quantity 8, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 8, 0);
				case 8:
					//This is a 9 slot item holder,
					//so return 9 base item holders.
					//Give Item Holder, quantity 9, damage value 0.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 9, 0);
				default:
					//If you got here, something done broke.
					//Tell the game the recipe is invalid.
					return false;
			}
		//And this code deals with "combining" recipes.
		} else {
			//Get the number of slots the final Item Holder would have...
			int combinedValue = 0;
			//By adding up the number of slots of all the Item Holders in the recipe. 
			for(int i = 0; i < listOfItemHolders.size(); i++) {
				ItemStack itemHolder = listOfItemHolders.get(i);

				combinedValue += (itemHolder.getItemDamage() + 1);
			}
			switch(combinedValue) {
				case 1:
					//A one-slot item holder? That's just the default!
					//You don't need to craft anything here.
					return false;
				case 2:
					//There are 2 slots of item holders,
					//so return a 2 slot item holder.
					//Give Item Holder, quantity 1, damage value 1.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 1);
					return true;
				case 3:
					//There are 3 slots of item holders,
					//so return a 3 slot item holder.
					//Give Item Holder, quantity 1, damage value 2.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 2);
					return true;
				case 4:
					//There are 4 slots of item holders,
					//so return a 4 slot item holder.
					//Give Item Holder, quantity 1, damage value 3.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 3);
					return true;
				case 5:
					//There are 5 slots of item holders,
					//so return a 5 slot item holder.
					//Give Item Holder, quantity 1, damage value 4.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 4);
					return true;
				case 6:
					//There are 6 slots of item holders,
					//so return a 6 slot item holder.
					//Give Item Holder, quantity 1, damage value 5.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 5);
					return true;
				case 7:
					//There are 7 slots of item holders,
					//so return a 7 slot item holder.
					//Give Item Holder, quantity 1, damage value 6.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 6);
					return true;
				case 8:
					//There are 8 slots of item holders,
					//so return a 8 slot item holder.
					//Give Item Holder, quantity 1, damage value 7.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 7);
					return true;
				case 9:
					//There are 9 slots of item holders,
					//so return a 9 slot item holder.
					//Give Item Holder, quantity 1, damage value 8.
					finalResult = new ItemStack(ItsTheLittleThings.blockItemHolder, 1, 8);
					return true;
				default:
					//If you got here, something done broke.
					//Tell the game the recipe is invalid.
					return false;
			}
		}
		//If you got here, something done broke.
		//There used to be a return false here, but Eclipse
		//said the code was unreachable so I removed it.
	}
	
	//Return the item that match() determined should be given.
	//This is the item the player GETS, so you need to make sure
	//you return a copy, not the original.
	@Override
	public ItemStack getCraftingResult(InventoryCrafting arg0) {
		return finalResult.copy();
	}

	//Return the item that match() determined should be given.
	//This is NOT the item the player gets, only the item the
	//player sees.
	@Override
	public ItemStack getRecipeOutput() {
		return finalResult;
	}

	//This is what it does in RecipeFireworks.class, so IDK what it means.
	@Override
	public int getRecipeSize() {
		return 10;
	}



}
