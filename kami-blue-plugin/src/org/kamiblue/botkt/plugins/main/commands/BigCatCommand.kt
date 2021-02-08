package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object BigCatCommand : BotCommand(
    name = "bigcat",
    description = "They are massive :o",
    alias = arrayOf("hugecat"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://bigcat.monster/")
        }
    }
}
