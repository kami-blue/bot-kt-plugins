package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object InstallCommand : BotCommand(
    name = "install",
    description = "How to install KAMI Blue",
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal(
                    title = "Установка",
                    description = "KAMI Blue можно скачать из <#634549110145286156> или с нашего [сайта](https://kamiblue.org/download)\n\nЭто [Forge](https://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.12.2.html) мод на версию `1.12.2`. Вы можете сделать двойной клик по `.jar` файлу чтобы открыть установщик.\nЕсли вы истользуете MultiMC, переместите `.jar` файл в папку с модами\n\nИспользуйте `;kami` для получения дополнительной информации о различных версиях."
                )
            } else {
                channel.normal(
                    title = "Install",
                    description = "Download this from <#634549110145286156> or from the [website](https://kamiblue.org/download).\n\nThis is a `1.12.2` [Forge mod](https://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.12.2.html). You can double click the jar to open the installer.\nIf you use MultiMC or something, you can drag the jar file to your instance's mods folder.\n\nUse `;kami` for more information about different versions."
                )
            }
        }
    }
}
