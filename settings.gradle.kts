pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            // These plugins predate published Gradle plugin markers. Map their
            // ids to the actual plugin artifacts while keeping the versions in
            // gradle/libs.versions.toml.
            when (requested.id.id) {
                "androidx.navigation.safeargs",
                "androidx.navigation.safeargs.kotlin" ->
                    useModule("androidx.navigation:navigation-safe-args-gradle-plugin:${requested.version}")
                "com.bugsnag.android.gradle" ->
                    useModule("com.bugsnag:bugsnag-android-gradle-plugin:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "Telnyx Meet"
include(":app")
