package org.kamiblue.botkt.plugins.main.commands

import net.ayataka.kordis.entity.message.MessageBuilder
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.Colors
import org.kamiblue.botkt.utils.error
import org.kamiblue.botkt.utils.upload
import java.io.File

object JarFixCommand : BotCommand(
    name = "jarfix",
    description = "Fixing jar files on windows",
    category = Category.INFO
) {
    init {
        execute {
            val embed = MessageBuilder().apply {
                embed {
                    title = "Jar fix for Windows"
                    description = "On Windows, jars can get associated with WinRar or similar programs. " +
                        "The JarFix program restores the `JAVA_HOME` variable and **sets jar files to be opened with Java.**"
                    color = Colors.PRIMARY.color
                }
            }.build()

            val file = File("assets/jarfix.exe")

            if (!file.exists() || file.isDirectory) {
                channel.error("Could not find `assets/jarfix.exe`")
            } else {
                channel.upload(file, embed = embed)
            }
        }
    }
}
