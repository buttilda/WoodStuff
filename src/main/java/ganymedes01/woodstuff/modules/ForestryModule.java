package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class ForestryModule extends WoodModule {

	public ForestryModule() {
		super("Forestry");
	}

	@Override
	public void addBlocks() {
		Block block = getBlock("Forestry:planks");
		for (int i = 0; i < 16; i++)
			addWood(block, i, true, false, true, true, true, true, true);
		block = getBlock("Forestry:planks2");
		for (int i = 0; i < 13; i++)
			addWood(block, i, true, false, true, true, true, true, true);
	}
}