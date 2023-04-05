buildscript {

    repositories {
        google()  // Google's Maven repository
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath("com.google.gms:google-services:4.3.15")
        // Add the Crashlytics Gradle plugin
//        classpath "com.google.firebase:firebase-crashlytics-gradle:2.9.2"
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.45")   // For hilt


//        classpath("com.google.protobuf:protobuf-gradle-plugin:0.9.2")

    }

}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-alpha11" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0-alpha11" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}