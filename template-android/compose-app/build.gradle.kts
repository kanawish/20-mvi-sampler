import kotlin.reflect.KClass
import kotlin.reflect.KVisibility
import kotlin.reflect.full.declaredMemberProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

val composeVersion = "1.0.0-alpha07" // NOTE: Used in composeOptions {}, check it matches dependencies.

dependencies {
    implementation(kotlin("stdlib"))

    implementation ("androidx.core:core-ktx:1.3.2")
    // Was getting weird intellisense errors.
    // https://stackoverflow.com/questions/61381545/cannot-access-androidx-activity-result-activityresultcaller
    implementation ("androidx.appcompat:appcompat:1.3.0-alpha02")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    kapt("androidx.lifecycle:lifecycle-common-java8:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    implementation("androidx.com.example.compose.animation:animation:1.0.0-alpha07")
    implementation("androidx.com.example.compose.foundation:foundation:1.0.0-alpha07")
    implementation("androidx.com.example.compose.foundation:foundation-layout:1.0.0-alpha07")
    implementation("androidx.com.example.compose.material:material:1.0.0-alpha07")
    implementation("androidx.com.example.compose.material:material-icons-extended:1.0.0-alpha07")
    implementation("androidx.com.example.compose.runtime:runtime:1.0.0-alpha07")
    implementation("androidx.com.example.compose.runtime:runtime-livedata:1.0.0-alpha07")
    implementation("androidx.com.example.compose.ui:ui:1.0.0-alpha07")
    implementation("androidx.ui:ui-tooling:1.0.0-alpha07")

    implementation ("com.google.android.material:material:1.2.1")

    // Filament - https://github.com/google/filament
    implementation("com.google.android.filament:filament-android:1.9.5")
    implementation("com.google.android.filament:filament-utils-android:1.9.5")
    implementation("com.google.android.filament:gltfio-android:1.9.5")

    // Logging
    implementation ("com.jakewharton.timber:timber:4.7.1") // https://github.com/JakeWharton/timber/releases

    // DI - https://github.com/stephanenicolas/toothpick/releases
    implementation ("com.github.stephanenicolas.toothpick:ktp:3.1.0")
    implementation ("com.github.stephanenicolas.toothpick:smoothie-androidx:3.1.0")
    implementation ("com.github.stephanenicolas.toothpick:smoothie-lifecycle-ktp:3.1.0")
    implementation ("com.github.stephanenicolas.toothpick:smoothie-lifecycle-viewmodel-ktp:3.1.0")
    kapt ("com.github.stephanenicolas.toothpick:toothpick-compiler:3.1.0")

    // RxJava
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1") // https://github.com/ReactiveX/RxAndroid/blob/2.x/CHANGES.md
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0") // https://github.com/ReactiveX/RxKotlin/releases
    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.0") // https://github.com/JakeWharton/RxRelay/blob/master/CHANGELOG.md

    // Networking
    implementation("com.squareup.okhttp3:okhttp:4.9.0") // https://square.github.io/okhttp/changelog/
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.squareup.okhttp3:okhttp-urlconnection:4.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.8.1") // https://github.com/square/retrofit/blob/master/CHANGELOG.md
    implementation ("com.squareup.retrofit2:converter-gson:2.8.1")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.8.1")

    // Image loading
    implementation("io.coil-kt:coil:1.0.0") // https://github.com/coil-kt/coil/releases

    // UI / Contour
    implementation("app.cash.contour:contour:1.0.0") // https://github.com/cashapp/contour

    // Unit Tests
    testImplementation ("junit:junit:4.13.1")

    // Instrumentation Tests
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "com.example.com.example.compose"
        minSdkVersion(29)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner ("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    sourceSets["main"].java.srcDir("src/main/kotlin")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.4.0"
        kotlinCompilerExtensionVersion = composeVersion
    }

    packagingOptions {
        exclude("META-INF/atomicfu.kotlin_module")
    }

    aaptOptions {
        noCompress("filamat", "ktx", "glb")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check", "-Xskip-metadata-version-check")
    }
}
