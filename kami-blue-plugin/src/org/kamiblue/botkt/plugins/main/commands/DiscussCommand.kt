package org.kamiblue.botkt.plugins.main.commands

import net.ayataka.kordis.entity.server.permission.PermissionSet
import net.ayataka.kordis.entity.server.permission.overwrite.RolePermissionOverwrite
import org.kamiblue.botkt.PermissionTypes
import org.kamiblue.botkt.command.BotCommand
import org.kamiblue.botkt.command.Category
import org.kamiblue.botkt.command.options.HasPermission
import org.kamiblue.botkt.command.options.ServerOnly
import org.kamiblue.botkt.utils.Colors

object DiscussCommand : BotCommand(
    name = "discuss",
    category = Category.MODERATION,
    description = "Create and participate in Discussions"
) {
    init {
        literal("addon") {
            greedy("idea") { idea ->
                execute("Add to an existing discussion", ServerOnly, HasPermission.get(PermissionTypes.COUNCIL_MEMBER)) {
                    val server = server!!
                    val name = "t-" + server.channels.find(message.channel.id)!!.name.substring(2)
                    val discussionTopic = server.textChannels.findByName(name)!!

                    discussionTopic.send {
                        if (!message.attachments.isEmpty()) {
                            embed {
                                imageUrl = message.attachments.stream().findFirst().get().url
                                color = Colors.PRIMARY.color
                            }
                        } else { // needs to be else because you cannot embed images in the same message with content
                            embed {
                                author(name = message.author!!.name)
                                field("Added:", idea.value, false)
                                color = Colors.PRIMARY.color
                            }
                        }
                    }
                }
            }
        }

        string("topic") { topicArg ->
            greedy("description") { description ->
                execute("Create a new discussion topic", ServerOnly, HasPermission.get(PermissionTypes.COUNCIL_MEMBER)) {
                    val server = server!!
                    val upperCouncil = server.roles.findByName("upper council")!!
                    val lowerCouncil = server.roles.findByName("lower council")!!

                    val discussionCategory = server.channelCategories.findByName("discussions")

                    val allow = PermissionSet(1024) // allow reading
                    val deny = PermissionSet(2048) // disallow speaking

                    val topic = topicArg.value
                    val discussionTopic = server.createTextChannel {
                        this.category = discussionCategory
                        this.name = "t-$topic"
                    }

                    discussionTopic.send {
                        embed {
                            author(name = "${message.author!!.name} created $topic")
                            field("Topic", description.value, false)
                            color = Colors.PRIMARY.color
                        }
                    }

                    discussionTopic.edit {
                        this.rolePermissionOverwrites.add(RolePermissionOverwrite(upperCouncil, allow, deny))
                        this.rolePermissionOverwrites.add(RolePermissionOverwrite(lowerCouncil, allow, deny))
                    }

                    server.createTextChannel {
                        this.category = discussionCategory
                        this.name = "d-$topic"
                    }
                }
            }
        }
    }
}
