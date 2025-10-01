package org.jason.everflame.events;

//import com.jason.weaponsmaxed.ModItems;
//import com.jason.weaponsmaxed.particles.ScytheSwipeParticle;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Box;
import org.jason.everflame.ModItems;
import org.jason.everflame.particles.ScytheSwipeParticle;

import java.util.List;

public class PlayerAttackEvent {
    public static void register() {
        System.out.println("attac registering");
        AttackEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> {
            if (!player.isSpectator()) {
                if (player.getMainHandStack().getItem() == ModItems.CLOWN_SCYTHE) {
                    if (player.isSprinting()) {
                        return ActionResult.PASS;
                    }
                    double swingTicks = player.handSwingTicks;
                    if (swingTicks != 0) {
                        return ActionResult.PASS;
                    }
//                    player.sendMessage(Text.of("you attacked"), true);
//                    player.sendMessage(Text.of(String.valueOf(player.getFacing()    )),true);
                    float yawDegrees = player.getYaw();     // Horizontal rotation (0 = South, -90 = East, 90 = West)
                    float pitchDegrees = player.getPitch(); // Vertical rotation (0 = horizontal, 90 = looking straight down)

// Convert to radians
                    float yaw = (float) Math.toRadians(-yawDegrees);     // Invert yaw for correct forward direction
                    float pitch = (float) Math.toRadians(-pitchDegrees); // Invert pitch (Minecraft uses reversed pitch)

// Compute direction vector
                    float x = (float) (Math.sin(yaw) * Math.cos(pitch));
                    float y = (float) (Math.sin(pitch));
                    float z = (float) (Math.cos(yaw) * Math.cos(pitch));
                    double distance = 0.6;

                    double spawnX = player.getX() + x * distance;
                    double spawnY = player.getEyeY() + y * distance;
                    double spawnZ = player.getZ() + z * distance;
                    world.addParticle(ScytheSwipeParticle.SCYTHE_SWIPE_PARTICLE, spawnX, spawnY-0.5, spawnZ, 0, 0, 0);
                    List<Entity> entities = world.getOtherEntities(player,new Box(spawnX-1,spawnY-1,spawnZ-1,spawnX-1,spawnY+1,spawnZ+1));
//                    DamageSource damageSource = new DamageSource(RegistryEntry<DamageTypes.PLAYER_ATTACK>, );
                    entities.forEach(entity1 -> {
//                        entity1.damage(player.getServer().getWorld(RegistryKey.of()),DamageTypes.PLAYER_ATTACK,1);
                    });
                }
            }
            return ActionResult.PASS;
        }));
    }
}
