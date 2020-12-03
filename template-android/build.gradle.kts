plugins {
    id("com.android.application") version "4.2.0-alpha14" apply false
    kotlin("android") version "1.4.10" apply false
}

buildscript {
    val kotlinVersion by extra("1.4.10")
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
