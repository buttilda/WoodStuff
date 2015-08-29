package ganymedes01.woodstuff;

import ganymedes01.woodstuff.lib.Reference;
import ganymedes01.woodstuff.modules.WoodModule;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static final String[] categories = { Configuration.CATEGORY_GENERAL, "Modules", "Stuff" };
	public static ConfigHandler INSTANCE = new ConfigHandler();
	public Configuration configFile;

	public void preInit(File file) {
		configFile = new Configuration(file);
	}

	public void init() {
		syncConfigs();
	}

	private void syncConfigs() {
		WoodModule module = new WoodModule("configs") {
			@Override
			public void addBlocks() {
				String[] woods = configFile.get(Configuration.CATEGORY_GENERAL, "woods", new String[0], "blockName | metadata | button | fence | gate | pressurePlate | bookshelf | chest | craftingTable \n e.g.:Forestry:planks | 2 | true | true | true | true | false | false | true").setRequiresMcRestart(true).getStringList();
				for (String wood : woods) {
					String[] data = wood.split("\\|");
					Block planks = (Block) Block.blockRegistry.getObject(data[0].trim());
					int meta = Integer.parseInt(data[1].trim());
					boolean button = Boolean.parseBoolean(data[2].trim());
					boolean fence = Boolean.parseBoolean(data[3].trim());
					boolean gate = Boolean.parseBoolean(data[4].trim());
					boolean pressurePlate = Boolean.parseBoolean(data[5].trim());
					boolean bookshelf = Boolean.parseBoolean(data[6].trim());
					boolean chest = data.length >= 8 ? Boolean.parseBoolean(data[7].trim()) : false;
					boolean craftingTable = data.length >= 9 ? Boolean.parseBoolean(data[8].trim()) : false;

					addWood(planks, meta, button, fence, gate, pressurePlate, bookshelf, chest, craftingTable);
				}
			}

			@Override
			public boolean shouldUse() {
				return true;
			}
		};

		module.addBlocks();

		for (WoodModule m : WoodModule.getModules())
			m.setEnabled(configFile.get("Modules", m.getName(), true).setRequiresMcRestart(true).getBoolean(true));

		String category = "Stuff";
		WoodStuff.button = configFile.get(category, "Button", WoodStuff.button).getBoolean();
		WoodStuff.fence = configFile.get(category, "Fence", WoodStuff.fence).getBoolean();
		WoodStuff.gate = configFile.get(category, "Gate", WoodStuff.gate).getBoolean();
		WoodStuff.pressurePlate = configFile.get(category, "Pressure Plate", WoodStuff.pressurePlate).getBoolean();
		WoodStuff.bookshelf = configFile.get(category, "Bookshelf", WoodStuff.bookshelf).getBoolean();
		WoodStuff.chest = configFile.get(category, "Chest", WoodStuff.chest).getBoolean();
		WoodStuff.craftingTable = configFile.get(category, "Crafting Table", WoodStuff.craftingTable).getBoolean();

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID))
			syncConfigs();
	}
}