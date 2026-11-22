// Root build configuration. All plugin and dependency versions are managed by
// gradle/libs.versions.toml so the toolchain has a single source of truth.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.navigation.safeargs) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.bugsnag) apply false

    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.kover)
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    configurations.all {
        resolutionStrategy.force("org.objenesis:objenesis:3.2")
    }
}

tasks.register<Delete>("clean") {
    delete(layout.buildDirectory)
}
