package org.jason.everflame.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class EverflameClient implements ClientModInitializer {
    public static KeyBinding PLAY_KEY;
    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            AnimationRegistry.registerAll();
        });
        PLAY_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.everflame.play", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K,"category.everflame"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            if (PLAY_KEY.isPressed()) {
                AnimationSystem.playAnimation(client.player.getUuid(),"test");
            }
            AnimationSystem.tick(client);
        });


    }
}
