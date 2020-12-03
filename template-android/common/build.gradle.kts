plugins {
    id ("java-library")

    kotlin("jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

// TODO: Shared versioning

dependencies {
    implementation(kotlin("stdlib"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")

    // DI
    implementation ("com.github.stephanenicolas.toothpick:ktp:3.1.0")
    kapt ("com.github.stephanenicolas.toothpick:toothpick-compiler:3.1.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")

    // RxJava
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0") // https://github.com/ReactiveX/RxKotlin/releases
    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.0") // https://github.com/JakeWharton/RxRelay/blob/master/CHANGELOG.md

    // Unit Tests
    testImplementation("com.nhaarman:mockito-kotlin-kt1.1:1.5.0")
    kaptTest ("com.github.stephanenicolas.toothpick:toothpick-compiler:3.1.0")
    testImplementation ("com.github.stephanenicolas.toothpick:toothpick-testing-junit4:3.1.0")
    testImplementation("junit:junit:4.13.1")

}
