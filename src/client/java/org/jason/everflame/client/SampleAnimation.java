package org.jason.everflame.client;

import net.minecraft.client.MinecraftClient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class SampleAnimation {
    private static final Map<UUID,Long> active = new HashMap<>();
    private static final float DURATION = 2000f;

    public static void run(UUID player) {
        active.put(player, System.currentTimeMillis());
    }

    public static void tick (MinecraftClient client) {
        long now = System.currentTimeMillis();
        for (Iterator<Map.Entry<UUID, Long>> it = active.entrySet().iterator(); it.hasNext();) {
            Map.Entry<UUID, Long> e = it.next();
            long start = e.getValue();
            float t = (now - start);
            if (t > DURATION) {
                RenderHook.setModelPose(e.getKey(), null);
                it.remove();
                continue;
            }

            float progress = t / DURATION;

            float eased = (float)(1 - Math.cos(progress * Math.PI)) / 2;

            Map<String, float[]> pose = new HashMap<>();

            float bodyRotationY = -eased * (float)Math.toRadians(45);
            pose.put("body", new float[]{0f, bodyRotationY, 0f});

            float armPitchUp = eased * (float)Math.toRadians(-90);
            float armYawForward = eased * (float)Math.toRadians(45);

            pose.put("rightArm", new float[]{armPitchUp, armYawForward + bodyRotationY, 0f});
            pose.put("rightLeg", new float[]{armPitchUp, armYawForward + bodyRotationY, 0f});

            float leftArmSubtle = eased * (float)Math.toRadians(15);
            pose.put("leftArm", new float[]{0f, leftArmSubtle + bodyRotationY, 0f});

            RenderHook.setModelPose(e.getKey(), pose);
        }
    }
}