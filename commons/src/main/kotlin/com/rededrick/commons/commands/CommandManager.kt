package com.rededrick.commons.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap
import org.bukkit.entity.Player
import org.reflections.Reflections

class CommandManager(
    private val name: String,
    private val commandInterface: CommandInterface,
    private val onlyPlayer: Boolean,
    vararg aliases: String
) : Command(name) {

    init {
        this.aliases = aliases.toList()
        try {
            val server = Bukkit.getServer()
            val commandMapField = server.javaClass.getDeclaredField("commandMap")
            commandMapField.isAccessible = true
            val commandMap = commandMapField.get(server) as SimpleCommandMap
            commandMap.register("commons", this)
        } catch (e: Exception) {
            throw RuntimeException("Não foi possível registrar o comando $name", e)
        }
    }

    override fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean {
        if (onlyPlayer && sender !is Player) {
            sender.sendMessage("§cEste comando só pode ser executado por jogadores!")
            return false
        }

        commandInterface.execute(sender, label, args)
        return true
    }

    companion object {
        fun setupCommands() {
            val reflections = Reflections("com.rededrick.commons.commands")
            val annotatedClasses = reflections.getTypesAnnotatedWith(com.rededrick.commons.commands.Command::class.java)

            for (clazz in annotatedClasses) {
                if (CommandInterface::class.java.isAssignableFrom(clazz)) {
                    val annotation = clazz.getAnnotation(com.rededrick.commons.commands.Command::class.java)
                    val name = annotation.cmd
                    val aliases = annotation.alias
                    val onlyPlayer = annotation.onlyPlayer

                    try {
                        val constructor = clazz.getDeclaredConstructor()
                        val commandInstance = constructor.newInstance() as CommandInterface
                        CommandManager(name, commandInstance, onlyPlayer, *aliases)
                        println("Comando registrado: $name")
                    } catch (e: Exception) {
                        println("Erro ao registrar o comando $name: ${e.message}")
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}
