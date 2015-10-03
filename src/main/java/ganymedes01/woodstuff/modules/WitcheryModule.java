package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class WitcheryModule extends WoodModule {

	public WitcheryModule() {
		super("witchery");
	}

	@Override
	public void addBlocks() {
		Block wood = getBlock("witchery:witchwood");
		for (int i = 0; i < 3; i++)
			addWood(wood, i, true, true, true, true, true, true, true);
	}
}
