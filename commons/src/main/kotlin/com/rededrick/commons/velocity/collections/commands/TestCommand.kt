package com.rededrick.commons.velocity.collections.commands

import com.rededrick.commons.velocity.collections.CustomCommand
import com.velocitypowered.api.command.SimpleCommand
import net.kyori.adventure.text.Component

class TestCommand : CustomCommand {
    override val name = "teste"
    override val aliases = listOf("testar")
    override val description = "Um comando de teste simples."
    override val permission = "testcommand.use"

    override fun executeIfPermitted(invocation: SimpleCommand.Invocation) {
        val source = invocation.source()
        source.sendMessage(Component.text("Comando de teste executado com sucesso!"))
    }
}