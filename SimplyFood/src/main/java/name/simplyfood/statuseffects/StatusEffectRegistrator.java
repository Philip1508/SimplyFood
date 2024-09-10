package name.simplyfood.statuseffects;

import name.simplyfood.SimplyAstonishingFood;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static name.simplyfood.statuseffects.StatusEffectTypes.NOURISHMENT;
import static name.simplyfood.statuseffects.StatusEffectTypes.REJUVENATION;

public class StatusEffectRegistrator {

    public static StatusEffect NOURISHMENT_EFFECT;
    public static StatusEffect REJUVENATION_EFFECT;

    public static void initializeAndRegister()
    {

        NOURISHMENT_EFFECT = Registry.register(Registries.STATUS_EFFECT,
                new Identifier(SimplyAstonishingFood.MOD_ID, "nourishment"),
                new SimplyFoodsStatusEffect(StatusEffectCategory.BENEFICIAL,9728317, NOURISHMENT));

        REJUVENATION_EFFECT = Registry.register(Registries.STATUS_EFFECT,
                new Identifier(SimplyAstonishingFood.MOD_ID, "rejuvenation"),
                new SimplyFoodsStatusEffect(StatusEffectCategory.BENEFICIAL,9728317, REJUVENATION));

    }
}
