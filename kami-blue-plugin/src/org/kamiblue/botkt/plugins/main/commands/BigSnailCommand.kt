package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object BigSnailCommand : BotCommand(
    name = "bigsnail",
    description = "They are massive :o",
    alias = arrayOf("hugesnail"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://bigsnail.monster/")
        }
    }
}
