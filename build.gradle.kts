import io.gitlab.arturbosch.detekt.detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    dependencies {
        classpath(Libs.com_android_tools_build_gradle)
        classpath(Libs.kotlin_gradle_plugin)
        classpath(Libs.apollo_gradle_plugin)
        classpath(Libs.android_junit5)
    }
}
plugins {
    id("de.fayard.buildSrcVersions") version "0.3.2"
    id("io.gitlab.arturbosch.detekt") version "1.0.0-RC14"
}

detekt {
    toolVersion = "1.0.0-RC14"
    input = files("$projectDir/app/src/main/java")
    config = files("$projectDir/default-detekt-config.yml")
    filters = ".*test.*,.*/resources/.*,.*/tmp/.*"
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
