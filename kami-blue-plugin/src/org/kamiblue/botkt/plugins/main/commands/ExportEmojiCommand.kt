package org.kamiblue.botkt.plugins.main.commands

import net.ayataka.kordis.entity.message.MessageBuilder
import org.kamiblue.botkt.PermissionTypes
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.command.options.HasPermission
import org.kamiblue.botkt.command.options.ServerOnly
import org.kamiblue.botkt.utils.Colors
import org.kamiblue.botkt.utils.upload
import org.kamiblue.commons.utils.MathUtils
import java.io.File

object ExportEmojiCommand : BotCommand(
    name = "exportemoji",
    description = "Export all emojis",
    category = Category.MISC
) {
    init {
        execute(HasPermission.get(PermissionTypes.COUNCIL_MEMBER), ServerOnly) {
            val server = server!!

            val formatted =
                server.emojis.joinToString("\n") {
                    it.name.replace(",", "") + "," + it.image.url
                }

            val embed = MessageBuilder().apply {
                embed {
                    field("Total emojis", "${server.emojis.size}")
                    color = Colors.PRIMARY.color
                }
            }.build()

            val file = File("cache/emojis-cache-${server.id}.csv")
            file.bufferedWriter().use {
                it.write(formatted)
            }

            channel.upload(file, embed = embed)

            file.delete()
        }
    }
}