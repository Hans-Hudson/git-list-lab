object Dependencies {
    // Android X
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Google
    const val material = "com.google.android.material:material:${Versions.androidMaterial}"

    //
    // EXTERNAL DEPENDENCIES
    //

    // Koin
    const val koin = "io.insert-koin:koin-android:${Versions.koinVersion}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koinVersion}"
    const val koinTestJUnit = "io.insert-koin:koin-test-junit4:${Versions.koinVersion}"

    // Mockk
    const val mockK = "io.mockk:mockk:${Versions.mockKVersion}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"

    // OkHttp
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"

    // Gson
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gsonVersion}"

    const val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebserverVersion}"

    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"

    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockito}"

}
