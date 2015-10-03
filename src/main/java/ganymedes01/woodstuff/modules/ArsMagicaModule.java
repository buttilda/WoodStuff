package ganymedes01.woodstuff.modules;

import net.minecraft.block.Block;

public class ArsMagicaModule extends WoodModule {

	public ArsMagicaModule() {
		super("arsmagica2");
	}

	@Override
	public void addBlocks() {
		Block wood = getBlock("arsmagica2:planksWitchwood");
		addWood(wood, 0, true, true, true, true, true, true, true);
	}
}
