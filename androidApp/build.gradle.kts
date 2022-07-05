plugins {
    id("com.android.application")
    id("io.realm.kotlin")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.thugrzz.kodeinsample.android"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.activity:activity-ktx:1.5.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("org.kodein.di:kodein-di-framework-android-x:7.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
}