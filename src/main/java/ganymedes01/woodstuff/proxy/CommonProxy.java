package ganymedes01.woodstuff.proxy;

import ganymedes01.woodstuff.ConfigHandler;
import ganymedes01.woodstuff.modules.BiomesOPlentyModule;
import ganymedes01.woodstuff.modules.BotaniaModule;
import ganymedes01.woodstuff.modules.DendrologyModule;
import ganymedes01.woodstuff.modules.ErebusModule;
import ganymedes01.woodstuff.modules.ExtraBiomesXLModule;
import ganymedes01.woodstuff.modules.ForestryModule;
import ganymedes01.woodstuff.modules.HighlandsModule;
import ganymedes01.woodstuff.modules.ThaumcraftModule;
import ganymedes01.woodstuff.modules.VanillaModule;
import ganymedes01.woodstuff.modules.WoodModule;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		WoodModule.registerModule(new VanillaModule());
		WoodModule.registerModule(new ForestryModule());
		WoodModule.registerModule(new ExtraBiomesXLModule());
		WoodModule.registerModule(new BiomesOPlentyModule());
		WoodModule.registerModule(new HighlandsModule());
		WoodModule.registerModule(new ErebusModule());
		WoodModule.registerModule(new DendrologyModule());
		WoodModule.registerModule(new BotaniaModule());
		WoodModule.registerModule(new ThaumcraftModule());

		ConfigHandler.INSTANCE.preInit(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
	}

	public void init(FMLInitializationEvent event) {
		ConfigHandler.INSTANCE.init();
		WoodModule.addModulesBlocks();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}