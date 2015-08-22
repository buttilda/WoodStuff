package ganymedes01.woodstuff.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.world.World;

public class ContainerCraftingTable extends ContainerWorkbench {

	private final int x, y, z;

	public ContainerCraftingTable(InventoryPlayer playerInvt, World world, int x, int y, int z) {
		super(playerInvt, world, x, y, z);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return player.getDistanceSq(x + 0.5D, y + 0.5D, z + 0.5D) <= 64.0D;
	}
}
