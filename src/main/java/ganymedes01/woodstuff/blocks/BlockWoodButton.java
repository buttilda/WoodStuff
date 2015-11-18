package ganymedes01.woodstuff.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.util.IIcon;

public class BlockWoodButton extends BlockButtonWood implements IWoodBlock {

	private final int plankMeta;
	private final Block plank;

	public BlockWoodButton(Block plank, int plankMeta) {
		this.plank = plank;
		this.plankMeta = plankMeta;
		setHardness(0.5F);
		setStepSound(soundTypeWood);
		setCreativeTab(WoodStuff.tab);
		setBlockName(Utils.getUnlocalisedName("button_" + plank.getUnlocalizedName() + "_" + plankMeta));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return plank.getIcon(side, plankMeta);
	}

	@Override
	public Block getPlanks() {
		return plank;
	}

	@Override
	public int getMeta() {
		return plankMeta;
	}

	@Override
	public String getName() {
		return "button";
	}
}