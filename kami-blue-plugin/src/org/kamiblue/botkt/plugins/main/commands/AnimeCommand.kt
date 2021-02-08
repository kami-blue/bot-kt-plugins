package org.kamiblue.botkt.plugins.main.commands

import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import io.ktor.client.request.*
import org.kamiblue.botkt.Main
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.command.MessageExecuteEvent
import org.kamiblue.botkt.utils.Colors
import org.kamiblue.botkt.utils.StringUtils.toHumanReadable
import org.kamiblue.botkt.utils.error
import org.kamiblue.botkt.utils.normal
import org.kamiblue.commons.extension.max
import kotlin.random.Random

object AnimeCommand : BotCommand(
    name = "anime",
    description = "Grabs random images from Safebooru",
    category = Category.FUN
) {
    init {
        literal("raw", "full") {
            execute {
                sendImage(false)
            }
        }

        execute {
            sendImage()
        }
    }

    private suspend fun MessageExecuteEvent.sendImage(embed: Boolean = true) {
        if (message.serverChannel?.nsfw != true) {
            channel.error("Safebooru sometimes returns non-safe images, so this command can only be run in an nsfw channel!")
            return
        }

        val url = "https://safebooru.org/index.php?page=dapi&s=post&q=index&pid=" +
            "${Random.nextInt(1, 3200000)}&limit=1&json=1&rating=safe"

        val msg =
            if (embed) channel.normal("Fetching image...")
            else channel.send("Fetching image...")

        try {
            val response = Main.httpClient.get<String> {
                url(url)
            }

            val images = getJson<List<LinkedTreeMap<String, Any>>>(response)
            val imageLink =
                "https://safebooru.org/images/${images[0]["directory"]}/${images[0]["image"]}"

            if (embed) {
                msg.edit {
                    imageUrl = imageLink
                    footer(
                        images[0]["tags"].toString().split(" ")
                            .joinToString { it.toHumanReadable() }.max(2048)
                    )
                    color = Colors.PRIMARY.color
                }
            } else {
                msg.edit(imageLink)
            }
        } catch (e: Exception) {
            Main.logger.debug("Error in AnimeCommand", e)
            channel.error("Error fetching image! Report this to the developers")
            return
        }
    }

    private inline fun <reified T> getJson(images: Any): T {
        return Gson().fromJson(images.toString(), T::class.java)
    }
}
