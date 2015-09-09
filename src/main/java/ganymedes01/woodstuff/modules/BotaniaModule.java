package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class BotaniaModule extends WoodModule {

	public BotaniaModule() {
		super("Botania");
	}

	@Override
	public void addBlocks() {
		Block livingwood = (Block) Block.blockRegistry.getObject("Botania:livingwood");
		Block dreamwood = (Block) Block.blockRegistry.getObject("Botania:dreamwood");
		addWood(livingwood, 1, true, true, true, true, true, true, true);
		addWood(dreamwood, 1, true, true, true, true, true, true, true);
	}
}
