package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class HighlandsModule extends WoodModule {

	public HighlandsModule() {
		super("Highlands");
	}

	@Override
	public void addBlocks() {
		Block block = (Block) Block.blockRegistry.getObject("Highlands:hl_woodPlanks");
		for (int i = 0; i < 4; i++)
			addWood(block, i, true, true, true, true, true, true);
	}
}