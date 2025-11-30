plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.sample_app"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.sample_app"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.okhttp)
    implementation("com.squareup.okhttp3:okhttp:3.12.0")
    
    // Force safe versions to override vulnerable transitive dependencies
    implementation("io.netty:netty-codec-http2:4.1.115.Final")
    implementation("io.netty:netty-codec-http:4.1.115.Final")
    implementation("io.netty:netty-handler:4.1.115.Final")
    implementation("io.netty:netty-common:4.1.115.Final")
    implementation("org.jdom:jdom2:2.0.6.1")
    implementation("com.squareup.okio:okio:3.9.1")
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

configurations.all {
    resolutionStrategy {
        force(
            "io.netty:netty-codec-http2:4.1.115.Final",
            "io.netty:netty-codec-http:4.1.115.Final",
            "io.netty:netty-handler:4.1.115.Final",
            "io.netty:netty-common:4.1.115.Final",
            "org.jdom:jdom2:2.0.6.1",
            "com.squareup.okio:okio:3.9.1"
        )
    }
}