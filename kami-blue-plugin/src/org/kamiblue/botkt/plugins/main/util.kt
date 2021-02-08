package org.kamiblue.botkt.plugins.main

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.charsets.*
import org.kamiblue.botkt.Main

suspend fun urlResponseCode(url: String): Int {
    return try {
        Main.discordHttp.get<HttpStatusCode> {
            url(url)
        }.value
    } catch (e: MalformedInputException) { // for some reason HttpStatusCode throws an exception on 404
        404
    }
}
