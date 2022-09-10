// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.ANDROID_PLUGIN apply false
    id("com.android.library") version Versions.ANDROID_PLUGIN apply false
    id("org.jetbrains.kotlin.android") version Versions.KOTLIN apply false
}

tasks {
    val clean by registering(Delete::class) {
        delete(rootProject.buildDir)
    }
}


buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
    }
}