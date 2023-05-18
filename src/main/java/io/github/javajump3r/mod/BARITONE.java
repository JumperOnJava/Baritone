package io.github.javajump3r.mod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.LoggerFactory;

public class BARITONE extends Item {
    public BARITONE() {
        super(new Settings().maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World світ, PlayerEntity користувач, Hand рука) {
        //MinecraftClient.getInstance().getSoundManager().reloadSounds();

        if(світ.isClient())
        {
            //MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(Initializer.звукБаритону,1));
            return TypedActionResult.pass(користувач.getStackInHand(рука));
        }
        var позиція = користувач.getPos();
        var висота = NoteInfo.отриматиНотуЗаВисотоюГолови(
                користувач.getPitch()
        ).висота;
        світ.playSound(
                null,
                new BlockPos(позиція),
                Initializer.звукБаритону,
                SoundCategory.PLAYERS,
                1,
                висота
                );
        LoggerFactory.getLogger("Baritone").info(висота+" "+користувач.getPitch());
        користувач.getStackInHand(рука).setNbt(користувач.getStackInHand(рука).getNbt());
        користувач.getStackInHand(рука).setNbt(користувач.getStackInHand(рука).getNbt());
        return TypedActionResult.pass(користувач.getStackInHand(рука));
    }
}
