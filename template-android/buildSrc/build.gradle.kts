repositories {
    mavenCentral()
    jcenter()
    google()
}

plugins {
    `kotlin-dsl` // Took this from Jetcaster example. [Needed? TBD]
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.20")
}
