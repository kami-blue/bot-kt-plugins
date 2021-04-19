package org.kamiblue.botkt.plugins.main

import org.kamiblue.botkt.Main
import org.kamiblue.botkt.plugin.Plugin
import org.kamiblue.botkt.plugins.main.commands.*
import org.kamiblue.botkt.plugins.main.managers.PingDeleteManager
import org.kamiblue.botkt.plugins.main.managers.PluginDownloadManager
import org.kamiblue.botkt.plugins.main.managers.ReactionLoggingManager

class KamiBluePlugin : Plugin() {

    override fun onLoad() {
        Main.logger.debug("KAMI Blue Plugin loading...\n" +
                "${commandList.joinToString { it.javaClass.simpleName }}\n" +
                managerList.joinToString { it.javaClass.simpleName }
        )

        commandList.forEach {
            commands.add(it)
        }

        managerList.forEach {
            managers.add(it)
        }

        Main.logger.debug("KAMI Blue Plugin loaded ${commandList.size} commands and ${managerList.size} managers!")
    }

    override fun onUnload() {
        Main.logger.debug("KAMI Blue Plugin unloaded!")
    }

    private val commandList = listOf(
        AnimeCommand,
        BaritoneHelpCommand,
        BigCatCommand,
        BigDogCommand,
        BigEarsCommand,
        BigMonkeyCommand,
        BigRatCommand,
        BigSnailCommand,
        CapeCommand,
        CASettingsCommand,
        ChristmasBigRatCommand,
        ContributingCommand,
        DiscussCommand,
        DonateCommand,
        ExportBansCommand,
        ExportEmojiCommand,
        ExportRolesCommand,
        GoogleCommand,
        GrayCommand,
        HttpCatCommand,
        InstallCommand,
        JarFixCommand,
        KamiCommand,
        KotlinCommand,
        LearnCommand,
        LogCommand,
        ModulesCommand,
        MonkeyCommand,
        RandomMonkeyCommand,
        SafeCommand,
        ServerStatsCommand,
        ShulkerPreviewCommand,
        SmallRatCommand,
        SmallSnailCommand,
        SpammerCommand,
        TroubleshootCommand,
        UpdatesRoleCommand
    )

    private val managerList = listOf(
        PingDeleteManager,
        PluginDownloadManager,
        ReactionLoggingManager
    )

}
