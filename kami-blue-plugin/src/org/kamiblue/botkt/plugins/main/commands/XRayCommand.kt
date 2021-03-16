package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object XRayCommand : BotCommand(
    name = "xray",
    description = "Does KAMI Blue have an XRay Module?",
    category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                title = "Does KAMI Blue have an XRay Module",
                description = "**TL:DR No, not right now.**\n\n" +
                "The old XRay module was removed due to the code being ancient and unmaintainable, and incompatible with the new GUI + setting system.\n" +
                "There is an open [issue](https://github.com/kami-blue/client/issues/289) to re-add XRay, which should soon be resolved.\n"+
                "For right now, good alternatives for XRay are Search, Freecam, and Baritone, depending on why you wanted XRay."
            )
        }
    }
}
