package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.ConfigType
import org.kamiblue.botkt.ResponseConfig
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.manager.managers.ConfigManager
import org.kamiblue.botkt.manager.managers.ResponseManager

object XiaroCommand : BotCommand(
    name = "xiaro",
    category = Category.FUN
) {
    private val regex = Regex("(<@.*>|@everyone|@here)")
    private val config get() = ConfigManager.readConfigSafe<ResponseConfig>(ConfigType.RESPONSE, false)

    init {
        greedy("content") { contentArg ->
            execute {
                if (message.member?.bot != false) return@execute

                val config = config!!
                val response = ResponseManager.getCachedResponse(config)

                if (!regex.containsMatchIn(contentArg.value)) {
                    ResponseManager.shouldRespond(config, message, response.first)?.let {
                        if (it.deleteMessage) return@execute
                    }
                    channel.send("Trans rights~! " + contentArg.value)
                }
            }
        }
    }
}
