package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object SettingsCommand : BotCommand(
        name = "settings",
        description = "CrystalAura settings",
        category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                    title = "CrystalAura settings for KAMI Blue",
                    description = "The settings for the CrystalAura by default are configured as well as possible, set them up in accordance with your ping, playstile, etc")
        }
    }
}
