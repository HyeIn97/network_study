object Dependency {
    object Versions {
        // AndroidX
        const val ACTIVITY_VERSION = "1.9.2"
        const val FRAGMENT_VERSION = "1.8.4"
        const val COROUTINES_VERSION = "1.3.9"
        const val LIFECYCLE_VERSION = "2.8.5"
        const val CORE_VERSION = "1.13.1"

        // Library
        const val HILT_VERSION = "2.48"
        const val HILT_COMPILER_VERSION = "2.48"
        const val NETWORK_VERSION = "2.11.0"
        const val GLIDE_VERSION = "4.16.0"
    }

    object View {
        const val ACTIVITY = "androidx.activity:activity-ktx:${Versions.ACTIVITY_VERSION}"
        const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_VERSION}"
    }

    object Lifecycle {
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:${Versions.CORE_VERSION}"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    }

    object Libraries {
        const val HILT = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT_COMPILER_VERSION}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.NETWORK_VERSION}"
        const val GSON = "com.google.code.gson:gson:${Versions.NETWORK_VERSION}"
        const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.NETWORK_VERSION}"
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    }
}