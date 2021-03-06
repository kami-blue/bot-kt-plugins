package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object KamiCommand : BotCommand(
    name = "kami",
    description = "KAMI vs KAMI Blue",
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal(
                    title = "KAMI против KAMI Blue",
                    description = "KAMI (версия для Fabric) и KAMI Blue сильно отличаются.\n\nДля пользователей основными отличиями являются:\nKAMI - для версий `1.16.x` ** Fabric **, а KAMI Blue - для `1.12.2` ** Forge **\nГрафические интерфейсы совершенно разные, как функционально, так и эстетически.\nKAMI и KAMI Blue имеют некоторые одинаковые модули, но есть много различий.\nВы можете получить техническую поддержку по использованию KAMI на их [Discord сервере](https://discord.gg/9hvwgeg)."
                )
            } else {
                channel.normal(
                    title = "KAMI vs KAMI Blue",
                    description = "KAMI (the Fabric version) and KAMI Blue are vastly different.\n\nFor users, the main differences are:\n- KAMI is `1.16.x` **Fabric** and KAMI Blue is `1.12.2` **Forge**.\n- The GUI's are entirely different, both functionally and aesthetically.\n- KAMI and KAMI Blue, while sharing some, have a lot of different features.\n\nYou can get support for using KAMI in their [Discord](https://discord.gg/9hvwgeg)."
                )
            }
        }
    }
}
