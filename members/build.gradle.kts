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
    implementation(libs.ktor.server.core)
    implementation(libs.serialization.core)
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)

    implementation(libs.exposed.r2dbc)
    implementation(libs.s3)

    implementation(project(":event-bus"))
    implementation(project(":shared"))
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(25)
}
