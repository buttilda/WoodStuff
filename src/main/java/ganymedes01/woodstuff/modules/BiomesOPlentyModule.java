package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class BiomesOPlentyModule extends WoodModule {

	public BiomesOPlentyModule() {
		super("BiomesOPlenty");
	}

	@Override
	public void addBlocks() {
		Block block = getBlock("BiomesOPlenty:planks");
		for (int i = 0; i < 15; i++)
			addWood(block, i, true, true, true, true, true, true, true);
	}
}