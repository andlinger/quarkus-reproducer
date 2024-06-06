pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        val quarkusPluginVersion: String by settings
        id("io.quarkus") version quarkusPluginVersion
    }
}

include(":quarkus")