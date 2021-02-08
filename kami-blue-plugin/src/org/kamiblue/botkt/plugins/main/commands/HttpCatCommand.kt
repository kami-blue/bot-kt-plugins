package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.command.MessageExecuteEvent
import org.kamiblue.botkt.plugins.main.isNon200Response

object HttpCatCommand : BotCommand(
    name = "httpcat",
    alias = arrayOf("http"),
    category = Category.FUN
) {
    init {
        execute {
            sendCat(404)
        }

        int("http code") { intArg ->
            execute {
                sendCat(intArg.value)
            }
        }

        greedy("anything") {
            execute {
                sendCat(404)
            }
        }
    }

    private suspend fun MessageExecuteEvent.sendCat(code: Int) {
        if (code == 404) {
            channel.send("https://http.cat/$code")
        } else {
            val fixedCode = if (isNon200Response("https://http.cat/$code")) 404 else code
            channel.send("https://http.cat/$fixedCode")
        }
    }
}
