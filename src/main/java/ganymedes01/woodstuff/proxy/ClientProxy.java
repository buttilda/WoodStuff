package ganymedes01.woodstuff.proxy;

import ganymedes01.woodstuff.blocks.BlockWoodChest;
import ganymedes01.woodstuff.client.BookshelfRenderer;
import ganymedes01.woodstuff.client.ItemWoodChestRenderer;
import ganymedes01.woodstuff.client.TileEntityWoodChestRenderer;
import ganymedes01.woodstuff.eventHandler.ClientEventHandler;
import ganymedes01.woodstuff.tileentity.TileEntityWoodChest;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		RenderingRegistry.registerBlockHandler(new BookshelfRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodChest.class, new TileEntityWoodChestRenderer());

		for (Block block : BlockWoodChest.chests)
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(block), new ItemWoodChestRenderer());
	}
}