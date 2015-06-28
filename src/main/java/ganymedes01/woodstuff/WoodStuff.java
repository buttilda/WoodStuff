package ganymedes01.woodstuff;

import ganymedes01.woodstuff.client.BookshelfRenderer;
import ganymedes01.woodstuff.lib.Reference;
import ganymedes01.woodstuff.modules.BiomesOPlentyModule;
import ganymedes01.woodstuff.modules.DendrologyModule;
import ganymedes01.woodstuff.modules.ErebusModule;
import ganymedes01.woodstuff.modules.ExtraBiomesXLModule;
import ganymedes01.woodstuff.modules.ForestryModule;
import ganymedes01.woodstuff.modules.HighlandsModule;
import ganymedes01.woodstuff.modules.VanillaModule;
import ganymedes01.woodstuff.modules.WoodModule;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES)
public class WoodStuff {

	@Instance(Reference.MOD_ID)
	public static WoodStuff instance;

	public static CreativeTabs tab = new CreativeTabs(Reference.MOD_ID) {

		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.planks);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		WoodModule.registerModule(new VanillaModule());
		WoodModule.registerModule(new ForestryModule());
		WoodModule.registerModule(new ExtraBiomesXLModule());
		WoodModule.registerModule(new BiomesOPlentyModule());
		WoodModule.registerModule(new HighlandsModule());
		WoodModule.registerModule(new ErebusModule());
		WoodModule.registerModule(new DendrologyModule());

		ConfigHandler.INSTANCE.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		WoodModule.addModulesBlocks();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		RenderingRegistry.registerBlockHandler(new BookshelfRenderer());
	}

	@EventHandler
	public void processIMCRequests(IMCEvent event) {
	}
}