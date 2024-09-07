package name.simplyfood.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;

public class SimplyFoodsStatusEffect extends StatusEffect {


    private final StatusEffectTypes subtype;

    protected SimplyFoodsStatusEffect(StatusEffectCategory category, int color, StatusEffectTypes type) {
        super(category, color);
        this.subtype = type;
    }



    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {

        // If the target isn't a player do nothing; If the target is a Player bind him to the corresponding variable
        // The entire calculation can be skipped on the client.
        if (entity.getWorld().isClient() || !(entity instanceof PlayerEntity player))
        {
            return;
        }


        HungerManager hungerManager = player.getHungerManager();




        // Actual Application of Effect.
        switch (subtype)
        {
            case NOURISHMENT ->
            {
                if (hungerManager.getFoodLevel() < 19)
                {
                    // This is made this way in order to not tamper with the saturation value.
                    hungerManager.setFoodLevel(hungerManager.getFoodLevel()+1);
                }

                if (hungerManager.getFoodLevel() >= 15)
                {
                    player.heal(0.25f);
                }

            }

            case REJUVENATION -> {
                player.heal(1.0f);
                return;
            }

            case REPLENISHMENT -> {
                return;
            }

            default -> {
                return;
            }


        }


    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {

        int tickSecond = 20; // 20 Ticks = 1 Second
        int baseRate = 11; // Base Rate at 11 Seconds. Stronger Stews reduce this in the final calculation.

        switch (subtype)
        {
            // See Balance Table.
            case NOURISHMENT -> {
                return duration % (tickSecond * (baseRate-amplifier) ) == 0;
            }

            case REJUVENATION -> {
                return duration % (tickSecond * 8) == 0;
            }

            // When in doubt; Do Nothing!
            default -> {return false;}
        }

    }




    @Override
    public boolean isBeneficial()
    {
        return true;
    }




}
