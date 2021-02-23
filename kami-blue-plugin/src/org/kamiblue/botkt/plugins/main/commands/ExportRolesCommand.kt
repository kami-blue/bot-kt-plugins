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

object ExportRolesCommand : BotCommand(
    name = "ers",
    description = "Export all users with roles and their roles",
    category = Category.MISC
) {
    init {
        execute(HasPermission.get(PermissionTypes.COUNCIL_MEMBER), ServerOnly) {
            val server = server!!
            val members = server.members.filter { it.roles.size > 1 }

            val formatted =
                members.joinToString("\n") {
                    "${it.id},${it.tag}," + it.roles
                        .filter { role -> !role.isEveryone }
                        .joinToString(",") { role ->
                            "${role.id}:${role.name}"
                        }
                }

            val embed = MessageBuilder().apply {
                embed {
                    field("Members with roles", "${members.size}")
                    field("Total members", "${server.members.size}")
                    field(
                        "% of members with roles",
                        "${MathUtils.round((members.size / server.members.size) * 100.0, 3)}%"
                    )
                    color = Colors.PRIMARY.color
                }
            }.build()

            val file = File("cache/roles-cache-${server.id}.csv")
            file.bufferedWriter().use {
                it.write(formatted)
            }

            channel.upload(file, embed = embed)

            file.delete()
        }
    }
}