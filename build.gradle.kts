plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    kotlin("plugin.jpa") version "1.9.25"

    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.google.cloud.tools.jib") version "3.4.5"
    id("org.jlleitschuh.gradle.ktlint").version("12.2.0")
}

allprojects {
    group = "_9dev.study"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "com.google.cloud.tools.jib")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    kotlin {
        compilerOptions {
            freeCompilerArgs.addAll("-Xjsr305=strict")
        }
        jvmToolchain(21)
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
