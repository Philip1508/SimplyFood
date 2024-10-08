package name.simplyfood;

import name.simplyfood.foodcomponents.SimplyfoodFoodComponents;
import name.simplyfood.items.ItemRegistrator;
import name.simplyfood.statuseffects.StatusEffectRegistrator;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplyAstonishingFood implements ModInitializer {
	public static final String MOD_ID = "simply-food";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Initializing Status Effects");
		StatusEffectRegistrator.initializeAndRegister();



		LOGGER.info("Initializing Items");
		ItemRegistrator.initializeAndRegister();

		LOGGER.info("Hello Fabric world!");
	}
}