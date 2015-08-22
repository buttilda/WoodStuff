package ganymedes01.woodstuff.blocks;

import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodCraftingTable extends BlockWorkbench implements IWoodBlock {

	public static final int RENDER_ID = RenderingRegistry.getNextAvailableRenderId();

	@SideOnly(Side.CLIENT)
	private IIcon overlayFront, overlayTop, overlaySide;
	@SideOnly(Side.CLIENT)
	public static boolean renderOverlay;

	private final Block planks;
	private final int meta;

	public BlockWoodCraftingTable(Block planks, int meta) {
		this.planks = planks;
		this.meta = meta;
		setHardness(2.5F);
		setStepSound(soundTypeWood);
		setCreativeTab(WoodStuff.tab);
		setBlockName(Utils.getUnlocalisedName("crafting_table_" + planks.getUnlocalizedName() + "_" + meta));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			player.openGui(WoodStuff.instance, 0, world, x, y, z);
			return true;
		}
	}

	@Override
	public int getRenderType() {
		return RENDER_ID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (!renderOverlay)
			return planks.getIcon(side, this.meta);
		return side == 1 ? overlayTop : side == 0 ? planks.getIcon(side, this.meta) : side != 2 && side != 4 ? overlaySide : overlayFront;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		overlayFront = reg.registerIcon(Utils.getBlockTexture("crafting_table_front"));
		overlaySide = reg.registerIcon(Utils.getBlockTexture("crafting_table_side"));
		overlayTop = reg.registerIcon(Utils.getBlockTexture("crafting_table_top"));
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
		return "crafting_table";
	}
}