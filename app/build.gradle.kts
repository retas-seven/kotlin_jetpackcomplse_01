plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.sample01"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sample01"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val media3_version = "1.2.0"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.media3:media3-common:$media3_version")
    // メディア再生のためのコアライブラリ
    implementation("androidx.media3:media3-exoplayer:$media3_version")
    // DASH（Dynamic Adaptive Streaming over HTTP）のサポート
    implementation("androidx.media3:media3-exoplayer-dash:$media3_version")
    // HLS（HTTP Live Streaming）サポート
    implementation("androidx.media3:media3-exoplayer-hls:$media3_version")
    // オーディオとビデオの同期に必要（かもしれない）：
    implementation("androidx.media3:media3-extractor:$media3_version")
    // カスタムデータローディングやネットワークのやり取り
    implementation("androidx.media3:media3-datasource:$media3_version")
    // メディア再生のUIコンポーネント
    implementation("androidx.media3:media3-ui:$media3_version")

    implementation("androidx.compose.material:material-icons-extended:1.3.0-beta03")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    kapt("com.google.dagger:dagger-compiler:2.42")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.23.1")
}