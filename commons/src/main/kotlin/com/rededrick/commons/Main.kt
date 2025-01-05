package com.rededrick.commons

import org.bukkit.plugin.java.JavaPlugin
import com.rededrick.commons.commands.CommandManager

class Main : JavaPlugin() {

    override fun onEnable() {
        CommandManager.setupCommands()
        logger.info("Plugin Rededrick Commons habilitado com sucesso!")
    }

    override fun onDisable() {
        logger.info("Plugin Rededrick Commons desativado.")
    }
}
