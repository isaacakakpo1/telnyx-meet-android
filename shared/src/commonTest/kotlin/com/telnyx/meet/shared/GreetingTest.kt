package com.telnyx.meet.shared

import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingTest {
    @Test
    fun messageUsesThePlatformName() {
        assertEquals("Hello from ${platformName()}", Greeting().message())
    }

    @Test
    fun platformInfoRoundTripsThroughJson() {
        val info = Greeting().info()
        val decoded = Json.decodeFromString<PlatformInfo>(Json.encodeToString(info))

        assertEquals(info, decoded)
    }

    @Test
    fun commonCodeRunsOnStructuredCoroutines() = runTest {
        assertEquals("Hello from ${platformName()}", Greeting().message())
    }
}
