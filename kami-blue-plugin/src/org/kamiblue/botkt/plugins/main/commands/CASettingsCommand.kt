package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object CASettingsCommand : BotCommand(
        name = "casettings",
        description = "CrystalAura settings",
        category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                    title = "CrystalAura settings",
                    description = "The default settings in the latest beta are usually good, adjust the settings to your play style and ping.\nIf you have used older versions of KAMI Blue then press the "Defaults" button to get the new default settings"
            )
        }
    }
}
