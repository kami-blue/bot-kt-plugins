package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object CASettingsCommand : BotCommand(
    name = "casettings",
    alias = arrayOf("cas", "ca", "casetting"),
    description = "CrystalAura settings",
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal(
                    title = "Настройки CrystalAura",
                    description = "Настройки по умолчанию в последней бета-версии обычно хороши, но вы можете отрегулировать настройки в соответствии со своим стилем игры и пингом.\n\n" +
                            "Если вы используете старые версии KAMI Blue, нажмите кнопку \"Defaults\", чтобы получить настройки модуля по умолчанию."
                )
            } else {
                channel.normal(
                    title = "CrystalAura settings",
                    description = "The default settings in the latest beta are usually good, adjust the settings to your play style and ping.\n\nIf you have used older versions of KAMI Blue then press the \"Defaults\" button to get the new default settings"
                )
            }
        }
    }
}
