plugins {
    `java-library`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Mirror vulnerable deps to surface in Dependency graph
    api("com.squareup.okhttp3:okhttp:3.12.0")
    api("org.apache.commons:commons-compress:1.21")
    api("org.apache.logging.log4j:log4j-core:2.14.1")
}
