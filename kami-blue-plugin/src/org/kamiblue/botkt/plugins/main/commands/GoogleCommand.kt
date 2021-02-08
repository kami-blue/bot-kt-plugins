package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object GoogleCommand : BotCommand(
    name = "google",
    category = Category.FUN
) {
    init {
        execute { 
            channel.send("Use Google 😡")
        }
    }
}
