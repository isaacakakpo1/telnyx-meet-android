package com.telnyx.meet.shared

import kotlinx.serialization.Serializable

/**
 * Minimal serializable model used to validate the shared serialization setup.
 * Business models will be migrated in later tasks.
 */
@Serializable
data class PlatformInfo(
    val platform: String,
    val greeting: String,
)

/**
 * Returns the human-readable name of the platform running this code.
 */
expect fun platformName(): String

/**
 * Tiny shared entry point proving that common code can call platform code and
 * serialize its result. It intentionally contains no meeting or Rooms logic.
 */
class Greeting {
    fun message(): String = "Hello from ${platformName()}"

    fun info(): PlatformInfo = PlatformInfo(
        platform = platformName(),
        greeting = message(),
    )
}
