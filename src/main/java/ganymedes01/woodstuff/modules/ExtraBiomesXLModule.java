package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class ExtraBiomesXLModule extends WoodModule {

	public ExtraBiomesXLModule() {
		super("ExtrabiomesXL");
	}

	@Override
	public void addBlocks() {
		Block block = (Block) Block.blockRegistry.getObject("ExtrabiomesXL:planks");
		for (int i = 0; i < 9; i++)
			addWood(block, i, true, false, false, true, true, true, true);
	}
}