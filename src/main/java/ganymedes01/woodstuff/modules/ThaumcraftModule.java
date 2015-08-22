package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class ThaumcraftModule extends WoodModule {

	public ThaumcraftModule() {
		super("Thaumcraft");
	}

	@Override
	public void addBlocks() {
		Block block = (Block) Block.blockRegistry.getObject("Thaumcraft:blockWoodenDevice");
		addWood(block, 6, true, true, true, true, true, true, true);
		addWood(block, 7, true, true, true, true, true, true, true);
	}
}