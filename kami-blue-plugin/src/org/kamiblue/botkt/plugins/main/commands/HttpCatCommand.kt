package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.command.MessageExecuteEvent
import org.kamiblue.botkt.plugins.main.urlResponseCode

object HttpCatCommand : BotCommand(
    name = "httpcat",
    description = "Http code as a cat picture",
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
            val fixedCode = if (urlResponseCode("https://http.cat/$code") == 404) 404 else code
            channel.send("https://http.cat/$fixedCode")
        }
    }
}
