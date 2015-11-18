package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class ForestryModule extends WoodModule {

	public ForestryModule() {
		super("Forestry");
	}

	@Override
	public void addBlocks() {
		Block block = getBlock("Forestry:planks");
		for (int i = 0; i < 29; i++)
			addWood(block, i, true, false, true, true, true, true, true);
	}
}