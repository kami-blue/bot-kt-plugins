package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object ModulesCommand : BotCommand(
    name = "modules",
    category = Category.INFO
) {
    init {
        execute {
            channel.send("https://kamiblue.org/modules")
        }
    }
}
