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
    mainClassName = "io.ktor.server.netty.EngineMain"
}

dependencies {
    val ktorVersion = "1.2.5"

    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    // Ktor modules
    implementation("io.ktor:ktor:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    // Database
    implementation("com.h2database:h2:1.4.200")
    implementation("com.zaxxer:HikariCP:3.3.1")
    implementation("org.jetbrains.exposed:exposed:0.17.6")
    // Logging
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}