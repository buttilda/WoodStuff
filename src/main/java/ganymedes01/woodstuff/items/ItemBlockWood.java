package ganymedes01.woodstuff.items;

import ganymedes01.woodstuff.IWoodBlock;
import ganymedes01.woodstuff.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockWood extends ItemBlock {

	public ItemBlockWood(Block block) {
		super(block);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (field_150939_a instanceof IWoodBlock) {
			IWoodBlock wood = (IWoodBlock) field_150939_a;
			ItemStack woodStack = new ItemStack(wood.getPlanks(), 1, wood.getMeta());
			if (woodStack.getItem() != null) {
				String woodName = woodStack.getItem().getItemStackDisplayName(woodStack);
				return String.format(StatCollector.translateToLocal("tile." + Reference.MOD_ID + "." + wood.getName() + ".name"), woodName);
			}
		}
		return super.getItemStackDisplayName(stack);
	}
}