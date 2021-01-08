plugins {
    id("com.android.application") version "7.0.0-alpha04" apply false
    kotlin("android") version "1.4.21" apply false
}

buildscript {
    val kotlinVersion by extra("1.4.21")
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        google()
    }
}
