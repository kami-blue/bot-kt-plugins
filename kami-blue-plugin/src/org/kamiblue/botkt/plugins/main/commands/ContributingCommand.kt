package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object ContributingCommand : BotCommand(
    name = "contributing",
    category = Category.GITHUB
) {
    init {
        execute {
            channel.send("You can get instructions for contributing and building KAMI Blue here:\nhttps://kamiblue.org/contributing")
        }
    }
}
