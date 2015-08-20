package ganymedes01.woodstuff.eventHandler;

import ganymedes01.woodstuff.blocks.BlockWoodChest;
import net.minecraftforge.client.event.TextureStitchEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientEventHandler {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void stitchEventPost(TextureStitchEvent.Post event) {
		if (event.map.getTextureType() == 1)
			for (BlockWoodChest chest : BlockWoodChest.chests)
				chest.resetTextures();
	}
}