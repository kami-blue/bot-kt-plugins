package org.kamiblue.botkt.plugins.main

import org.kamiblue.botkt.Main
import org.kamiblue.botkt.plugin.Plugin
import org.kamiblue.botkt.plugins.main.commands.*
import org.kamiblue.botkt.plugins.main.managers.PluginDownloadManager
import org.kamiblue.botkt.plugins.main.managers.ReactionLoggingManager

class KamiBluePlugin : Plugin() {

    override fun onLoad() {
        Main.logger.debug("KAMI Blue Plugin loading...\n${commandList.joinToString { it.javaClass.simpleName }}")

        commandList.forEach {
            commands.add(it)
        }

        managers.add(PluginDownloadManager)
        managers.add(ReactionLoggingManager)

        Main.logger.debug("KAMI Blue Plugin loaded ${commandList.size} commands!")
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
        CASettingsCommand,
        ChristmasBigRatCommand,
        ContributingCommand,
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
        TroubleshootCommand,
        UpdatesRoleCommand,
        XRayCommand
    )

}
