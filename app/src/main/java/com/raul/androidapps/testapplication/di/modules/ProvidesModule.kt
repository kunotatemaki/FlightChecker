package com.raul.androidapps.testapplication.di.modules

import android.content.Context
import com.raul.androidapps.testapplication.MyApplication
import com.raul.androidapps.testapplication.persistence.databases.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class ProvidesModule {


    @Provides
    fun providesContext(application: MyApplication): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideDb(
        context: Context
    ): AppDatabase = AppDatabase.getInstance(context)


}