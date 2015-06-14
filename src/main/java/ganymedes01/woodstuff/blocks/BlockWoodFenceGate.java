package ganymedes01.woodstuff.blocks;

import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodFenceGate extends BlockFenceGate implements IWoodBlock {

	private final int meta;
	private final Block plank;

	public BlockWoodFenceGate(Block plank, int meta) {
		this.plank = plank;
		this.meta = meta;
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(soundTypeWood);
		setCreativeTab(WoodStuff.tab);
		setBlockName(Utils.getUnlocalisedName("fence_gate_" + plank.getUnlocalizedName() + "_" + meta));
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
		return "fence_gate";
	}
}