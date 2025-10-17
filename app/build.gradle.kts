plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("com.google.devtools.ksp")            // Apply KSP here
    id("com.google.dagger.hilt.android")    // Apply Hilt here
    kotlin("plugin.serialization") version "2.2.0"
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.epiceats"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.epiceats"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Hilt requires Java 8 features
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // AndroidX + Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.ui)
    implementation(libs.material3)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:34.4.0"))

    //auth
    implementation("com.google.firebase:firebase-auth")

    //firestore
    implementation("com.google.firebase:firebase-firestore")



    // Hilt (KSP)
    implementation("com.google.dagger:hilt-android:2.57.1")
    ksp("com.google.dagger:hilt-android-compiler:2.57.1")
    // hiltViewModel() support in Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:5.0.5")
    implementation("com.github.bumptech.glide:compose:1.0.0-beta08")

    // Coil
    implementation("io.coil-kt:coil-compose:2.7.0")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.9.4")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

    // Pager
    implementation("com.google.accompanist:accompanist-pager:0.36.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.36.0")

    // Payment Gateway
    implementation("com.razorpay:checkout:1.6.41")

    // Custom Bottom Nav Bar
    implementation("com.canopas.compose-animated-navigationbar:bottombar:1.0.2")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:6.6.9")

    // System UI Controller
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")

    // Material Icons
    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    //Splash Screen
    implementation("androidx.core:core-splashscreen:1.0.1")
}
