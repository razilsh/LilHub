/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val android_arch_navigation: String = "1.0.0-rc02" 

    const val appcompat: String = "1.1.0-alpha02" 

    const val core_testing: String = "2.0.0" 

    const val constraintlayout: String = "1.1.3" 

    const val core_ktx: String = "1.1.0-alpha04" 

    const val androidx_databinding: String = "3.3.2" 

    const val fragment_testing: String = "1.1.0-alpha04" 

    const val lifecycle_extensions: String = "2.0.0" 

    const val espresso_core: String = "3.1.1" 

    const val androidx_test_ext: String = "1.1.0" 

    const val androidx_test_core: String = "1.1.0" 

    const val androidx_test_rules: String = "1.1.1" 

    const val androidx_test_runner: String = "1.1.1" 

    const val com_airbnb_android: String = "3.3.0" 

    const val com_android_tools_build_gradle: String = "3.3.2" 

    const val lint_gradle: String = "26.3.2" 

    const val apollo_gradle_plugin: String = "1.0.0-alpha5" 

    const val apollo_runtime: String = "1.0.1-SNAPSHOT" 

    const val material: String = "1.1.0-alpha04" 

    const val com_google_dagger: String = "2.21" 

    const val threetenabp: String = "1.2.0"

    const val timber: String = "4.7.1" 

    const val com_squareup_okhttp3: String = "3.13.1" 

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2" 

    const val android_junit5: String = "1.4.0.0" 

    const val io_gitlab_arturbosch_detekt: String = "1.0.0-RC14" 

    const val io_mockk: String = "1.9.1" 

    const val jsr250_api: String = "1.0" // available: "1.0-20050927.133100"

    const val junit_junit: String = "4.12" 

    const val org_jetbrains_kotlin: String = "1.3.21" 

    const val org_jetbrains_kotlinx: String = "1.1.1" 

    const val org_junit_jupiter: String = "5.4.0" 

    const val junit_vintage_engine: String = "5.4.0" 

    const val podam: String = "7.2.2.RELEASE" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.2.1"

        const val currentVersion: String = "5.2.1"

        const val nightlyVersion: String = "5.4-20190310000057+0000"

        const val releaseCandidate: String = "5.3-rc-1"
    }
}
