import com.azabost.quest.build.Config

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.azabost.quest"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.azabost.modularization"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            val keystorePassword: String? = System.getenv("KEYSTORE_PASSWORD")
            val keyAlias: String? = System.getenv("KEY_ALIAS")
            val keyPassword: String? = System.getenv("KEY_PASSWORD")

            storeFile = file("release-keystore.jks")
            storePassword = keystorePassword
            keyAlias = keyAlias
            keyPassword = keyPassword
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // Use the signing config only if all secrets are available
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            // Optional: can still sign with debug keys if needed
        }
    }

    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget = Config.kotlinJvmTarget
    }
}

dependencies {
    implementation(project(":theme"))
    implementation(project(":analytics"))
    implementation(project(":lifecycle"))
    implementation(project(":serialization"))
    implementation(project(":share"))
    implementation(project(":time"))
    implementation(project(":network"))
    implementation(project(":posts"))
    implementation(project(":config"))
    implementation(project(":logger"))
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Hilt
    implementation(libs.hilt.core)
    implementation(libs.hilt.android)
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

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
