package ganymedes01.woodstuff.tileentity;

import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityWoodChest extends TileEntityChest {

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord - 2, yCoord, zCoord - 2, xCoord + 2, yCoord + 1, zCoord + 2);
	}
}