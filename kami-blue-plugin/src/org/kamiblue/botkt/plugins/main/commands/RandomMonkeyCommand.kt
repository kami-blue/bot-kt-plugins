package org.kamiblue.botkt.plugins.main.commands

import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category

object RandomMonkeyCommand : BotCommand(
    name = "randommonkey",
    alias = arrayOf("funnymonkey", "hause"),
    category = Category.FUN
) {
    private val monkeys = listOf(
        "https://bigrat.monster/media/monkeys/CwQRLGK.mp4?.gif",
        "https://bigrat.monster/media/monkeys/Monkey_Orange.gif",
        "https://bigrat.monster/media/monkeys/ShallowUnhealthyDeermouse-size_restricted.gif",
        "https://bigrat.monster/media/monkeys/chimp.gif",
        "https://bigrat.monster/media/monkeys/curiouswhat.gif",
        "https://bigrat.monster/media/monkeys/monkeyboat.gif",
        "https://bigrat.monster/media/monkeys/monkeydabke.gif",
        "https://bigrat.monster/media/monkeys/monkeylick.gif",
        "https://bigrat.monster/media/monkeys/monkeymoney.gif",
        "https://bigrat.monster/media/monkeys/orangutan.gif",
        "https://bigrat.monster/media/monkeys/piere.gif",
        "https://bigrat.monster/media/monkeys/telephonemonkey.gif",
        "https://cdn.discordapp.com/attachments/634010567107149824/756703349541437469/video0.mp4",
        "https://cdn.discordapp.com/attachments/634510679465918474/761378483515293706/video0.mp4",
        "https://cdn.discordapp.com/attachments/634510679465918474/761683469884981288/video0.mp4",
        "https://cdn.discordapp.com/attachments/710891361615740948/762005749588426762/video0.mp4",
        "https://cdn.discordapp.com/attachments/710891361615740948/762005767351566336/video0.mp4",
        "https://cdn.discordapp.com/attachments/710891361615740948/762005798041026640/video0.mp4",
        "https://cdn.discordapp.com/attachments/710891361615740948/762005826574745680/video0.mp4",
        "https://cdn.discordapp.com/attachments/710891361615740948/762005840240443402/video0.mov",
        "https://cdn.discordapp.com/attachments/710891361615740948/762005845424734238/video0.mp4",
        "https://cdn.discordapp.com/attachments/710891361615740948/762005728479150110/video0.mp4",
        "https://cdn.discordapp.com/attachments/710891361615740948/762014906039271524/video0.mp4"
    )

    init {
        execute {
            channel.send(monkeys.random())
        }
    }
}
