package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object BigMonkeyCommand : BotCommand(
    name = "bigmonkey",
    description = "They are massive :o",
    alias = arrayOf("hugemonkey"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://bigmonkey.monster/")
        }
    }
}
