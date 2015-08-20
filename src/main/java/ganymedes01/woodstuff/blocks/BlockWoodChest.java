package ganymedes01.woodstuff.blocks;

import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.tileentity.TileEntityWoodChest;
import ganymedes01.woodstuff.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodChest extends BlockChest implements IWoodBlock {

	public static List<BlockWoodChest> chests = new ArrayList<BlockWoodChest>();

	@SideOnly(Side.CLIENT)
	private ResourceLocation textureNormal, textureLarge;
	private boolean isLargeTextureGen = false, isNormalTextureGen = false;

	private final Block planks;
	private final int meta;

	public BlockWoodChest(Block planks, int meta) {
		super(Integer.MAX_VALUE - meta);
		this.planks = planks;
		this.meta = meta;
		setHardness(2.5F);
		setStepSound(soundTypeWood);
		setCreativeTab(WoodStuff.tab);
		setBlockName(Utils.getUnlocalisedName("chest_" + planks.getUnlocalizedName().toLowerCase() + "_" + meta));
		chests.add(this);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityWoodChest();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return planks.getIcon(side, this.meta);
	}

	@SideOnly(Side.CLIENT)
	public void resetTextures() {
		isLargeTextureGen = false;
		isNormalTextureGen = false;
	}

	@SideOnly(Side.CLIENT)
	public void setTextureGenerated(boolean isLargeChest) {
		if (isLargeChest)
			isLargeTextureGen = true;
		else
			isNormalTextureGen = true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isTextureGenerated(boolean isLargeChest) {
		if (isLargeChest)
			return isLargeTextureGen;
		else
			return isNormalTextureGen;
	}

	@SideOnly(Side.CLIENT)
	public ResourceLocation getTexture(boolean isLargeChest) {
		if (textureLarge == null)
			textureLarge = Utils.getResource(Utils.getEntityTexture("chest_large_" + planks.getUnlocalizedName().toLowerCase() + "_" + meta));
		if (textureNormal == null)
			textureNormal = Utils.getResource(Utils.getEntityTexture("chest_normal_" + planks.getUnlocalizedName().toLowerCase() + "_" + meta));
		return isLargeChest ? textureLarge : textureNormal;
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
		return "chest";
	}
}