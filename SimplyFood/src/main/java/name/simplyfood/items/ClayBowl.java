package name.simplyfood.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ClayBowl extends Item {

    public ClayBowl(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack clayBowl = user.getStackInHand(hand);

        BlockHitResult raycastedBlock = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);

        if (world.canPlayerModifyAt(user, raycastedBlock.getBlockPos())
                && world.getFluidState(raycastedBlock.getBlockPos()).isIn(FluidTags.WATER))
        {
            world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0f, 0.5f);
            world.emitGameEvent(user, GameEvent.FLUID_PICKUP, raycastedBlock.getBlockPos());
            return  TypedActionResult.success(fillBowl(clayBowl, user, new ItemStack(ItemRegistrator.FILLED_BOWL)), world.isClient());
        }

        return  TypedActionResult.pass(clayBowl);

    }


    protected  ItemStack fillBowl(ItemStack clayBowl, PlayerEntity player, ItemStack filledBowl)
    {
        return ItemUsage.exchangeStack(clayBowl, player, filledBowl);
    }

}
