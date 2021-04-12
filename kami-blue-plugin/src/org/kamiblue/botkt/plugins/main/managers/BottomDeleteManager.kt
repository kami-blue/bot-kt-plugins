package org.kamiblue.botkt.plugins.main.managers

import net.ayataka.kordis.event.events.message.MessageReceiveEvent
import org.kamiblue.botkt.manager.Manager
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
