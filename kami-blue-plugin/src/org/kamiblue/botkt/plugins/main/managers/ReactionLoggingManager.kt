package org.kamiblue.botkt.plugins.main.managers

import net.ayataka.kordis.event.events.message.ReactionAddEvent
import org.kamiblue.botkt.Main
import org.kamiblue.botkt.manager.Manager
import org.kamiblue.event.listener.asyncListener

object ReactionLoggingManager : Manager {
    init {
        asyncListener<ReactionAddEvent> {
            val react = it.reaction
            val author = react.author ?: return@asyncListener
            Main.logger.debug("${author.id} (${author.tag}) reacted with '${react.emoji.name}' " +
                    "to ${react.messageId} in channel ${react.channelId} in server ${react.server?.id} " +
                    "(${react.server?.name})")
        }
    }
}