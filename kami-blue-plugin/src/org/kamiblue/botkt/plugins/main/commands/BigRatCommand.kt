package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object BigRatCommand : BotCommand(
    name = "bigrat",
    description = "They are massive :o",
    alias = arrayOf("hugerat", "rat"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://bigrat.monster/")
        }
    }
}
