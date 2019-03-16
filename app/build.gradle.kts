import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("com.apollographql.android")
    id("de.mannodermaus.android-junit5")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "dev.razil.lilhub"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        forEach { buildType ->
            if (hasProperty("GITHUB_TOKEN")) {
                val token = property("GITHUB_TOKEN") as String
                buildType.buildConfigField("String", "gitHubToken", token)
            }
        }
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    dataBinding {
        isEnabled = true
    }
    apollo {
        setCustomTypeMapping(
            mapOf(
                "URI" to "java.lang.String",
                "Date" to "org.threeten.bp.Instant",
                "HTML" to "java.lang.String"
            )
        )
        setSuppressRawTypesWarning(true)
    }
    configurations.all {
        resolutionStrategy.force("com.google.code.findbugs:jsr305:1.3.9")
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin_stdlib_jdk7)
    implementation(Libs.kotlinx_coroutines_core)
    implementation(Libs.kotlinx_coroutines_android)

    implementation(Libs.material)
    implementation(Libs.appcompat)
    implementation(Libs.core_ktx)
    implementation(Libs.constraintlayout)
    implementation(Libs.lifecycle_extensions)
    implementation(Libs.navigation_fragment_ktx)
    implementation(Libs.navigation_ui_ktx)

    implementation(Libs.apollo_runtime)
    implementation(Libs.logging_interceptor)
    implementation(Libs.timber)
    implementation(Libs.jsr250_api)
    implementation(Libs.okhttp)
    implementation(Libs.threetenabp)

    implementation(Libs.epoxy)
    implementation(Libs.epoxy_databinding)
    implementation(Libs.epoxy_paging)
    kapt(Libs.epoxy_processor)

    implementation(Libs.dagger)
    kapt(Libs.dagger_compiler)

    testRuntimeOnly(Libs.junit_jupiter_engine)
    testRuntimeOnly(Libs.junit_vintage_engine)

    debugImplementation(Libs.fragment_testing)
    testImplementation(Libs.junit_jupiter_api)
    testImplementation(Libs.junit_jupiter_params)
    testImplementation(Libs.junit_junit)
    testImplementation(Libs.mockk)
    testImplementation(Libs.kotlinx_coroutines_core)
    testImplementation(Libs.core_testing)
    testImplementation(Libs.podam)
    testImplementation(Libs.threetenbp) {
        exclude(group = "com.jakewharton.threetenabp", module = "threetenabp")
    }


    androidTestImplementation(Libs.mockk_android)
    androidTestImplementation(Libs.androidx_test_runner)
    androidTestImplementation(Libs.androidx_test_rules)
    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.truth)
    androidTestImplementation(Libs.espresso_core)
    androidTestImplementation(Libs.core_testing)
    androidTestImplementation(Libs.androidx_test_core)
}
