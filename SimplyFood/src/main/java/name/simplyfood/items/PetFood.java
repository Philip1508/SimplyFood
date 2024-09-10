package name.simplyfood.items;

import name.simplyfood.statuseffects.StatusEffectRegistrator;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PetFood extends Item {


    public PetFood(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack petfood = user.getStackInHand(hand);


        if (hand.equals(Hand.MAIN_HAND))
        {
            if (user.getOffHandStack().getItem().equals(Items.MAGMA_CREAM))
            {
                NbtCompound nbtCompound = petfood.getOrCreateNbt();

                if (nbtCompound.getBoolean("magmacreamed"))
                {
                    return  TypedActionResult.pass(petfood);
                }

                world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.5f, 0.5f);
                user.getOffHandStack().decrement(1);

                nbtCompound.putBoolean("magmacreamed", true);

                return TypedActionResult.success(petfood);



            }

        }

        return  TypedActionResult.pass(petfood);

    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        if (user.getWorld().isClient())
        {
            return ActionResult.PASS;
        }

        if (entity instanceof AnimalEntity animal)
        {
            animal.heal((float) (4 + (animal.getMaxHealth() * 0.08)));

            StatusEffectInstance rejuvenation = new StatusEffectInstance(StatusEffectRegistrator.REJUVENATION_EFFECT,
                    18000, 0, false, false);
            animal.addStatusEffect(rejuvenation, entity);

            NbtCompound nbtCompound = stack.getOrCreateNbt();

            if (nbtCompound.getBoolean("magmacreamed"))
            {
                StatusEffectInstance fireResistance = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 18000, 0);
                animal.addStatusEffect(fireResistance, entity);
            }


            stack.setDamage(stack.getDamage() + 1);
            if (stack.getDamage() >= stack.getMaxDamage())
            {
                stack.decrement(1);
                user.giveItemStack(new ItemStack(ItemRegistrator.CLAY_BOWL));
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    protected  ItemStack empty(ItemStack petfood, PlayerEntity player, ItemStack clayBowl)
    {
        return ItemUsage.exchangeStack(petfood, player, clayBowl);
    }



    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        tooltip.add(Text.translatable("item.simply-food.petfood.health", 21, 15));

        if (stack.getOrCreateNbt().getBoolean("magmacreamed"))
        {
            tooltip.add(Text.translatable("item.simply-food.petfood.magmacreamed"));
        }
        else
        {
            tooltip.add(Text.translatable("item.simply-food.petfood.magmacreamable"));
        }



    }

}
