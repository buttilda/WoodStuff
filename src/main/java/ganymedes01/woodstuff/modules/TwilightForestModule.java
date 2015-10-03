package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class TwilightForestModule extends WoodModule {

	public TwilightForestModule() {
		super("TwilightForest");
	}

	@Override
	public void addBlocks() {
		Block wood = getBlock("TwilightForest:tile.TFTowerStone");
		addWood(wood, 0, true, true, true, true, true, true, true);
	}
}
