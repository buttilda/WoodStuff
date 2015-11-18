package ganymedes01.woodstuff.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.DefaultOverlayHandler;
import ganymedes01.woodstuff.gui.GuiCraftingTable;
import ganymedes01.woodstuff.lib.Reference;

public class NEIWoodStuffConfig implements IConfigureNEI {

	@Override
	public String getName() {
		return Reference.MOD_NAME;
	}

	@Override
	public String getVersion() {
		return Reference.VERSION_NUMBER;
	}

	@Override
	public void loadConfig() {
		API.registerGuiOverlay(GuiCraftingTable.class, "crafting");
		API.registerGuiOverlayHandler(GuiCraftingTable.class, new DefaultOverlayHandler(), "crafting");
	}
}