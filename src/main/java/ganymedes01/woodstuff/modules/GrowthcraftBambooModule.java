package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class GrowthcraftBamboo extends WoodModule {

	public GrowthcraftBambooModule() {
		super("Growthcraft|Bamboo");
	}

	@Override
	public void addBlocks() {
		Block planks = getBlock("Growthcraft|Bamboo:grc.bambooBlock");
		addWood(planks, 0, true, false, false, true, true, true, true);
	}
}
