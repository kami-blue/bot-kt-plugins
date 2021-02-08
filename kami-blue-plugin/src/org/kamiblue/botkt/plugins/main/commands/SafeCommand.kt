package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object SafeCommand : BotCommand(
    name = "safe",
    category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                title = "Is KAMI Blue safe?",
                description = "**TL:DR Yes, it is.**\n\n" +
                "KAMI Blue is open source and publically auditable. You can view the full source code [here](https://github.com/kami-blue/client).\n" +
                "You can view instructions for building a jar from source [here](https://kamiblue.org/contributing).\n" +
                "Signed commits are required, with signed releases being published by l1ving. " +
                "Both members have full write access to the organization, with both members having **2fa** protection on their Github Account.\n" +
                "If a commit is not signed, it is **imperative** that you check the contents of the commit yourself, if you'd like to be sure it is safe (ie a pull request was merged without signed commits).\n" +
                "If the signature is invalid, do not trust that jar, that means it's possible one of our github accounts was hacked.\n\n" +
                "Keep in mind, the likelyhood of having a Github account with **2fa** and proper password security being hacked is **extremely low**. Liv uses a 12 word + special characters standard, which is virtually uncrackable in the heat death of the universe, along with Github hashing the password, and the commits being signed by **4096 bit RSA**, with iBuyMountainDew using similar security.")
        }
    }
}
