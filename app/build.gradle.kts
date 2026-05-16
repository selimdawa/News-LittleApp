plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //id("kotlin-kapt")
    //id("com.google.dagger.hilt.android")
    //id("dagger.hilt.android.plugin")
    //id("org.jetbrains.kotlin.plugin.serialization")
    //id("kotlin-parcelize")


    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.littleapp.news"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.littleapp.news"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.preference.ktx)           //Shared Preference
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //Layout
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.cardview)
    // Hilt dependencies
    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.59.2")
    ksp("com.google.dagger:hilt-android-compiler:2.59.2")
    ksp("androidx.hilt:hilt-compiler:1.3.0")                          //Hilt Compiler
    ksp("com.google.dagger:hilt-compiler:2.59.2")              //Hilt Compiler

    //implementation("com.google.dagger:hilt-android:2.44.2")     //Dagger Hilt
    //kapt("com.google.dagger:hilt-android-compiler:2.44.2")      //Dagger Hilt Compiler
    //kapt("androidx.hilt:hilt-compiler:1.0.0")                          //Hilt Compiler
    //kapt("com.google.dagger:hilt-compiler:2.44.2")              //Hilt Compiler
    //retrofit dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")  //Navigation Fragment
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3") //Navigation Components
    // serialization dependencies
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

    //implementation("androidx.compose.runtime:runtime-livedata:1.8.0")

    //implementation("io.coil-kt.coil3:coil-compose:3.1.0")
    //implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")
    //Life Cycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")     //Life Cycle Extensions
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.10.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.10.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0")

    //OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0")) //OkHttp
    implementation("com.squareup.okhttp3:okhttp")                      //OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor")         //OkHttp
    //Others
    implementation("io.coil-kt:coil:2.2.2")                            //Coil
    implementation("com.jakewharton.timber:timber:5.0.1")              //Timber Log
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6") //Binding
}