package com.rededrick.commons.velocity.collections

import com.velocitypowered.api.proxy.ProxyServer
import org.reflections.Reflections
import org.slf4j.Logger
import lombok.NonNull

class CommandsManager(@NonNull private val proxyServer: ProxyServer, @NonNull private val logger: Logger) {

    private val commands = mutableListOf<CustomCommand>()

    /**
     * Função para registrar um único comando.
     */
    private fun registerCommand(command: CustomCommand) {
        val meta = proxyServer.commandManager.metaBuilder(command.name)
            .aliases(*command.aliases.toTypedArray())
            .build()

        proxyServer.commandManager.register(meta, command)

        // Adiciona o comando à lista interna
        commands.add(command)
        logger.info("Comando registrado: ${command.name}")
    }

    /**
     * Função para configurar e registrar todos os comandos.
     * Esta função irá automaticamente registrar todos os comandos que implementam a interface "CustomCommand".
     */
    fun setupCommands() {
        val reflections = Reflections("com.rededrick.commons.velocity.collections.commands")
        val commandClasses = reflections.getSubTypesOf(CustomCommand::class.java)

        for (commandClass in commandClasses) {
            try {
                // Cria uma nova instância da classe do comando (requer um construtor padrão)
                val commandInstance: CustomCommand = commandClass.getDeclaredConstructor().newInstance()

                // Registra o comando
                registerCommand(commandInstance)
            } catch (e: Exception) {
                // Imprime um erro se não conseguimos instanciar e registrar o comando
                logger.error("Erro ao registrar o comando ${commandClass.name}", e)
            }
        }
    }
}