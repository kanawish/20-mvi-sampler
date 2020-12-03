import kotlin.reflect.full.declaredMemberProperties

// Just an example, tbd if it fits the bill for all projects.
object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.2.0-alpha14"
    const val jdkDesugar = "com.android.tools:desugar_jdk_libs:1.0.10"

    const val junit = "junit:junit:4.13"

    const val material = "com.google.android.material:material:1.2.1"

    object Accompanist {
        private const val version = "0.3.1"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
    }

    object Kotlin {
        private const val version = "1.4.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.3.9"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object OkHttp {
        private const val version = "4.7.2"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }
}

fun main() {
    Libs.javaClass.kotlin.declaredMemberProperties.forEach {
        println("name: ${it.name}")
    }
}
