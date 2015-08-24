package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class EnhancedBiomesModule extends WoodModule {

	public EnhancedBiomesModule() {
		super("enhancedbiomes");
	}

	@Override
	public void addBlocks() {
		Block block = (Block) Block.blockRegistry.getObject("enhancedbiomes:enhancedbiomes.tile.planksEB");
		for (int i = 0; i < 15; i++)
			if (i != 11)
				addWood(block, i, true, true, true, true, true, true, true);
	}
}