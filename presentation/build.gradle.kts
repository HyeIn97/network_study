plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":domain"))

    // View
    implementation(Dependency.View.ACTIVITY)
    implementation(Dependency.View.FRAGMENT)

    // Lifecycle
    implementation(Dependency.Lifecycle.LIFECYCLE)
    implementation(Dependency.Lifecycle.VIEWMODEL)

    // Hilt
    implementation(Dependency.Libraries.HILT)
    kapt(Dependency.Libraries.HILT_COMPILER)

    // androidX
    implementation(Dependency.AndroidX.CORE)
    implementation(Dependency.AndroidX.COROUTINES)

    //Glide
    implementation(Dependency.Libraries.GLIDE)
}

kapt {
    correctErrorTypes = true
}