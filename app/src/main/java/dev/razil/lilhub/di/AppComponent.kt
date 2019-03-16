package dev.razil.lilhub.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dev.razil.lilhub.ui.home.HomeFragment
import dev.razil.lilhub.ui.search.SearchFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: SearchFragment)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(app: Application): Builder
    }
}
