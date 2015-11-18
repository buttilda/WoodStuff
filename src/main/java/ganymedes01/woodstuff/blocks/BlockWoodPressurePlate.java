package ganymedes01.woodstuff.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWoodPressurePlate extends BlockPressurePlate implements IWoodBlock {

	private final int meta;
	private final Block plank;

	public BlockWoodPressurePlate(Block plank, int meta) {
		super("", Material.wood, BlockPressurePlate.Sensitivity.everything);
		this.plank = plank;
		this.meta = meta;
		setHardness(0.5F);
		setStepSound(soundTypeWood);
		setCreativeTab(WoodStuff.tab);
		setBlockName(Utils.getUnlocalisedName("pressure_plate_" + plank.getUnlocalizedName() + "_" + meta));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return plank.getIcon(side, this.meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
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
		return "pressure_plate";
	}
}