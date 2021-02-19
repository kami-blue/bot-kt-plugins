package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object BigEarsCommand : BotCommand(
    name = "bigears",
    description = "They are massive :o",
    alias = arrayOf("hugeears"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://bigears.monster/")
        }
    }
}
