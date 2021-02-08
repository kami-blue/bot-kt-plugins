package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object GrayCommand : BotCommand(
    name = "gray",
    alias = arrayOf("grey"),
    category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                title = "Why is my rendering stuff gray!!",
                description = "Impact Forge edition is unsupported and does not receive forge-specific bug fixes.\n" +
                    "Most gray rendering bugs with Impact + KAMI Blue are caused by an already fixed Baritone bug.\n" +
                    "The only way to fix this is to wait for Baritone 1.2.15 to be released.\n" +
                    "An alternative is to use KAMI Blue's rendering modules, which are generally better on performance and look better."
            )
        }
    }
}
