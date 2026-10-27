plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.serialization.plugin)
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.coroutines.core)

}

kotlin {
    jvmToolchain(25)
}