package ganymedes01.woodstuff.proxy;

import ganymedes01.woodstuff.client.BookshelfRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		RenderingRegistry.registerBlockHandler(new BookshelfRenderer());
	}
}