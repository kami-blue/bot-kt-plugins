package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object ChristmasBigRatCommand : BotCommand(
    name = "christmasbigrat",
    description = "They are massive :o",
    alias = arrayOf("xmashugerat", "xmasrat"),
    category = Category.FUN
) {
    init {
        execute {
            channel.send("https://christmas.bigrat.monster/")
        }
    }
}
