package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object XrayCommand : BotCommand(
    name = "xray",
    alias = arrayOf("xray", "xry"),
    description = "Does Kami Blue have an Xray Module",
    category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                title = "Does Kami Blue have an Xray Module",
                description = "**TL:DR No, not right now.**\n\n" +
                "While there was at one point an xray module, it was removed due to incompatibility with older code.\n" +
                "There is an open [issue](https://github.com/kami-blue/client/issues/289) to re-add xray, which should eventually be resolved.\n"+
                "For right now, good alternatives for xray are search, freecam, and baritone, depending on why you wanted xray.")
        }
    }
}
