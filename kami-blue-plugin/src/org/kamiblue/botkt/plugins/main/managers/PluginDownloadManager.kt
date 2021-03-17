package org.kamiblue.botkt.plugins.main.managers

import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import net.ayataka.kordis.event.events.message.MessageReceiveEvent
import org.kamiblue.botkt.Main
import org.kamiblue.botkt.PermissionTypes
import org.kamiblue.botkt.Permissions.hasPermission
import org.kamiblue.botkt.command.commands.system.ExceptionCommand
import org.kamiblue.botkt.manager.Manager
import org.kamiblue.botkt.utils.Colors
import org.kamiblue.botkt.utils.error
import org.kamiblue.botkt.utils.normal
import org.kamiblue.event.listener.asyncListener
import java.io.File

object PluginDownloadManager : Manager {
    private const val fileName = "kami-blue-plugin.jar"

    init {
        asyncListener<MessageReceiveEvent> { event ->
            try {
                val pluginMsg = event.message
                val channel = pluginMsg.serverChannel ?: return@asyncListener
                val attachments =
                    if (!event.message.attachments.isEmpty()) pluginMsg.attachments else return@asyncListener

                if (channel.id != 699982782515904603 && channel.id != 792012270179844126) return@asyncListener
                if (!pluginMsg.author.hasPermission(PermissionTypes.MANAGE_PLUGINS)) return@asyncListener
                if (!attachments.any { it.filename == fileName }) return@asyncListener

                val attachment =
                    attachments.find { it.filename == fileName } ?: return@asyncListener

                val url = attachment.url
                val time = System.currentTimeMillis()

                val deferred = coroutineScope {
                    async(Dispatchers.IO) {
                        val bytes = Main.httpClient.get<ByteArray> {
                            header("User-Agent", "")
                            url(url)
                        }
                        File("plugins/$fileName").writeBytes(bytes)
                    }
                }

                val message = channel.normal("Downloading plugin `$fileName` from URL <$url>...")

                deferred.join()
                val stopTime = System.currentTimeMillis() - time
                message.edit {
                    description = "Downloaded plugin `$fileName`, took $stopTime ms!"
                    color = Colors.SUCCESS.color
                }
            } catch (e: Exception) {
                ExceptionCommand.addException(e)
                Main.logger.error("Error in PluginDownloadManager", e)
                event.message.channel.error("Error in PluginDownloadManager, use `;exception` to view it")
            }
        }
    }
}