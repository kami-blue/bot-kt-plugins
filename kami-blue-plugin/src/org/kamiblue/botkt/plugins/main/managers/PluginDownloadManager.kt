package org.kamiblue.botkt.plugins.main.managers

import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import net.ayataka.kordis.event.events.message.MessageReceiveEvent
import org.kamiblue.botkt.Main
import org.kamiblue.botkt.PermissionTypes
import org.kamiblue.botkt.Permissions.hasPermission
import org.kamiblue.botkt.manager.Manager
import org.kamiblue.botkt.utils.success
import org.kamiblue.event.listener.asyncListener
import java.io.File

object PluginDownloadManager : Manager {
    private const val fileName = "kami-blue-plugin.jar"

    init {
        asyncListener<MessageReceiveEvent> { event ->
            runBlocking {
                val pluginMsg = event.message
                val channel = pluginMsg.serverChannel ?: return@runBlocking
                val attachments =
                    if (!event.message.attachments.isEmpty()) pluginMsg.attachments else return@runBlocking

                if (channel.id != 821815442510970940 && channel.id != 792012270179844126) return@runBlocking
                if (!pluginMsg.author.hasPermission(PermissionTypes.MANAGE_PLUGINS)) return@runBlocking
                if (!attachments.any { it.filename == fileName }) return@runBlocking

                val attachment =
                    attachments.find { it.filename == fileName } ?: return@runBlocking

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

                deferred.join()

                val stopTime = System.currentTimeMillis() - time
                channel.success("Downloaded plugin `$fileName`, took $stopTime ms!")
            }
        }
    }
}