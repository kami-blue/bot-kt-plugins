package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object SmallRatCommand : BotCommand(
    name = "smallrat",
    description = "They are tiny :o",
    alias = arrayOf("tinyrat"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://mfw.tfw.wtf/")
        }
    }
}
