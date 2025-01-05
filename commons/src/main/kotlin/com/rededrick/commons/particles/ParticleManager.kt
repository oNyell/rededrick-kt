package com.rededrick.commons.particles

import com.rededrick.commons.enums.ParticleEnum
import org.bukkit.Bukkit
import org.bukkit.Effect
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import kotlin.math.cos
import kotlin.math.sin

class ParticleManager {

    fun spawnParticle(type: ParticleEnum, player: Player) {
        when (type) {
            ParticleEnum.CIRCULAR -> spawnCircularParticles(player)
            else -> Unit
        }
    }

    private fun spawnCircularParticles(player: Player) {
        object : BukkitRunnable() {
            var angle = 0.0

            override fun run() {
                if (!player.isOnline) {
                    cancel()
                    return
                }

                val location = player.location.add(0.0, 1.5, 0.0)
                angle += Math.PI / 8

                val radius = 1.0
                val x = cos(angle) * radius
                val z = sin(angle) * radius

                val particleLocation = location.clone().add(x, 0.0, z)

                particleLocation.world.playEffect(particleLocation, Effect.HEART, 0)

                if (angle >= 2 * Math.PI) {
                    angle = 0.0
                }
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("commons"), 0L, 2L)
    }
}
