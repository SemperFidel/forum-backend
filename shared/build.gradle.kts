plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.rethis)
    implementation(libs.serialization.json)

    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(25)
}