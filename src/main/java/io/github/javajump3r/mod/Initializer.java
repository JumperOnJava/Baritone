package io.github.javajump3r.mod;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class Initializer {
	public static SoundEvent звукБаритону;

	public void onInitialize() {
		звукБаритону = Registry.register(
				Registries.SOUND_EVENT,
				new Identifier("baritone","baritone_sound"),
				SoundEvent.of(new Identifier("baritone","baritone_sound")));
		fabric_register_thing_stolen_from_tutorial.зареєструвати(new BARITONE(),"baritone");
		BaritoneHud.старт();
	}
}
