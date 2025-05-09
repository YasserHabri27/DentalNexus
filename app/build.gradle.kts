plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.dentalnexus"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.dentalnexus"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
}

dependencies {

    implementation("androidx.room:room-runtime:2.4.3")
    annotationProcessor("androidx.room:room-compiler:2.4.3")  // Utilise annotationProcessor pour Java


    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.activity:activity-ktx:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
