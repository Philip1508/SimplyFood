package name.simplyfood.items;

import com.mojang.datafixers.util.Pair;
import name.simplyfood.statuseffects.SimplyFoodsStatusEffect;
import name.simplyfood.statuseffects.StatusEffectRegistrator;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoupItem extends Item {

    public static final String HUNGER_POINTS = "hunger_points";
    public static final String MINUTE_DURATION = "minute_duration";
    public static final String SECONDS_DURATION = "second_duration";
    public static final String INITIALIZED = "initiliazed";

    public SoupItem(Settings settings) {
        super(settings);
    }

    // This can be "unoptimized" as this is only called once, per craft.
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        NbtCompound nbt = stack.getOrCreateNbt();

        FoodComponent foodComponent = this.getFoodComponent();

        if (foodComponent == null || world.isClient())  {return;}

        List<Pair<StatusEffectInstance, Float>> statusEffects = foodComponent.getStatusEffects();

        statusEffects.forEach(pair -> {
            StatusEffectInstance effect = pair.getFirst();

            if (effect.getEffectType().equals(StatusEffectRegistrator.NOURISHMENT_EFFECT))
            {
                int duration = effect.getDuration();
                int amplifier = effect.getAmplifier();

                // ToDo; Externalize Baserate  Timing

                int rate = SimplyFoodsStatusEffect.NOURISHMENT_TIMING_SECONDS - amplifier;

                int secondsRate = duration / 20;
                int seconds = duration / 20;

                int minutes = 0;

                
                while (seconds >= 60)
                {
                    ++minutes;
                    seconds -= 60;
                }

                int food = (secondsRate / rate) >> 1;

                nbt.putInt(HUNGER_POINTS, food);
                nbt.putString(MINUTE_DURATION, String.valueOf(minutes));

                String secondsString = String.valueOf(seconds);
                if (seconds == 0)
                {
                    secondsString = "00";
                }
                nbt.putString(SECONDS_DURATION, secondsString);
                nbt.putBoolean(INITIALIZED, true);
            }



        });


    }


    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        NbtCompound nbt = stack.getOrCreateNbt();

        if (!nbt.getBoolean(INITIALIZED) && entity instanceof PlayerEntity player)
        {
            this.onCraft(stack, world, player);
        }

    }



    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user)
    {
        ItemStack clayBowl = super.finishUsing(stack, world, user);

        if (user instanceof PlayerEntity)
        {
            return new ItemStack(ItemRegistrator.CLAY_BOWL);
        }

        return ItemStack.EMPTY;

    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        NbtCompound nbt = stack.getOrCreateNbt();

        int food = nbt.getInt(HUNGER_POINTS);
        String minutes = nbt.getString(MINUTE_DURATION);
        String seconds = nbt.getString(SECONDS_DURATION);





        if (nbt.getBoolean(INITIALIZED))
        {
            tooltip.add(Text.translatable("item.simply-food.soup.stats", food, minutes, seconds));
        }


    }

}
