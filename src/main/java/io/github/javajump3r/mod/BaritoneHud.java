package io.github.javajump3r.mod;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionf;

import java.util.Arrays;

public class BaritoneHud {
    public static void старт() {
        HudRenderCallback.EVENT.register(BaritoneHud::рендер);
    }

    private static void рендер(MatrixStack matrixStack, float v) {
        if(MinecraftClient.getInstance().player.getMainHandStack().getItem() instanceof BARITONE
                ||MinecraftClient.getInstance().player.getOffHandStack().getItem() instanceof BARITONE ) {
            matrixStack.push();
            var ШиринаВікна = MinecraftClient.getInstance().getWindow().getScaledWidth();
            var ВисотаВікна = MinecraftClient.getInstance().getWindow().getScaledHeight();
            var ВисотаПогляду = MinecraftClient.getInstance().player.getPitch();
            var Нота = NoteInfo.отриматиНотуЗаВисотоюГолови(ВисотаПогляду);
            DrawableHelper.drawCenteredText(
                    matrixStack,
                    MinecraftClient.getInstance().textRenderer,
                    Нота.назва,
                    ШиринаВікна/2,
                    ВисотаВікна/2+3,
                    Нота.колір
            );
            var КількістьЧастинок = Arrays.stream(NoteInfo.values()).count();
            var РозмірЧастинки = (int) (ВисотаВікна/2/КількістьЧастинок);

            matrixStack.translate(0,ВисотаВікна/2*(-ВисотаПогляду/(NoteInfo.максимум-NoteInfo.мінімум)),0);
            for(int номерНоти=0;номерНоти<КількістьЧастинок;номерНоти++) {
                DrawableHelper.fill(matrixStack, ШиринаВікна / 2 + 8, ВисотаВікна / 4 + РозмірЧастинки * номерНоти + 1, ШиринаВікна / 2 + 24, ВисотаВікна / 4 + РозмірЧастинки * (номерНоти + 1) - 1, NoteInfo.values()[номерНоти].колір);
                DrawableHelper.drawTextWithShadow(matrixStack, MinecraftClient.getInstance().textRenderer, Text.literal(NoteInfo.values()[номерНоти].назва),
                        ШиринаВікна / 2 + 26,(int) (ВисотаВікна / 4 + РозмірЧастинки * (номерНоти+0.3)), NoteInfo.values()[номерНоти].колір);
            }
            matrixStack.pop();
        }
    }
}
