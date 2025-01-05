package com.rededrick.commons.commands

import org.bukkit.command.CommandSender

interface CommandInterface {
    fun execute(sender: CommandSender, label: String, args: Array<out String>)
}
