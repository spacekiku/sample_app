plugins {
    `java-library`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    // Mirror vulnerable deps to surface in Dependency graph
    api("com.squareup.okhttp3:okhttp:3.12.0")
}
