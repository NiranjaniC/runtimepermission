plugins {
<<<<<<< HEAD
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.ex_6pmd"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.ex_6pmd"
        minSdk = 24
        targetSdk = 36
=======
    id("com.android.application")
}

android {
    namespace = "com.example.runtimepermission"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.runtimepermission"
        minSdk = 24
        targetSdk = 33
>>>>>>> 16a50cb0915eb325963f19c06f5eadcb7f4dc735
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
<<<<<<< HEAD
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
=======
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
>>>>>>> 16a50cb0915eb325963f19c06f5eadcb7f4dc735
    }
}

dependencies {
<<<<<<< HEAD
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
=======

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
>>>>>>> 16a50cb0915eb325963f19c06f5eadcb7f4dc735
}