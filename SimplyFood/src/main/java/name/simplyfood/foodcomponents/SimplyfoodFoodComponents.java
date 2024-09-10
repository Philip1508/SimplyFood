package name.simplyfood.foodcomponents;

import name.simplyfood.statuseffects.StatusEffectRegistrator;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class SimplyfoodFoodComponents {


    private static final int STOCK_BASEVALUE = 4;
    private static final int VEGETABLE_BASEVALUE = 6;
    private static final int MEAT_BASEVALUE = 8;

    private static final int BASE_TICK = 20;






    public static final FoodComponent STOCK = new FoodComponent.Builder().hunger(STOCK_BASEVALUE)
            .saturationModifier(0.3F)
            .statusEffect(quickStatuseffect(190 * BASE_TICK,0),1.0F )
            .build();

    public static final FoodComponent RAW_SOUP = new FoodComponent.Builder().hunger(STOCK_BASEVALUE)
            .saturationModifier(0.3F)
            .statusEffect(quickStatuseffect(140* BASE_TICK,0),1.0F )
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 450*20, 1), 1.0f)
            .build();

    public static final FoodComponent VEGETABLE_SOUP = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE)
            .statusEffect(quickStatuseffect(320* BASE_TICK,1),1.0F)
            .saturationModifier(0.7F).build();
    public static final FoodComponent VEGETABLE_SOUP_STOCKED = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE + STOCK_BASEVALUE)
            .statusEffect(quickStatuseffect(480*20,1),1.0F)
            .saturationModifier(0.75F).build();

    public static final FoodComponent DOUBLE_VEGETABLE_SOUP = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE*2)
            .statusEffect(quickStatuseffect(600*BASE_TICK,2),1.0F)
            .saturationModifier(0.7F).build();
    public static final FoodComponent DOUBLE_VEGETABLE_SOUP_STOCKED = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE*2 + STOCK_BASEVALUE)
            .statusEffect(quickStatuseffect(900*BASE_TICK,2),1.0F)
            .saturationModifier(0.75F).build();


    public static final FoodComponent GREAT_SOUP = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE + MEAT_BASEVALUE)
            .statusEffect(quickStatuseffect(1000*BASE_TICK,3),1.0F)
            .saturationModifier(0.7F).build();
    public static final FoodComponent GREAT_SOUP_STOCKED = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE + MEAT_BASEVALUE + STOCK_BASEVALUE)
            .statusEffect(quickStatuseffect(1500*BASE_TICK,3),1.0F)
            .saturationModifier(0.75F).build();

    public static final FoodComponent GRAND_SOUP = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE*2 + MEAT_BASEVALUE)
            .statusEffect(quickStatuseffect(1600*BASE_TICK,4),1.0F)
            .saturationModifier(0.85F).build();
    public static final FoodComponent GRAND_SOUP_STOCKED = new FoodComponent.Builder().hunger(VEGETABLE_BASEVALUE*2 + MEAT_BASEVALUE + STOCK_BASEVALUE)
            .statusEffect(quickStatuseffect(2400*BASE_TICK,4),1.0F)
            .saturationModifier(0.9F)
            .build();






    private static StatusEffectInstance quickStatuseffect(int duration, int amplifier)
    {
        return new StatusEffectInstance(StatusEffectRegistrator.NOURISHMENT_EFFECT, duration, amplifier, false, false);

    }

}
