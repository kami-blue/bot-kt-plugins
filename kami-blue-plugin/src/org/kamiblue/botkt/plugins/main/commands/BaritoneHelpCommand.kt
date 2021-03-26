package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object BaritoneHelpCommand : BotCommand(
    name = "baritonehelp",
    alias = arrayOf("bhelp"),
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal(
                    title = "Справка Baritone",
                    description = "Баритон `1.2.14` входит в состав KAMI Blue и с ним совместимы многочисленные модули.\n\n" +
                            "Однако мы не можем помочь с Baritone, кроме включенной команды `;b` и функций KAMI Blue, которые ее используют.\n" +
                            "Если вам нужна поддержка по вопросам, связанным с баритоном, спросите в [Baritone Discord](https://discord.gg/s6fRBAUpmr)"
                )
            } else {
                channel.normal(
                    title = "Baritone Help",
                    description = "Baritone `1.2.14` is included in KAMI Blue and numerous modules are compatible with it.\n\n" +
                            "However, we don't provide help for Baritone outside of the included `;b` command and KAMI Blue features that use it.\n" +
                            "If you need support with Baritone-specific issues then you need to ask in the [Baritone Discord](https://discord.gg/s6fRBAUpmr)"
                )
            }
        }
    }
}