package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class AetherModule extends WoodModule {

	public AetherModule() {
		super("aether");
	}

	@Override
	public void addBlocks() {
		Block wood = getBlock("aether:skyrootPlank");
		addWood(wood, 0, true, false, false, true, false, false, false);
	}
}
