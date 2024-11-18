package com.rededrick.commons.velocity

import com.google.inject.Inject
import com.rededrick.commons.velocity.collections.CommandsManager
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import org.slf4j.Logger

@Plugin(
    id = "commons",
    name = "commons",
    version = "1.0",
    url = "https://rededrick.com/",
    description = "A simple plugin proxy for Vulcanth",
    authors = ["oNyell"]
)
class Velocity @Inject constructor(private val logger: Logger, private val server: ProxyServer) {

    private val commandsManager = CommandsManager(server, logger)

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        commandsManager.setupCommands()
        logger.info("§aPlugin ativo com sucesso. BUILD: 1.0")
    }
}
