package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object ShulkerPreviewCommand : BotCommand(
    name = "shulkerpreview",
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal("2b2t полностью отключил пакеты от шалкеров, если вы фактически не нажмете правой кнопкой мыши на шалкер, то есть нет способа обойти это, и нет способа предварительного просмотра шалкеров на 2b.\nЭто относится ко всем клиентам, не только к KAMI Blue, потому что он также исправляет ванильный текст с `64х Обсидиан` в ванильной подсказке. Обхода нет.")
            } else {
                channel.normal("2b2t completely disabled shulker packets unless you actually right click the shulker, meaning there is no way to bypass that, and no way to preview shulkers on 2b.\nThis is the case in all clients, not just KAMI Blue, because it also patches the vanilla text that has `64x - Obsidian` in the vanilla tooltip. **There is no bypass.**")
            }
        }
    }
}
