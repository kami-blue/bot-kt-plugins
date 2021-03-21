package org.kamiblue.botkt.plugins.main.commands

import net.ayataka.kordis.entity.message.MessageBuilder
import org.kamiblue.botkt.PermissionTypes
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.command.options.HasPermission
import org.kamiblue.botkt.command.options.ServerOnly
import org.kamiblue.botkt.plugins.main.commands.ExportEmojiCommand.execute
import org.kamiblue.botkt.utils.Colors
import org.kamiblue.botkt.utils.upload
import java.io.File

object ExportBansCommand : BotCommand(
    name = "exportbans",
    description = "Export the full ban list with reasons",
    category = Category.MISC
) {
    init {
        execute(HasPermission.get(PermissionTypes.COUNCIL_MEMBER), ServerOnly) {
            val server = server!!

            val bans = server.bans()
            val formatted =
                bans.joinToString("\n") {
                    "${it.user.id},\"${it.user.tag}\",\"${it.reason ?: "No Reason Provided"}\""
                        .replace("\n", "\\n")
                }

            val embed = MessageBuilder().apply {
                embed {
                    field("Total bans", "${bans.size}")
                    color = Colors.PRIMARY.color
                }
            }.build()

            val file = File("cache/bans-cache-${server.id}.csv")
            file.bufferedWriter().use {
                it.write(formatted)
            }

            channel.upload(file, embed = embed)

            file.delete()
        }
    }
}