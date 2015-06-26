package ganymedes01.woodstuff;

import ganymedes01.woodstuff.lib.Reference;
import ganymedes01.woodstuff.modules.WoodModule;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static ConfigHandler INSTANCE = new ConfigHandler();
	public Configuration configFile;

	public void init(File file) {
		configFile = new Configuration(file);

		syncConfigs();
	}

	private void syncConfigs() {
		WoodModule module = new WoodModule("configs") {
			@Override
			public void addBlocks() {
				String[] woods = configFile.get(Configuration.CATEGORY_GENERAL, "woods", new String[0], "blockName | metadata | button | fence | gate | pressurePlate | bookshelf \n e.g.:Forestry:planks | 2 | true | true | true | true | false").setRequiresMcRestart(true).getStringList();
				for (String wood : woods) {
					String[] data = wood.split("\\|");
					Block planks = (Block) Block.blockRegistry.getObject(data[0].trim());
					int meta = Integer.parseInt(data[1].trim());
					boolean button = Boolean.getBoolean(data[2].trim());
					boolean fence = Boolean.getBoolean(data[3].trim());
					boolean gate = Boolean.getBoolean(data[4].trim());
					boolean pressurePlate = Boolean.getBoolean(data[5].trim());
					boolean bookshelf = Boolean.getBoolean(data[6].trim());

					addWood(planks, meta, button, fence, gate, pressurePlate, bookshelf);
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

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID))
			syncConfigs();
	}
}