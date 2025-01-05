package com.rededrick.commons.commands

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Command(
    val cmd: String = "",
    val alias: Array<String> = [],
    val onlyPlayer: Boolean = false
)
