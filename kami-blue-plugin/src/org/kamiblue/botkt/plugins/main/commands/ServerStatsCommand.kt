package org.kamiblue.botkt.plugins.main.commands

import com.google.gson.annotations.SerializedName
import io.ktor.client.request.*
import io.ktor.http.*
import org.kamiblue.botkt.Main
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.Colors
import org.kamiblue.botkt.utils.error

object ServerStatsCommand : BotCommand(
    name = "serverstats",
    alias = arrayOf("serverstat", "stats", "stat"),
    category = Category.FUN
) {
    init {
        greedy("ip") { ipArg ->
            execute {
                val ip = ipArg.value.replace(" ", "%20")
                val url = "https://api.mcsrvstat.us/2/$ip"

                try {
                    val server = Main.httpClient.get<Server> {
                        url(url)
                    }

                    channel.send {
                        embed {
                            field(
                                "IP / Hostname",
                                "${server.ip}:${server.port}\n${server.hostname}"
                            )
                            field("MOTD", server.motd.message())
                            field(
                                "Online Players / Max Players",
                                "${server.players.online} / ${server.players.max}"
                            )
                            field(
                                "Server Version / Brand",
                                "${server.version}\n${server.serverBrand ?: "Unknown Server Brand"}"
                            )

                            thumbnailUrl = server.getIcon(ip)
                            footer("ID: ${message.author?.id}", message.author?.avatar?.url)
                            color = Colors.PRIMARY.color
                        }
                    }
                } catch (e: Exception) {
                    Main.logger.debug("Error in StatsCommand", e)
                    channel.error("Could not find an online server with IP `$ip`!")
                    return@execute
                }
            }
        }
    }

    private fun MessageOfTheDay?.message() = this?.clean?.joinToString(" ") ?: "No MOTD!"

    private class Server(
        val ip: String,
        val port: Int,
        val motd: MessageOfTheDay?,
        val players: PlayerCount,
        val version: String,
        val hostname: String,
        @SerializedName("software")
        val serverBrand: String?
    ) {
        fun getIcon(ip: String) = "https://api.mcsrvstat.us/icon/$ip"
    }

    @Suppress("CanBeParameter", "unused")
    private class MessageOfTheDay(
        val clean: List<String>?
    )

    private class PlayerCount(
        val online: Int,
        val max: Int
    )
}
