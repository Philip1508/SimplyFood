package name.simplyfood.items;


import name.simplyfood.SimplyAstonishingFood;
import name.simplyfood.foodcomponents.SimplyfoodFoodComponents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemRegistrator {

    public static ItemGroup SIMPLY_FOOD;

    public static Item RAW_CLAY_BOWL;
    public static Item CLAY_BOWL;
    public static Item FILLED_BOWL;
    public static Item RAW_STOCK;
    public static Item STOCK;

    public static Item RAW_VEGETABLE_SOUP;
    public static Item VEGETABLE_SOUP;
    public static Item RAW_VEGETABLE_SOUP_STOCKED;
    public static Item VEGETABLE_SOUP_STOCKED;


    public static Item RAW_NOURISHING_SOUP;
    public static Item NOURISHING_SOUP;
    public static Item RAW_NOURISHING_SOUP_STOCKED;
    public static Item NOURISHING_SOUP_STOCKED;

    public static Item RAW_GREAT_SOUP;
    public static Item GREAT_SOUP;
    public static Item RAW_GREAT_SOUP_STOCKED;
    public static Item GREAT_SOUP_STOCKED;

    public static Item RAW_GRAND_SOUP;
    public static Item GRAND_SOUP;
    public static Item RAW_GRAND_SOUP_STOCKED;
    public static Item GRAND_SOUP_STOCKED;

    public static Item RAW_PETFOOD;
    public static Item PETFOOD;


    public static void initializeAndRegister()
    {


        RAW_CLAY_BOWL = Registry.register(Registries.ITEM, quickIdent("raw-claybowl"), new Item(new FabricItemSettings()));

        // The Variables are needed in those cases in order to do the logical item swap when filling the bowl.
        CLAY_BOWL = Registry.register(Registries.ITEM, quickIdent("claybowl"), new ClayBowl(new FabricItemSettings()));
        FILLED_BOWL = Registry.register(Registries.ITEM, quickIdent("filled-claybowl"), new Item(new FabricItemSettings().maxCount(1)));

        RAW_STOCK = Registry.register(Registries.ITEM, quickIdent("raw-stock"), new SoupItem(new FabricItemSettings().food(SimplyfoodFoodComponents.RAW_SOUP)));
        STOCK = Registry.register(Registries.ITEM, quickIdent("stock"), new SoupItem(new FabricItemSettings().food(SimplyfoodFoodComponents.STOCK)));


        RAW_VEGETABLE_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-vegetable-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        VEGETABLE_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-vegetable-soup-stocked"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        RAW_VEGETABLE_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("vegetable-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.VEGETABLE_SOUP)));
        VEGETABLE_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("vegetable-soup-stocked"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.VEGETABLE_SOUP_STOCKED)));

        RAW_NOURISHING_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-nourishing-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        NOURISHING_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-nourishing-soup-stocked"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        RAW_NOURISHING_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("nourishing-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.DOUBLE_VEGETABLE_SOUP)));
        NOURISHING_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("nourishing-soup-stocked"), new SoupItem(new FabricItemSettings().food(SimplyfoodFoodComponents.DOUBLE_VEGETABLE_SOUP_STOCKED)));

        RAW_GREAT_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-great-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        GREAT_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-great-soup-stocked"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        RAW_GREAT_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("great-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GREAT_SOUP)));
        GREAT_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("great-soup-stocked"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GREAT_SOUP_STOCKED)));

        RAW_GRAND_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-grand-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        GRAND_SOUP = Registry.register(Registries.ITEM, quickIdent("raw-grand-soup-stocked"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.RAW_SOUP)));
        RAW_GRAND_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("grand-soup"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GRAND_SOUP)));
        GRAND_SOUP_STOCKED = Registry.register(Registries.ITEM, quickIdent("grand-soup-stocked"), new SoupItem(new FabricItemSettings().maxCount(1).food(SimplyfoodFoodComponents.GRAND_SOUP_STOCKED)));

        // ToDo; Pet Food / Pet Food Fire Resistance
        RAW_PETFOOD = Registry.register(Registries.ITEM, quickIdent("raw-petfood"), new Item(new FabricItemSettings().maxCount(1)));
        PETFOOD = Registry.register(Registries.ITEM, quickIdent("petfood"), new PetFood(new FabricItemSettings().maxCount(1).maxDamage(4)));





        registerCreativeGroup();
        Registry.register(Registries.ITEM_GROUP, quickIdent("simply-food-group"), SIMPLY_FOOD);


    }

    private static Identifier quickIdent(String path)
    {
        return new Identifier(SimplyAstonishingFood.MOD_ID, path);
    }


    // ToDo; There must be a better solution than this...
    private static void registerCreativeGroup()
    {
        SIMPLY_FOOD = FabricItemGroup.builder()
            .displayName(Text.translatable("creative.group.simply-food"))
                .icon(() -> new ItemStack(RAW_STOCK))
                .entries((context, entries) -> {
                    entries.add(RAW_CLAY_BOWL);
                    entries.add(CLAY_BOWL);
                    entries.add(FILLED_BOWL);
                    entries.add(RAW_STOCK);
                    entries.add(STOCK);

                    entries.add(RAW_VEGETABLE_SOUP);
                    entries.add(RAW_VEGETABLE_SOUP_STOCKED);
                    entries.add(VEGETABLE_SOUP);
                    entries.add(VEGETABLE_SOUP_STOCKED);


                    entries.add(RAW_NOURISHING_SOUP);
                    entries.add(RAW_NOURISHING_SOUP_STOCKED);
                    entries.add(NOURISHING_SOUP);
                    entries.add(NOURISHING_SOUP_STOCKED);

                    entries.add(RAW_GREAT_SOUP);
                    entries.add(RAW_GREAT_SOUP_STOCKED);
                    entries.add(GREAT_SOUP);
                    entries.add(GREAT_SOUP_STOCKED);

                    entries.add(RAW_GRAND_SOUP);
                    entries.add(RAW_GRAND_SOUP_STOCKED);
                    entries.add(GRAND_SOUP);
                    entries.add(GRAND_SOUP_STOCKED);


                    entries.add(RAW_PETFOOD);
                    entries.add(PETFOOD);
                })
            .build();

    }

}
