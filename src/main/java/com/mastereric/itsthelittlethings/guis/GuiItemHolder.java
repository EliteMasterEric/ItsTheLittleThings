package com.mastereric.itsthelittlethings.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import com.mastereric.itsthelittlethings.containers.ContainerItemHolder;
import com.mastereric.itsthelittlethings.tileentities.TileEntityItemHolder;

public class GuiItemHolder extends GuiContainer {

	 	public static final ResourceLocation BACKGROUND = new ResourceLocation("itsthelittlethings", "textures/gui/smallgui.png");
	 	public static final ResourceLocation INVENTORYSLOT = new ResourceLocation("itsthelittlethings", "textures/gui/inventoryslot.png");
	
	 	public TileEntityItemHolder tileEntity;
	 	
        public GuiItemHolder (InventoryPlayer inventoryPlayer,
                        TileEntityItemHolder tileEntity) {
                //the container is instanciated and passed to the superclass for handling
                super(new ContainerItemHolder(inventoryPlayer, tileEntity));
                this.tileEntity = tileEntity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //the parameters for drawString are: string, x, y, color
                fontRendererObj.drawString(StatCollector.translateToLocal("tile.blockItemHolder.name"), 60, 4, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize-96+2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
                this.mc.renderEngine.bindTexture(BACKGROUND);            // With this
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
                int currentSlotCount = 0;
                for(int i = 0; i < 3; i++) {
                	for(int j = 0; j < 3; j++) {
                		if(currentSlotCount < (tileEntity.blockMetadata + 1)) {
                            this.mc.renderEngine.bindTexture(BACKGROUND);            // With this
                            x = (width - xSize) / 2 + 60 + 18*j;
                            y = (height - ySize) / 2 + 12 + 18*i;
                            this.drawTexturedModalRect(x, y, 176, 0, 18, 18);
                            currentSlotCount++;
                		}
                	}
                }
        }

}