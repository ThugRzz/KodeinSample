buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("io.realm.kotlin:gradle-plugin:1.0.0")
    }
}

rootProject.extra["realmVersion"] = "1.0.0"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://dl.bintray.com/kodein-framework/kodein-dev")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}