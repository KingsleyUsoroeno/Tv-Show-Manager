const val kotlinKapt: String = "kapt"
const val kotlinAndroid: String = "android"

object Dependencies {

    object Config {
        object Version {
            const val minSdkVersion: Int = 21
            const val compileSdkVersion: Int = 30
            const val targetSdkVersion: Int = 30
            const val versionName: String = "1.0"
            const val versionCode: Int = 1
        }

        const val isMultiDexEnabled: Boolean = true

        object Android {
            const val applicationId: String = "com.example.tvshowmanager"
        }
    }

    object AndroidX {
        const val coreKtx: String = "androidx.core:core-ktx:${Versions.ktxCore}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
        const val multiDex: String = "androidx.multidex:multidex:${Versions.multidex}"
    }

    object View {
        const val appCompat: String = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val materialComponent: String =
            "com.google.android.material:material:${Versions.material}"
        const val constraintLayout: String =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val lifeCycleLiveData =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    }

    interface Libraries {
        val components: List<String>
    }

    object Network : Libraries {

        private const val okhttp: String = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        private const val loggingInterceptor: String =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

        override val components: List<String> = listOf(
            okhttp,
            loggingInterceptor
        )
    }

    object DI {
        object Version {
            const val javaxInject: String = "1"
            const val hiltViewModel: String = "1.0.0-alpha02"
        }

        object AnnotationProcessor {
            const val jetpackHiltCompiler: String =
                "androidx.hilt:hilt-compiler:${Version.hiltViewModel}"
        }

        const val javaxInject: String = "javax.inject:javax.inject:${Version.javaxInject}"
        const val hiltViewModel: String =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Version.hiltViewModel}"
        const val hiltTesting: String =
            "com.google.dagger:hilt-android-testing:${Versions.daggerHiltAndroid}"

        const val daggerHiltAndroid = "com.google.dagger:hilt-android:${Versions.daggerHiltAndroid}"
        const val daggerHiltkapt =
            "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltAndroid}"
    }

    object Coroutines : Libraries {

        private const val core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        private const val android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

        override val components: List<String> = listOf(core, android)
    }

    object Cache {

        object AnnotationProcessor {
            const val room: String = "androidx.room:room-compiler:${Versions.room}"
        }

        const val room: String = "androidx.room:room-ktx:${Versions.room}"
    }

    object Test {
        const val junit: String = "junit:junit:${Versions.jUnit}"
        const val runner: String = "androidx.test:runner:${Versions.runner}"
        const val androidXTest: String = "androidx.test.ext:junit:${Versions.testExt}"
    }

    object Apollo : Libraries {
        private const val apolloAndroid =
            "com.apollographql.apollo:apollo-runtime:${Versions.apollo}"
        private const val apolloCouroutines =
            "com.apollographql.apollo:apollo-coroutines-support:${Versions.apollo}"

        override val components: List<String> = listOf(apolloAndroid, apolloCouroutines)
    }
}