package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object TroubleshootCommand : BotCommand(
    name = "troubleshoot",
    description = "Troubleshooting info in KAMI Blue",
    alias = arrayOf("tsc"),
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal("`;tsc` показывает разработчикам важную информацию для поиска и устранения неисправностей, которая помогает решать проблемы. Покажите снимок экрана с выводом этой команды в Minecraft")
            } else {
                channel.normal("`;tsc` shows important troubleshooting information to the developers to help solve problems. Please show a screenshot of the output of that command when ran inside Minecraft")
            }
        }
    }
}
