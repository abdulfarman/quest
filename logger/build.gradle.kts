import com.azabost.quest.build.Config

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.azabost.logger"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget = Config.kotlinJvmTarget
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":config"))
    implementation(project(":analytics")) //Circular dependency with analytics


    // Hilt
    implementation(libs.hilt.core)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.javax.inject)


    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}
