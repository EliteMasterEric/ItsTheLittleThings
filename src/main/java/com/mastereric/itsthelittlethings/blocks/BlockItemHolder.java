package com.mastereric.itsthelittlethings.blocks;

import java.util.List;
import java.util.Random;

import com.mastereric.itsthelittlethings.core.ItsTheLittleThings;
import com.mastereric.itsthelittlethings.tileentities.TileEntityItemHolder;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockItemHolder extends BlockContainer {

	IIcon textureTop;
	IIcon textureBottom;
	IIcon textureBlank;
	IIcon textureI;
	IIcon textureII;
	IIcon textureIII;
	IIcon textureIV;
	IIcon textureV;
	IIcon textureVI;
	IIcon textureVII;
	IIcon textureVIII;
	IIcon textureIX;
	
	public BlockItemHolder() {
		//Set the material type of the item.
		//Requires an iron pick to pick up?
		super(Material.iron);
        setHardness(2.0F);
        setResistance(5.0F);
		this.setCreativeTab(ItsTheLittleThings.tabITLT);
		setBlockTextureName(ItsTheLittleThings.MODID + ":" + "blockItemHolder");
		
	}

	@Override
	public IIcon getIcon(int side, int damageValue) {
		//Top or Bottom
		switch(side) {
			case 0:
				return textureBottom;
			case 1:
				return textureTop;
			default:
				switch(damageValue) {
					case 0:
						return textureI;
					case 1:
						return textureII;
					case 2:
						return textureIII;
					case 3:
						return textureIV;
					case 4:
						return textureV;
					case 5:
						return textureVI;
					case 6:
						return textureVII;
					case 7:
						return textureVIII;
					case 8:
						return textureIX;
					default:
						return textureBlank;
				}
		}
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int metadata, float what, float these, float are) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }
            player.openGui(ItsTheLittleThings.instance, 0, world, x, y, z);
            return true;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
            dropContents(world, x, y, z);
            super.breakBlock(world, x, y, z, par5, par6);
    }
    
    @Override
    public int damageDropped (int metadata) {
    	return metadata;
    }
    
    private void dropContents(World world, int x, int y, int z){
        Random rand = new Random();

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory)) {
                return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack item = inventory.getStackInSlot(i);

                if (item != null && item.stackSize > 0) {
                    float rx = rand.nextFloat() * 0.8F + 0.1F;
                    float ry = rand.nextFloat() * 0.8F + 0.1F;
                    float rz = rand.nextFloat() * 0.8F + 0.1F;

                    EntityItem entityItem = new EntityItem(world,
                                        x + rx, y + ry, z + rz,
                                        item);

                        if (item.hasTagCompound()) {
                                entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                        }

                        float factor = 0.05F;
                        entityItem.motionX = rand.nextGaussian() * factor;
                        entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                        entityItem.motionZ = rand.nextGaussian() * factor;
                        world.spawnEntityInWorld(entityItem);
                        item.stackSize = 0;
                }
        }
}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		textureTop = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderTop");
		textureBottom = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderBottom");
		textureBlank = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideBlank");
		textureI = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideI");
		textureII = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideII");
		textureIII = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideIII");
		textureIV = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideIV");
		textureV = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideV");
		textureVI = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideVI");
		textureVII = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideVII");
		textureVIII = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideVIII");
		textureIX = par1IconRegister.registerIcon("itsthelittlethings:blockItemHolderSideIX");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
	   return new TileEntityItemHolder(metadata);
	}
	
	//IDK if this is needed, or if it's only need for the ItemBlock.
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs creativeTabs, List list)
    {
          for(int i = 0; i < 9; i++)
          {
                 list.add(new ItemStack(this, 1, i));
          }
    }

}
