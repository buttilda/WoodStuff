package ganymedes01.woodstuff.client;

import ganymedes01.woodstuff.blocks.BlockWoodChest;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemWoodChestRenderer implements IItemRenderer {

	public static final ItemWoodChestRenderer INSTANCE = new ItemWoodChestRenderer();

	private final ModelChest model = new ModelChest();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type != ItemRenderType.FIRST_PERSON_MAP;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack stack, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object... data) {
		BlockWoodChest chest = (BlockWoodChest) Block.getBlockFromItem(stack.getItem());

		switch (type) {
			case ENTITY:
				renderChest(chest, 0.5F, 0.5F, 0.5F);
				break;
			case EQUIPPED:
				renderChest(chest, 1.0F, 1.0F, 1.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				renderChest(chest, 1.0F, 1.0F, 1.0F);
				break;
			case INVENTORY:
				renderChest(chest, 0.0F, 0.075F, 0.0F);
				break;
			default:
				break;
		}
	}

	private void renderChest(BlockWoodChest block, float x, float y, float z) {
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glRotatef(-90, 0, 1, 0);

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(TileEntityWoodChestRenderer.getChestTexture(block, true));

		model.renderAll();

		GL11.glPopMatrix();
	}
}