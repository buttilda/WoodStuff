package ganymedes01.woodstuff.modules;

import net.minecraft.init.Blocks;

public class VanillaModule extends WoodModule {

	public VanillaModule() {
		super(null);
	}

	@Override
	public boolean shouldUse() {
		return true;
	}

	@Override
	public void addBlocks() {
		addWood(Blocks.planks, 1, true, true, true, true, true);
		addWood(Blocks.planks, 2, true, true, true, true, true);
		addWood(Blocks.planks, 3, true, true, true, true, true);
		addWood(Blocks.planks, 4, true, true, true, true, true);
		addWood(Blocks.planks, 5, true, true, true, true, true);
	}

	@Override
	public String getName() {
		return "Vanilla";
	}
}