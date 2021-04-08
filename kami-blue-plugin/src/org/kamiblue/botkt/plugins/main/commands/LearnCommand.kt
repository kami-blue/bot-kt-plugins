package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.utils.normal

object LearnCommand : BotCommand(
    name = "learn",
    description = "Learning to make a Minecraft mod",
    category = Category.INFO
) {
    init {
        execute {
            channel.normal(
                title = "Learning to make a Minecraft mod",
                description = "You need to be able to walk before you can run.\n" +
                    "In order to make a Minecraft mod, you should at least know the basics of Java or Kotlin first, these resources can help you learn the fundamentals of Java, Gradle, Forge and Kotlin.\n\n" +
                    "If you don't take the time to learn the languages you're working on, you **will** get tripped up by the smallest problem that could have been resolved if you actually learned. " +
                    "**No one will help you if you don't make an effort to learn first.**\n\n" +
                    "<https://docs.gradle.org/current/samples/sample_building_java_applications.html>\n" +
                    "<https://kotlinlang.org/docs/home.html>\n" +
                    "<https://www.codecademy.com/learn/learn-java/>\n" +
                    "<https://fabricmc.net/wiki/>\n" +
                    "<https://github.com/SpongePowered/Mixin/wiki/>"
            )
        }
    }
}
