package com.azabost.time.di

import com.azabost.time.api.NowProvider
import com.azabost.time.impl.DefaultNowProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface TimeModule {

    @Binds
    fun nowProvider(defaultNowProvider: DefaultNowProvider): NowProvider
}