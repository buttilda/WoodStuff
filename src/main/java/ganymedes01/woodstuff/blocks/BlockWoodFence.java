package ganymedes01.woodstuff.blocks;

import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodFence extends BlockFence implements IWoodBlock {

	private final int meta;
	private final Block plank;

	public BlockWoodFence(Block plank, int meta) {
		super(null, Material.wood);
		this.plank = plank;
		this.meta = meta;
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(soundTypeWood);
		setCreativeTab(WoodStuff.tab);
		setBlockName(Utils.getUnlocalisedName("fence_" + plank.getUnlocalizedName() + "_" + meta));
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return side == ForgeDirection.UP;
	}

	@Override
	public boolean canConnectFenceTo(IBlockAccess world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return super.canConnectFenceTo(world, x, y, z) || block instanceof BlockWoodFence || block instanceof BlockWoodFenceGate;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return plank.getIcon(side, this.meta);
	}

	@Override
	public Block getPlanks() {
		return plank;
	}

	@Override
	public int getMeta() {
		return meta;
	}

	@Override
	public String getName() {
		return "fence";
	}
}