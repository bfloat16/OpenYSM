package com.elfmcys.yesstevemodel.client.gui.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigCheckBoxForge {

    public static Checkbox create(int x, int y, String str, ForgeConfigSpec.BooleanValue booleanValue) {
        return Checkbox.builder(Component.translatable("gui.yes_steve_model.config." + str), Minecraft.getInstance().font)
                .pos(x, y)
                .selected(booleanValue.get().booleanValue())
                .onValueChange((checkbox, selected) -> booleanValue.set(selected))
                .build();
    }
}