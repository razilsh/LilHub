package dev.razil.lilhub

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dev.razil.lilhub.di.DaggerAppComponent
import timber.log.Timber

class LilHubApp : Application() {
    private val appComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
        AndroidThreeTen.init(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        private var INSTANCE: LilHubApp? = null

        @JvmStatic
        fun get() = INSTANCE!!.appComponent
    }
}
