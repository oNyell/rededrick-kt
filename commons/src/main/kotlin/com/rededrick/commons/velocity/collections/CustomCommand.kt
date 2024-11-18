package com.rededrick.commons.velocity.collections

import com.velocitypowered.api.command.CommandSource
import com.velocitypowered.api.command.SimpleCommand
import net.kyori.adventure.text.Component

interface CustomCommand : SimpleCommand {
    val name: String
    val aliases: List<String>
    val description: String
    val permission: String

    override fun execute(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()
        if (source.hasPermission(permission)) {
            executeIfPermitted(invocation)
        } else {
            source.sendMessage(Component.text("Você não tem permissão para executar este comando!"))
        }
    }

    fun executeIfPermitted(invocation: SimpleCommand.Invocation)
}