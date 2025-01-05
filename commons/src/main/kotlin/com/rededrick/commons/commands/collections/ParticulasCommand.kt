package com.rededrick.commons.commands.collections

import com.rededrick.commons.commands.Command
import com.rededrick.commons.commands.CommandInterface
import com.rededrick.commons.enums.ParticleEnum
import com.rededrick.commons.particles.ParticleManager
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@Command(cmd = "particulas", alias = ["particle", "particulascirculares"], onlyPlayer = true)
class ParticulasCommand : CommandInterface {
    override fun execute(sender: CommandSender, label: String, args: Array<out String>) {
        if (sender is Player) {
            val particleManager = ParticleManager()
            particleManager.spawnParticle(ParticleEnum.CIRCULAR, sender)
            sender.sendMessage("§aPartículas circulares ativadas!")
        } else {
            sender.sendMessage("§cEste comando só pode ser executado por jogadores!")
        }
    }
}
