package name.simplyfood.items;


import name.simplyfood.SimplyAstonishingFood;
import name.simplyfood.foodcomponents.SimplyfoodFoodComponents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistrator {





    public static void initializeAndRegister()
    {
        Registry.register(Registries.ITEM, new Identifier(SimplyAstonishingFood.MOD_ID, "basic_stew"), basicStew);

        Registry.register(Registries.ITEM, quickIdent("stock"), new StewItem(new FabricItemSettings().food(SimplyfoodFoodComponents.STOCK)));

        Registry.register(Registries.ITEM, quickIdent("animal-bones"), new Item(new FabricItemSettings()));

        Registry.register(Registries.ITEM, quickIdent("raw-vegetable-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("vegetable-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.VEGETABLE_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("vegetable-soup-stocked"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.VEGETABLE_SOUP_STOCKED)));

        Registry.register(Registries.ITEM, quickIdent("raw-nourishing-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("nourishing-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.DOUBLE_VEGETABLE_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("nourishing-soup-stocked"), new StewItem(new FabricItemSettings().food(SimplyfoodFoodComponents.DOUBLE_VEGETABLE_SOUP_STOCKED)));

        Registry.register(Registries.ITEM, quickIdent("raw-great-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("great-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GREAT_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("great-soup-stocked"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GREAT_SOUP_STOCKED)));

        Registry.register(Registries.ITEM, quickIdent("raw-grand-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("grand-soup"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GRAND_SOUP)));
        Registry.register(Registries.ITEM, quickIdent("grand-soup-stocked"), new StewItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GRAND_SOUP_STOCKED)));


    }

    private static Identifier quickIdent(String path)
    {
        return new Identifier(SimplyAstonishingFood.MOD_ID, path);
    }
}
