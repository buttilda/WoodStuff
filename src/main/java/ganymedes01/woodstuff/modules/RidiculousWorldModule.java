package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class RidiculousWorldModule extends WoodModule {

	public RidiculousWorldModule() {
		super("RidiculousWorld");
	}

	@Override
	public void addBlocks() {
		Block block = getBlock("RidiculousWorld:RidiculousPlanks");
		for (int i = 0; i < 3; i++)
			addWood(block, i, true, true, true, true, true, true, false);
	}
}