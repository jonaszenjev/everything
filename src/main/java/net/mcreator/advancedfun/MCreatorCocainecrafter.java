package net.mcreator.advancedfun;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@Elementsadvancedfun.ModElement.Tag
public class MCreatorCocainecrafter extends Elementsadvancedfun.ModElement {
	public MCreatorCocainecrafter(Elementsadvancedfun instance) {
		super(instance, 9);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorCocainecrafter!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Blocks.SAND, (int) (1), 0)) : false)) {
			if (((entity instanceof EntityPlayer)
					? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Blocks.COAL_BLOCK, (int) (1)))
					: false)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Blocks.SAND, (int) (1), 0).getItem(), 0, (int) 1, null);
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Blocks.COAL_BLOCK, (int) (1)).getItem(), -1, (int) 1, null);
				if (entity instanceof EntityPlayer)
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), new ItemStack(MCreatorPlastikstuck.block, (int) (1)));
			}
		}
	}
}
