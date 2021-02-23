package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.PermissionTypes
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.command.options.HasPermission
import org.kamiblue.botkt.command.options.ServerOnly

object ExportRolesCommand : BotCommand(
    name = "ers",
    description = "Export all users with roles and their roles",
    category = Category.MISC
) {
    init {
        execute(HasPermission.get(PermissionTypes.COUNCIL_MEMBER), ServerOnly) {
            val members = server!!.members.filter { it.roles.isNotEmpty() }

            channel.send("```csv\n" +
                    members.joinToString("\n") {
                        "${it.id}," +
                                it.roles.joinToString(",") { role ->
                                    "${it.id}:${it.name}"
                                }
                    } +
                    "\n```"
            )
        }
    }
}