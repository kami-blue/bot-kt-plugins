package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object LogCommand : BotCommand(
    name = "log",
    description = "How to find your log file",
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal("Найдите файл `debug.log` в `~/.minecraft/logs` и вставьте содержимое на https://paste.ee/, а затем отправьте ссылку.")
            } else {
                channel.normal("Find the `debug.log` file inside `~/.minecraft/logs` and paste the contents to https://paste.ee/, and the send the link.")
            }
        }
    }
}
