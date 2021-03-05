package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object ContributingCommand : BotCommand(
    name = "contributing",
    alias = arrayOf("cbt", "contribute"),
    description = "Link to the contributing instructions",
    category = Category.GITHUB
) {
    init {
        execute {
            channel.send("You can get instructions for contributing and building KAMI Blue here:\nhttps://kamiblue.org/contributing")
        }
    }
}
