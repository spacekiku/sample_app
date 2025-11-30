// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    // For dependency update reports
    id("com.github.ben-manes.versions") version "0.51.0" apply false
}

// Enable the versions plugin at the root to run reports
subprojects {
    plugins.apply("com.github.ben-manes.versions")
}