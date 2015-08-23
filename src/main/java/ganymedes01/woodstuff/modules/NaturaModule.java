package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class NaturaModule extends WoodModule {

	public NaturaModule() {
		super("Natura");
	}

	@Override
	public void addBlocks() {
		Block planks = (Block) Block.blockRegistry.getObject("Natura:planks");
		for (int i = 0; i < 13; i++)
			addWood(planks, i, false, false, false, false, false, true, false);
	}
}