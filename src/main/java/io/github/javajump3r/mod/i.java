package io.github.javajump3r.mod;

import net.fabricmc.api.ModInitializer;

public class i implements ModInitializer {
    @Override
    public void onInitialize() {
        new Initializer().onInitialize();
    }
}
