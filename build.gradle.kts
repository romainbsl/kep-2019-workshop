import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    application
}

repositories {
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/ktor") }
}

application {
    mainClassName = "kep.workshop.ApplicationKt"
}

dependencies {
    val ktorVersion = "1.2.5"

    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    // Ktor modules
    implementation("io.ktor:ktor:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    // Logging
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}