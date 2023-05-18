package io.github.javajump3r.mod;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class fabric_register_thing_stolen_from_tutorial {
    public static <T extends Item> T зареєструвати(T предмет, String ідентифікатор) {
        Identifier ідентифікаторПредмету = new Identifier("baritone", ідентифікатор);

        T зареєстрованийПредмет = Registry.register(Registries.ITEM, ідентифікаторПредмету, предмет);

        return зареєстрованийПредмет;
    }
}
