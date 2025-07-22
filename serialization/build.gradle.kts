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
    // coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Hilt
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
    implementation(libs.javax.inject)

    // serialization
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.json)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinxSerialization)

    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}
