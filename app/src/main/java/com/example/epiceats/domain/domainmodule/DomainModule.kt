package com.example.epiceats.domain.domainmodule

import com.example.epiceats.data.repoImpl.RepoImpl
import com.example.epiceats.domain.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideRepo(): Repo {
        return RepoImpl()
    }
}
