// Root build configuration. All plugin and dependency versions are managed by
// gradle/libs.versions.toml so the toolchain has a single source of truth.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.compose.multiplatform) apply false
}

tasks.register<Delete>("clean") {
    delete(layout.buildDirectory)
}
