plugins {
    id("com.android.library")

    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")

    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")

    implementation("com.google.android.material:material:1.2.1")

    // Filament - https://github.com/google/filament
    implementation("com.google.android.filament:filament-android:1.9.5")
    implementation("com.google.android.filament:filament-utils-android:1.9.5")
    implementation("com.google.android.filament:gltfio-android:1.9.5")

    // Logging
    implementation("com.jakewharton.timber:timber:4.7.1") // https://github.com/JakeWharton/timber/releases

    // DI - https://github.com/stephanenicolas/toothpick/releases
    implementation("com.github.stephanenicolas.toothpick:ktp:3.1.0")
    implementation("com.github.stephanenicolas.toothpick:smoothie-androidx:3.1.0")
    implementation("com.github.stephanenicolas.toothpick:smoothie-lifecycle-ktp:3.1.0")
    implementation("com.github.stephanenicolas.toothpick:smoothie-lifecycle-viewmodel-ktp:3.1.0")
    kapt("com.github.stephanenicolas.toothpick:toothpick-compiler:3.1.0")

    // RxJava
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1") // https://github.com/ReactiveX/RxAndroid/blob/2.x/CHANGES.md
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0") // https://github.com/ReactiveX/RxKotlin/releases
    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.0") // https://github.com/JakeWharton/RxRelay/blob/master/CHANGELOG.md

    // Unit Tests
    testImplementation ("com.github.stephanenicolas.toothpick:toothpick-testing-junit4:3.1.0")
    testImplementation("com.nhaarman:mockito-kotlin-kt1.1:1.5.0")
    testImplementation("junit:junit:4.13.1")
    kaptTest ("com.github.stephanenicolas.toothpick:toothpick-compiler:3.1.0")

    // Instrumentation Tests
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion (23)
        targetSdkVersion (30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner ("androidx.test.runner.AndroidJUnitRunner")
        consumerProguardFiles ("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}
