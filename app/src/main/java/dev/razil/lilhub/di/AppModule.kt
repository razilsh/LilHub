package dev.razil.lilhub.di

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ScalarType
import dagger.Module
import dagger.Provides
import dev.razil.lilhub.BuildConfig
import dev.razil.lilhub.common.DateAdapter
import dev.razil.lilhub.common.UriAdapter
import dev.razil.lilhub.type.CustomType
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addNetworkInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Authorization", "bearer ${BuildConfig.gitHubToken}")
                .build()
            chain.proceed(request)
        }.build()
    }

    @Provides
    @Singleton
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .addCustomTypeAdapter(CustomType.DATETIME, DateAdapter)
            .addCustomTypeAdapter(object : ScalarType {
                override fun javaType(): Class<*> {
                    return String::class.java
                }

                override fun typeName(): String {
                    return "URI"
                }
            }, UriAdapter)
            .okHttpClient(okHttpClient)
            .serverUrl("https://api.github.com/graphql").build()
    }
}
