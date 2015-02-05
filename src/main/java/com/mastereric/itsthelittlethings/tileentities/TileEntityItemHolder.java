package com.mastereric.itsthelittlethings.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityItemHolder extends TileEntity implements IInventory {
	
	private ItemStack[] inventory;
	
	public int numberOfSlots = 0;
	
	public boolean initialized = false;
	
    public TileEntityItemHolder(){
    	//Thank you for reminding me constant, now DIE!
        //numberOfSlots = 9;
        this.blockMetadata = 0;
        numberOfSlots = this.blockMetadata + 1;
        inventory = new ItemStack[numberOfSlots];
        initialized = true;
    }
	
    public TileEntityItemHolder(int metadata){
    	//Thank you for reminding me constant, now DIE!
        //numberOfSlots = 9;
        this.blockMetadata = metadata;
        numberOfSlots = this.blockMetadata + 1;
        inventory = new ItemStack[numberOfSlots];
        initialized = true;
    }
	
	//Get the number of slots in the inventory.
	@Override
	public int getSizeInventory() {
		return numberOfSlots;
	}
	
	//Get the stack in the given slot of the inventory.
	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}
	
	//Set the item in the given inventory slot.
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
        if(slot < numberOfSlots) {
    		inventory[slot] = itemstack;
            if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
                itemstack.stackSize = getInventoryStackLimit();
        }
    }   
		
	}

	//Decrease the size of the stack in the inventory
	//by the given amount. Since there is only one
	//slot in the Item Holder, 
	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
                if (stack.stackSize <= amt) {
                        setInventorySlotContents(slot, null);
                } else {
                        stack = stack.splitStack(amt);
                        if (stack.stackSize == 0) {
                                setInventorySlotContents(slot, null);
                        }
                }
        }
        return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
                setInventorySlotContents(slot, null);
        }
        return stack;
	}

	//Set the unlocalized inventory name.
	@Override
	public String getInventoryName() {
		return "tile.blockItemHolder.name";
	}

	// Set the stack limit for slots in the inventory.
	// Under normal circumstances this should be 64.
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
            return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

	@Override
	public void openInventory() {

	}
	@Override
	public void closeInventory() {

	}

	
	//Write tile NBT data.
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
	   super.writeToNBT(par1);
       NBTTagList itemList = new NBTTagList();
       for (int i = 0; i < inventory.length; i++) {
               ItemStack stack = inventory[i];
               if (stack != null) {
                       NBTTagCompound tag = new NBTTagCompound();
                       tag.setByte("Slot", (byte) i);
                       stack.writeToNBT(tag);
                       itemList.appendTag(tag);
               }
       }
       par1.setTag("Inventory", itemList);
	}
	
	//Read tile NBT data.
	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
	   super.readFromNBT(par1);
       NBTTagList tagList = par1.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
       for (int i = 0; i < tagList.tagCount(); i++) {
               NBTTagCompound tag = tagList.getCompoundTagAt(i);
               byte slot = tag.getByte("Slot");
               if (slot >= 0 && slot < inventory.length) {
                       inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
               }
       }
	}
}
