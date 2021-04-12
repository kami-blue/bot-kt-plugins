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
            if (event.message.contains("🥺") && event.message.contains("💖") && event.message.contains("✨")) {
                event.message.tryDelete();
            }
        }
    }
}