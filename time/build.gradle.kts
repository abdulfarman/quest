plugins {
    alias(libs.plugins.kotlin.jvm) // Use the Kotlin JVM plugin
    alias(libs.plugins.ksp)
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
}