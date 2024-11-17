package com.rededrick.commons.velocity;

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import org.slf4j.Logger

@Plugin(
    id = "commons",
    name = "commons",
    version = "1.0",
    url = "https://rededrick.com/",
    description = "A simple plugin proxy for Vulcanth",
    authors = ["oNyell"])

class Velocity @Inject constructor(val logger: Logger) {

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        logger.info("§aPlugin ativo com sucesso. BUILD: 1.0")
    }
}
