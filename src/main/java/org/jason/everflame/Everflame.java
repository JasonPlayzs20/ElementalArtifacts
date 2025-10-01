package org.jason.everflame;

import net.fabricmc.api.ModInitializer;
import org.jason.everflame.events.PlayerAttackEvent;
import org.jason.everflame.particles.ScytheSwipeParticle;

import java.sql.SQLOutput;

public class Everflame implements ModInitializer {
    public static final String MOD_ID = "everflame";
    @Override
    public void onInitialize() {
        ModItems.initialize();
        System.out.println("Mod Items Initialized");
        PlayerAttackEvent.register();
        System.out.println("Player Attack Event Initialized");
        ScytheSwipeParticle.registerParticles();
        System.out.println("ScytheSwipeParticle Registered");
    }
}
