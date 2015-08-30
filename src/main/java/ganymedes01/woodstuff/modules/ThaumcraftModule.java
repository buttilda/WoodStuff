package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ThaumcraftModule extends WoodModule {

	public ThaumcraftModule() {
		super("Thaumcraft");
	}

	@Override
	public void addBlocks() {
		Block block = (Block) Block.blockRegistry.getObject("Thaumcraft:blockWoodenDevice");
		addWood(block, 6, true, true, true, true, true, true, true);
		addWood(block, 7, true, true, true, true, true, true, true);

		addAspects();
	}

	private void addAspects() {
		ThaumcraftApi.registerObjectTag("buttonWood", new AspectList().add(Aspect.MECHANISM, 1));
		ThaumcraftApi.registerObjectTag("bookshelfWood", new AspectList().add(Aspect.TREE, 4).add(Aspect.MIND, 8).add(Aspect.CLOTH, 2));
		ThaumcraftApi.registerObjectTag("fenceWood", new AspectList().add(Aspect.TREE, 2));
		ThaumcraftApi.registerObjectTag("fencegateWood", new AspectList().add(Aspect.TREE, 4).add(Aspect.TRAVEL, 1).add(Aspect.MECHANISM, 1));
		ThaumcraftApi.registerObjectTag("pressureplateWood", new AspectList().add(Aspect.TREE, 1).add(Aspect.SENSES, 1).add(Aspect.MECHANISM, 1));
		ThaumcraftApi.registerObjectTag("chestWood", new AspectList().add(Aspect.TREE, 6).add(Aspect.VOID, 4));
		ThaumcraftApi.registerObjectTag("craftingTableWood", new AspectList().add(Aspect.CRAFT, 4));
	}
}