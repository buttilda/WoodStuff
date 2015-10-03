package ganymedes01.woodstuff.proxy;

import ganymedes01.woodstuff.ConfigHandler;
import ganymedes01.woodstuff.WoodStuff;
import ganymedes01.woodstuff.gui.ContainerCraftingTable;
import ganymedes01.woodstuff.gui.GuiCraftingTable;
import ganymedes01.woodstuff.modules.AetherModule;
import ganymedes01.woodstuff.modules.ArsMagicaModule;
import ganymedes01.woodstuff.modules.BiomesOPlentyModule;
import ganymedes01.woodstuff.modules.BotaniaModule;
import ganymedes01.woodstuff.modules.DendrologyModule;
import ganymedes01.woodstuff.modules.EnhancedBiomesModule;
import ganymedes01.woodstuff.modules.ErebusModule;
import ganymedes01.woodstuff.modules.ExtraBiomesXLModule;
import ganymedes01.woodstuff.modules.ForestryModule;
import ganymedes01.woodstuff.modules.HighlandsModule;
import ganymedes01.woodstuff.modules.NaturaModule;
import ganymedes01.woodstuff.modules.RidiculousWorldModule;
import ganymedes01.woodstuff.modules.ThaumcraftModule;
import ganymedes01.woodstuff.modules.TwilightForestModule;
import ganymedes01.woodstuff.modules.VanillaModule;
import ganymedes01.woodstuff.modules.WitcheryModule;
import ganymedes01.woodstuff.modules.WoodModule;
import ganymedes01.woodstuff.tileentity.TileEntityWoodChest;
import ganymedes01.woodstuff.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

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
		WoodModule.registerModule(new NaturaModule());
		WoodModule.registerModule(new EnhancedBiomesModule());
		WoodModule.registerModule(new RidiculousWorldModule());
		WoodModule.registerModule(new TwilightForestModule());
		WoodModule.registerModule(new WitcheryModule());
		WoodModule.registerModule(new ArsMagicaModule());
		WoodModule.registerModule(new AetherModule());

		ConfigHandler.INSTANCE.preInit(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
		NetworkRegistry.INSTANCE.registerGuiHandler(WoodStuff.instance, this);
	}

	public void init(FMLInitializationEvent event) {
		ConfigHandler.INSTANCE.init();
		WoodModule.addModulesBlocks();
		GameRegistry.registerTileEntity(TileEntityWoodChest.class, Utils.getUnlocalisedName("chest"));
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				return new ContainerCraftingTable(player.inventory, world, x, y, z);
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 0:
				return new GuiCraftingTable(player.inventory, world, x, y, z);
			default:
				return null;
		}
	}
}