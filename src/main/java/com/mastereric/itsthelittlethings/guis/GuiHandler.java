package com.mastereric.itsthelittlethings.guis;

import com.mastereric.itsthelittlethings.containers.ContainerItemHolder;
import com.mastereric.itsthelittlethings.tileentities.TileEntityItemHolder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) {
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityItemHolder){
                        return new ContainerItemHolder(player.inventory, (TileEntityItemHolder) tileEntity);
                }
                return null;
        }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) {
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityItemHolder){
                        return new GuiItemHolder(player.inventory, (TileEntityItemHolder) tileEntity);
                }
                return null;

        }
}