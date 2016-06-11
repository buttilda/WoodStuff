package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class FossilsAndArchaeology extends WoodModule {

	public FossilsAndArchaeologyModule() {
		super("fossil");
	}

	@Override
	public void addBlocks() {
		Block planks = getBlock("fossil:palaeoraphePlanks");
		addWood(planks, 0, true, true, true, true, true, true, true);
	}
}