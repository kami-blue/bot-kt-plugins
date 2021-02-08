package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object SmallSnailCommand : BotCommand(
    name = "smallsnail",
    description = "They are tiny :o",
    alias = arrayOf("tinysnail"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://tinysnail.monster/")
        }
    }
}
