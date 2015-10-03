package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class ErebusModule extends WoodModule {

	public ErebusModule() {
		super("erebus");
	}

	@Override
	public void addBlocks() {
		Block block = (Block) Block.blockRegistry.getObject("erebus:planks");
		for (int i = 0; i < 11; i++)
			if (i != 6)
				addWood(block, i, true, false, false, true, true, true, true);

		block = (Block) Block.blockRegistry.getObject("erebus:planks_scorched");
		addWood(block, 0, true, true, true, true, true, true, true);

		block = (Block) Block.blockRegistry.getObject("erebus:planks_varnished");
		addWood(block, 0, true, true, true, true, true, true, true);

		block = (Block) Block.blockRegistry.getObject("erebus:petrifiedWoodPlanks");
		addWood(block, 0, true, true, true, true, true, false, false);
	}
}