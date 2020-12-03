
plugins {
    id("com.android.application")

    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

dependencies {
    implementation(project(":common"))
    implementation(project(":common-android"))

    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    implementation("androidx.appcompat:appcompat:1.3.0-alpha02")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.fragment:fragment-ktx:1.2.5")
    implementation("androidx.recyclerview:recyclerview:1.1.0")

    implementation("com.google.android.material:material:1.2.1")

    // Filament - https://github.com/google/filament
    implementation("com.google.android.filament:filament-android:1.9.5")
    implementation("com.google.android.filament:filament-utils-android:1.9.5")
    implementation("com.google.android.filament:gltfio-android:1.9.5")

    // Firebase - https://firebase.google.com/docs/android/setup#available-libraries
    implementation(platform("com.google.firebase:firebase-bom:25.12.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-database-ktx")

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

    // Networking
    implementation("com.squareup.okhttp3:okhttp:4.9.0") // https://square.github.io/okhttp/changelog/
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:4.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.8.1") // https://github.com/square/retrofit/blob/master/CHANGELOG.md
    implementation("com.squareup.retrofit2:converter-gson:2.8.1")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.8.1")

    // Image loading
    implementation("io.coil-kt:coil:1.0.0") // https://github.com/coil-kt/coil/releases

    // Unit Tests
    testImplementation("com.github.stephanenicolas.toothpick:toothpick-testing-junit4:3.1.0")
    testImplementation("com.nhaarman:mockito-kotlin-kt1.1:1.5.0")
    testImplementation("junit:junit:4.13.1")
    kaptTest("com.github.stephanenicolas.toothpick:toothpick-compiler:3.1.0")

    // Instrumentation Tests
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    implementation(kotlin("script-runtime"))
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId("com.example.vanilla")
        minSdkVersion(29)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildFeatures {
        viewBinding = true
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
