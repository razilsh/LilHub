import kotlin.String

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Update this file with
 *   `$ ./gradlew buildSrcVersions` */
object Libs {
    const val navigation_fragment_ktx: String = "android.arch.navigation:navigation-fragment-ktx:" +
            Versions.android_arch_navigation

    const val navigation_ui_ktx: String = "android.arch.navigation:navigation-ui-ktx:" +
            Versions.android_arch_navigation

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val appcompat: String = "androidx.appcompat:appcompat:" + Versions.appcompat

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val core_testing: String = "androidx.arch.core:core-testing:" + Versions.core_testing

    /**
     * http://tools.android.com */
    const val constraintlayout: String = "androidx.constraintlayout:constraintlayout:" +
            Versions.constraintlayout

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val core_ktx: String = "androidx.core:core-ktx:" + Versions.core_ktx

    const val databinding_adapters: String = "androidx.databinding:databinding-adapters:" +
            Versions.androidx_databinding

    /**
     * https://developer.android.com/studio */
    const val databinding_common: String = "androidx.databinding:databinding-common:" +
            Versions.androidx_databinding

    /**
     * https://developer.android.com/studio */
    const val databinding_compiler: String = "androidx.databinding:databinding-compiler:" +
            Versions.androidx_databinding

    const val databinding_runtime: String = "androidx.databinding:databinding-runtime:" +
            Versions.androidx_databinding

    const val fragment_testing: String = "androidx.fragment:fragment-testing:" +
            Versions.fragment_testing

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val lifecycle_extensions: String = "androidx.lifecycle:lifecycle-extensions:" +
            Versions.lifecycle_extensions

    /**
     * https://developer.android.com/testing */
    const val espresso_core: String = "androidx.test.espresso:espresso-core:" +
            Versions.espresso_core

    /**
     * https://developer.android.com/testing */
    const val androidx_test_ext_junit: String = "androidx.test.ext:junit:" +
            Versions.androidx_test_ext

    /**
     * https://developer.android.com/testing */
    const val truth: String = "androidx.test.ext:truth:" + Versions.androidx_test_ext

    /**
     * https://developer.android.com/testing */
    const val androidx_test_core: String = "androidx.test:core:" + Versions.androidx_test_core

    /**
     * https://developer.android.com/testing */
    const val androidx_test_rules: String = "androidx.test:rules:" + Versions.androidx_test_rules

    /**
     * https://developer.android.com/testing */
    const val androidx_test_runner: String = "androidx.test:runner:" + Versions.androidx_test_runner

    /**
     * https://github.com/airbnb/epoxy */
    const val epoxy_databinding: String = "com.airbnb.android:epoxy-databinding:" +
            Versions.com_airbnb_android

    /**
     * https://github.com/airbnb/epoxy */
    const val epoxy_processor: String = "com.airbnb.android:epoxy-processor:" +
            Versions.com_airbnb_android

    /**
     * https://github.com/airbnb/epoxy */
    const val epoxy: String = "com.airbnb.android:epoxy:" + Versions.com_airbnb_android

    /**
     * https://developer.android.com/studio */
    const val com_android_tools_build_gradle: String = "com.android.tools.build:gradle:" +
            Versions.com_android_tools_build_gradle

    /**
     * https://developer.android.com/studio */
    const val lint_gradle: String = "com.android.tools.lint:lint-gradle:" + Versions.lint_gradle

    /**
     * https://github.com/apollographql/apollo-android/ */
    const val apollo_gradle_plugin: String = "com.apollographql.apollo:apollo-gradle-plugin:" +
            Versions.apollo_gradle_plugin

    /**
     * https://github.com/apollographql/apollo-android/ */
    const val apollo_runtime: String = "com.apollographql.apollo:apollo-runtime:" +
            Versions.apollo_runtime

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val material: String = "com.google.android.material:material:" + Versions.material

    /**
     * https://github.com/google/dagger */
    const val dagger_compiler: String = "com.google.dagger:dagger-compiler:" +
            Versions.com_google_dagger

    /**
     * https://github.com/google/dagger */
    const val dagger: String = "com.google.dagger:dagger:" + Versions.com_google_dagger

    /**
     * https://github.com/JakeWharton/ThreeTenABP/ */
    const val threetenabp: String = "com.jakewharton.threetenabp:threetenabp:" +
            Versions.threetenabp

    /**
     * https://github.com/JakeWharton/timber */
    const val timber: String = "com.jakewharton.timber:timber:" + Versions.timber

    /**
     * https://github.com/square/okhttp */
    const val logging_interceptor: String = "com.squareup.okhttp3:logging-interceptor:" +
            Versions.com_squareup_okhttp3

    /**
     * https://github.com/square/okhttp */
    const val okhttp: String = "com.squareup.okhttp3:okhttp:" + Versions.com_squareup_okhttp3

    const val de_fayard_buildsrcversions_gradle_plugin: String =
            "de.fayard.buildSrcVersions:de.fayard.buildSrcVersions.gradle.plugin:" +
            Versions.de_fayard_buildsrcversions_gradle_plugin

    const val android_junit5: String = "de.mannodermaus.gradle.plugins:android-junit5:" +
            Versions.android_junit5

    const val detekt_cli: String = "io.gitlab.arturbosch.detekt:detekt-cli:" +
            Versions.io_gitlab_arturbosch_detekt

    const val detekt_formatting: String = "io.gitlab.arturbosch.detekt:detekt-formatting:" +
            Versions.io_gitlab_arturbosch_detekt

    const val io_gitlab_arturbosch_detekt_gradle_plugin: String =
            "io.gitlab.arturbosch.detekt:io.gitlab.arturbosch.detekt.gradle.plugin:" +
            Versions.io_gitlab_arturbosch_detekt

    /**
     * http://mockk.io */
    const val mockk_android: String = "io.mockk:mockk-android:" + Versions.io_mockk

    /**
     * http://mockk.io */
    const val mockk: String = "io.mockk:mockk:" + Versions.io_mockk

    /**
     * https://jax-ws.dev.java.net/ */
    const val jsr250_api: String = "javax.annotation:jsr250-api:" + Versions.jsr250_api

    /**
     * http://junit.org */
    const val junit_junit: String = "junit:junit:" + Versions.junit_junit

    /**
     * https://kotlinlang.org/ */
    const val kotlin_android_extensions: String =
            "org.jetbrains.kotlin:kotlin-android-extensions:" + Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_annotation_processing_gradle: String =
            "org.jetbrains.kotlin:kotlin-annotation-processing-gradle:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_gradle_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_stdlib_jdk7: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://github.com/Kotlin/kotlinx.coroutines */
    const val kotlinx_coroutines_android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.org_jetbrains_kotlinx

    /**
     * https://github.com/Kotlin/kotlinx.coroutines */
    const val kotlinx_coroutines_core: String = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" +
            Versions.org_jetbrains_kotlinx

    /**
     * https://junit.org/junit5/ */
    const val junit_jupiter_api: String = "org.junit.jupiter:junit-jupiter-api:" +
            Versions.org_junit_jupiter

    /**
     * https://junit.org/junit5/ */
    const val junit_jupiter_engine: String = "org.junit.jupiter:junit-jupiter-engine:" +
            Versions.org_junit_jupiter

    /**
     * https://junit.org/junit5/ */
    const val junit_jupiter_params: String = "org.junit.jupiter:junit-jupiter-params:" +
            Versions.org_junit_jupiter

    /**
     * https://junit.org/junit5/ */
    const val junit_vintage_engine: String = "org.junit.vintage:junit-vintage-engine:" +
            Versions.junit_vintage_engine
}
