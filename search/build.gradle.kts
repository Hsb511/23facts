plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}


android {
    compileSdk = 32

    defaultConfig {
        minSdk = 26
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
}

dependencies {
    // Compose
    implementation("androidx.compose.compiler:compiler:${Versions.COMPOSE}")
    implementation("androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}")
    implementation("androidx.compose.material:material:${Versions.COMPOSE}")
    implementation("androidx.compose.ui:ui:${Versions.COMPOSE}")
    implementation("androidx.compose.ui:ui-viewbinding:${Versions.COMPOSE}")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:${Versions.COMPOSE}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01")
    debugImplementation("androidx.customview:customview:1.2.0-alpha01")
    debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0")
    implementation("androidx.navigation:navigation-compose:2.5.1")
    implementation("io.coil-kt:coil-compose:${Versions.COIL}")
    implementation("io.coil-kt:coil-svg:${Versions.COIL}")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.HILT}")

    implementation("org.jsoup:jsoup:1.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation(project(":domain"))
    implementation(project(":room"))
    implementation(project(":home"))

    implementation("androidx.core:core-ktx:${Versions.ANDROID_CORE}")
    implementation("androidx.appcompat:appcompat:1.5.0")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}