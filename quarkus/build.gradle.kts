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
    implementation("io.quarkus:quarkus-rest-jackson")
    implementation("io.quarkus:quarkus-hibernate-validator")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured:5.5.0")
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}