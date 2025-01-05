package com.rededrick.commons.commands

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@Command(cmd = "fly", alias = ["flyon", "flyoff"], onlyPlayer = true)
class FlyCommand : CommandInterface {
    override fun execute(sender: CommandSender, label: String, args: Array<out String>) {
        if (sender !is Player) {
            sender.sendMessage("§cEste comando pode ser executado apenas por jogadores!")
            return
        }

        val player = sender
        if (player.allowFlight) {
            player.allowFlight = false
            player.isFlying = false
            player.sendMessage("§7Seu modo de voo foi desativado!")
        } else {
            player.allowFlight = true
            player.isFlying = true
            player.sendMessage("§7Você agora está voando!")
        }
    }
}
