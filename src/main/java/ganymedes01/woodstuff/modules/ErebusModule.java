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
				addWood(block, i, true, true, true, true, true);
	}
}