import com.azabost.quest.build.Config

plugins {
    alias(libs.plugins.kotlin.jvm) // Use the Kotlin JVM plugin
    alias(libs.plugins.ksp)
    // If you were using any other KSP processors for pure Kotlin (not Android specific), keep them.
    // e.g., alias(libs.plugins.kotlin.serialization) if you use kotlinx.serialization here for non-Android purposes.
}

kotlin {
    kotlin {
        jvmToolchain(17)
    }
}
dependencies {

    // Hilt
    implementation(libs.hilt.core)
    implementation(libs.javax.inject)
    ksp(libs.hilt.compiler)

    // Kotlin standard library is essential

    // --- IMPORTANT: Replace Android-specific time libraries ---
    // If you were using Android's time classes or ThreeTenABP (which is often for older Android),
    // you should now use kotlinx-datetime or java.time (available in Java 8+).

    // Example: If you want to use kotlinx-datetime
    // implementation(libs.kotlinx.datetime) // Make sure you have this in your libs.versions.toml

    // Keep any other pure Kotlin/Java dependencies this module needs.
    // For example, if you were using a logging facade that's not Android-specific:
    // implementation(libs.some.logging.facade)

    // Test dependencies
    // testImplementation(libs.kotlinx.coroutines.test) // If you test coroutines
    // testImplementation(libs.kotest.assertions.core) // If you use Kotest
}