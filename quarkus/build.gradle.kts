plugins {
    id("java")
    id("io.quarkus")
}

repositories {
    mavenCentral()
}

dependencies {
    val quarkusPlatformGroupId: String by project
    val quarkusPlatformArtifactId: String by project
    val quarkusPlatformVersion: String by project

    implementation(enforcedPlatform("$quarkusPlatformGroupId:$quarkusPlatformArtifactId:$quarkusPlatformVersion"))
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-messaging-mqtt")

    testImplementation("io.quarkus:quarkus-junit5")
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}