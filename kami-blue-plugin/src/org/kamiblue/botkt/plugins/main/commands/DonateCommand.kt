package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object DonateCommand : BotCommand(
    name = "donate",
    description = "Donation link and info",
    category = Category.INFO
) {
    init {
        execute {
            if (channel.id == 722436626248237076) {
                channel.normal(
                    title = "Пожертвовать",
                    description = "Вы можете поддержать разработчиков клиента задонатив небольшую сумму используя платежную систему PayPal.\nПри донате от $5 вы можете получить специальный плащ KAMI Blue, который будет виден всем кто использует KAMI Blue.\nСсылка на PayPal: https://kamiblue.org/donate"
                )
            } else {
                channel.normal(
                    title = "Donate",
                    description = "You can support developers of KAMI Blue for a small amount using PayPal.\nIf you donate from $5 you receive a donator cape, and are allowed to disable or change the watermark in game, and also receive a neat role on the Discord. In the future, you will also be able to download donor only and free plugins.\n\nPayPal donation link: https://kamiblue.org/donate"
                )
            }
        }
    }
}
