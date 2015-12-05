package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class TotemicModule extends WoodModule {

	public TotemicModule() {
		super("totemic");
	}

	@Override
	public void addBlocks() {
		Block planks = getBlock("totemic:redCedarPlank");
		addWood(planks, 0, true, true, true, true, true, true, true);
	}
}