package org.kamiblue.botkt.plugins.main.managers

import net.ayataka.kordis.event.events.message.MessageReceiveEvent
import org.kamiblue.botkt.ConfigType
import org.kamiblue.botkt.PermissionConfig
import org.kamiblue.botkt.PermissionTypes
import org.kamiblue.botkt.Permissions.hasPermission
import org.kamiblue.botkt.manager.Manager
import org.kamiblue.botkt.manager.managers.ConfigManager
import org.kamiblue.botkt.utils.Colors
import org.kamiblue.botkt.utils.tryDelete
import org.kamiblue.event.listener.asyncListener

object PingDeleteManager : Manager {
    init {
        asyncListener<MessageReceiveEvent> { event ->
            val message = event.message

            if (message.author.hasPermission(PermissionTypes.COUNCIL_MEMBER)) return@asyncListener
            if (message.serverChannel?.category?.id != 787768140397281281) return@asyncListener

            val cms = ConfigManager.readConfigSafe<PermissionConfig>(ConfigType.PERMISSION, false)?.let {
                it.councilMembers
            } ?: return@asyncListener

            if (cms.any { message.content.contains(it.key.toString()) }) {
                message.tryDelete()
                message.channel.send {
                    embed {
                        title = "Rule 6a"
                        description = "You cannot ping people for help, be patient and wait for a response."
                        color = Colors.ERROR.color
                        footer("ID: ${message.author?.id}", message.author?.avatar?.url)
                    }
                }
            }
        }
    }
}