import java.util.regex.Pattern.compile

plugins {
    id("com.android.application")
}

android {
    namespace = "com.atees.ateesglobelcrm"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.atees.ateesglobelcrm"
        minSdk = 28
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}





dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("io.github.muddz:styleabletoast:2.4.0")


    implementation ("io.github.chaosleung:pinview:1.4.4")


    implementation ("androidx.room:room-runtime:2.2.3")
    annotationProcessor ("androidx.room:room-compiler:2.2.3")

    implementation ("androidx.lifecycle:lifecycle-extensions:2.1.0")
    annotationProcessor ("androidx.lifecycle:lifecycle-compiler:2.1.0")

    implementation ("me.zhanghai.android.materialratingbar:library:1.4.0")

//    def room_version = "2.2.3"
//    implementation "androidx.room:room-runtime:$room_version"
//    annotationProcessor "androidx.room:room-compiler:$room_version"
//
//// ViewModel and LiveData
//    def lifecycle_version = "2.1.0"
//    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
//    annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"







}