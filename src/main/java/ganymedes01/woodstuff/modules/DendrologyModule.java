package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class DendrologyModule extends WoodModule {

	public DendrologyModule() {
		super("dendrology");
	}

	@Override
	public void addBlocks() {
		Block block = (Block) Block.blockRegistry.getObject("dendrology:wood0");
		for (int i = 0; i < 13; i++)
			addWood(block, i, true, true, true, true, true, true);
	}
}