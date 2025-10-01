package org.jason.everflame.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
//import net.minecraft.particle.SimpleParticleType;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

//import static com.jason.weaponsmaxed.Weaponsmaxed.MOD_ID;
import static org.jason.everflame.Everflame.MOD_ID;

public class ScytheSwipeParticle {
    public static final DefaultParticleType SCYTHE_SWIPE_PARTICLE = FabricParticleTypes.simple();
    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID,"scythe_swipe"), SCYTHE_SWIPE_PARTICLE);
    }
}
