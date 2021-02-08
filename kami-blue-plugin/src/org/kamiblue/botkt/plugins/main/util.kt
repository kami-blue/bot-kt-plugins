package org.kamiblue.botkt.plugins.main

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.charsets.*
import org.kamiblue.botkt.Main

suspend fun isNon200Response(url: String): Boolean {
    return try {
        (Main.discordHttp.get<HttpStatusCode> {
            url(url)
        }.value == 200)
    } catch (e: MalformedInputException) { // for some reason HttpStatusCode throws an exception on 404
        false
    }
}
