package ganymedes01.woodstuff.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;

public class TEUtils {

	public static boolean isThermalExpansionLoaded = Loader.isModLoaded("ThermalExpansion");

	public static void registerSawmillRecipe(int energy, ItemStack input, ItemStack output) {
		registerSawmillRecipe(energy, input, output, null, 0);
	}

	public static void registerSawmillRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int chance) {
		if (!isThermalExpansionLoaded)
			return;

		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setInteger("energy", energy);
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("primaryOutput", new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag("input"));
		primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));

		if (secondaryOutput != null) {
			toSend.setTag("secondaryOutput", new NBTTagCompound());
			secondaryOutput.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
			toSend.setInteger("secondaryChance", chance);
		}

		FMLInterModComms.sendMessage("ThermalExpansion", "SawmillRecipe", toSend);
	}
}