package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object UpdatesRoleCommand : BotCommand(
    name = "updatesrole",
    alias = arrayOf("updates", "updaterole", "roleupdates", "roleupdate"),
    description = "Gives or removes the <@&573957771494686740> role",
    category = Category.MISC
) {
    init {
        execute {
            val member = message.member!!
            val role = server!!.roles.find(573957771494686740)!!

            if (member.roles.contains(role)) {
                member.removeRole(role)
                channel.send("You will no longer get beta update pings :(")
            } else {
                member.addRole(role)
                channel.send("You will now get beta update pings! :o")
            }
        }
    }
}
