package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object BigDogCommand : BotCommand(
    name = "bigdog",
    description = "They are massive :o",
    alias = arrayOf("hugedog"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://bigdog.monster/")
        }
    }
}
