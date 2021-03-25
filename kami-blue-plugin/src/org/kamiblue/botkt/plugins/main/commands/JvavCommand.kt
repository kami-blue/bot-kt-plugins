package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object JvavCommand : BotCommand(
        name = "jvav",
        description = "jvav
        category = Category.FUN
) {
    init {
        execute {
            channel.send("<:jvav:823273907385663518>")
        }
    }
}
