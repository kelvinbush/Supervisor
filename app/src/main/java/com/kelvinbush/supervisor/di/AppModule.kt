package com.kelvinbush.supervisor.di

import android.content.Context
import androidx.room.Room
import com.kelvinbush.supervisor.database.SupervisorTrackDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        SupervisorTrackDb::class.java,
        "supervisor_tracking_db"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(db: SupervisorTrackDb) = db.getSupervisorDao()
}