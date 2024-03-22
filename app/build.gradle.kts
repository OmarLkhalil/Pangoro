plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.apollographql.apollo3").version("3.7.3")
    id("dagger.hilt.android.plugin")
}

apollo {
    service("service") {
        packageName.set("com.plcoding")
    }
}
@Suppress("UnstableApiUsage")
android {
    compileSdk = 33
    namespace = "com.composable.pangoro"
    defaultConfig {
        applicationId = "com.composable.pangoro"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    configurations {
        implementation{
            resolutionStrategy.failOnVersionConflict()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    with(packagingOptions) {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    val compose_ui_version = "1.2.0"
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation("androidx.compose.ui:ui:$compose_ui_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_ui_version")
    implementation("androidx.compose.material:material:1.4.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_ui_version")
    debugImplementation("androidx.compose.ui:ui-tooling:$compose_ui_version")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_ui_version")
    implementation("com.apollographql.apollo3:apollo-runtime:3.8.3")

    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Coil
    implementation ("io.coil-kt:coil-compose:2.2.2")
    implementation ("com.google.accompanist:accompanist-coil:0.10.0")

}