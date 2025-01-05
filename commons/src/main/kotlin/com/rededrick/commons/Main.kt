package com.rededrick.commons

import com.rededrick.commons.commands.CommandManager
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        CommandManager.setupCommands()
        logger.info("Plugin habilitado com sucesso!")
    }

    override fun onDisable() {
        logger.info("Plugin foi desabilitado com sucesso!")
    }
}
