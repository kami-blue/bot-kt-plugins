package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object SafeCommand : BotCommand(
        name = "safe",
        description = "Is KAMI Blue safe?",
        category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                    title = "Settings for KAMI Blue",
                    description = "The default settings are already good, just adjust the settings to suit your playstyle and ping.")
        }
    }
}
