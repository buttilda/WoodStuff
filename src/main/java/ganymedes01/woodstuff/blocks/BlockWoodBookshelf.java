package ganymedes01.woodstuff.blocks;

import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodBookshelf extends BlockBookshelf implements IWoodBlock {

	public static final int RENDER_ID = RenderingRegistry.getNextAvailableRenderId();

	@SideOnly(Side.CLIENT)
	public static IIcon overlay;
	@SideOnly(Side.CLIENT)
	public static boolean renderOverlay;

	private final Block planks;
	private final int meta;

	public BlockWoodBookshelf(Block planks, int meta) {
		this.planks = planks;
		this.meta = meta;
		setHardness(1.5F);
		setStepSound(soundTypeWood);
		setCreativeTab(WoodStuff.tab);
		setBlockName(Utils.getUnlocalisedName("bookshelf_" + planks.getUnlocalizedName() + "_" + meta));
	}

	@Override
	public int getRenderType() {
		return RENDER_ID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		IIcon plankIcon = planks.getIcon(side, this.meta);
		return side != 1 && side != 0 ? renderOverlay ? overlay : plankIcon : plankIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		if (overlay == null)
			overlay = reg.registerIcon(Utils.getBlockTexture("bookshelf"));
	}

	@Override
	public Block getPlanks() {
		return planks;
	}

	@Override
	public int getMeta() {
		return meta;
	}

	@Override
	public String getName() {
		return "bookshelf";
	}
}