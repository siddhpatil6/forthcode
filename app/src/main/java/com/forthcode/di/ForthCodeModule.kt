package com.forthcode.di


import com.forthcode.interfaces.IForthCodeRepository
import com.forthcode.interfaces.IForthCodeUseCase
import com.forthcode.networking.APIClient

import com.forthcode.repository.ForthCodeRepository
import com.forthcode.usecase.ForthCodeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ForthCodeModule {
    @Provides
    fun getForthCodeCase(forthCodeRepository: ForthCodeRepository): IForthCodeUseCase = ForthCodeUseCase(forthCodeRepository = forthCodeRepository)

    @Provides
    fun getForthCodeRepository(apiClient: APIClient): IForthCodeRepository = ForthCodeRepository(apiClient)


}