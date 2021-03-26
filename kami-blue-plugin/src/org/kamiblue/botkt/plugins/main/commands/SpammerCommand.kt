package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object SpammerCommand : BotCommand(
    name = "spammercommand",
    alias = arrayOf("spammer", "spam"),
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal(
                    title = "Справка Baritone",
                    description = "В модуле Spammer есть инструкции в чате при первом включении.\n\n" +
                            "После включения модуля вы можете редактировать файл `.minecraft/kamiblue/spammer.txt`, каждое сообщение помещается в новую строку.\n" +
                            "Вы можете отключить и включить модуль для перезагрузки новых изменений в файл."
                )
            } else {
                channel.normal(
                    title = "Spammer Module Help",
                    description = "The Spammer module has instructions in the chat the first time you enable it.\n\n" +
                            "Once enabling the module, you can edit the `.minecraft/kamiblue/spammer.txt` file, each message goes on a new line.\n" +
                            "You can disable and enable the module to reload new changes to the file."
                )
            }
        }
    }
}