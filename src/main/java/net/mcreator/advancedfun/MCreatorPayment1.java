package net.mcreator.advancedfun;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.GuiTextField;

import java.util.HashMap;

@Elementsadvancedfun.ModElement.Tag
public class MCreatorPayment1 extends Elementsadvancedfun.ModElement {
	public MCreatorPayment1(Elementsadvancedfun instance) {
		super(instance, 5);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorPayment1!");
			return;
		}
		if (dependencies.get("guiinventory") == null) {
			System.err.println("Failed to load dependency guiinventory for procedure MCreatorPayment1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guiinventory = (HashMap) dependencies.get("guiinventory");
		if (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Items.IRON_INGOT, (int) (1))) : false)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.IRON_INGOT, (int) (1)).getItem(), -1, (int) 1, null);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString((new Object() {
						public String getText() {
							GuiTextField textField = (GuiTextField) guiinventory.get("text:Message1");
							if (textField != null) {
								return textField.getText();
							}
							return "";
						}
					}.getText())));
			}
		}
	}
}
