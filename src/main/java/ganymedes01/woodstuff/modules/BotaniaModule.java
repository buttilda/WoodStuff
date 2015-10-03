package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class BotaniaModule extends WoodModule {

	public BotaniaModule() {
		super("Botania");
	}

	@Override
	public void addBlocks() {
		Block livingwood = getBlock("Botania:livingwood");
		Block dreamwood = getBlock("Botania:dreamwood");
		addWood(livingwood, 1, true, true, true, true, true, true, true);
		addWood(dreamwood, 1, true, true, true, true, true, true, true);
	}
}
