package com.forthcode.usecase


import com.forthcode.interfaces.IForthCodeUseCase
import com.forthcode.data.ForthCodePhotosItem
import com.forthcode.repository.ForthCodeRepository
import javax.inject.Inject

class ForthCodeUseCase @Inject constructor(private val forthCodeRepository: ForthCodeRepository) :
    IForthCodeUseCase {
    override suspend fun getListOfPhotos(): List<ForthCodePhotosItem> {
        return forthCodeRepository.getListOfPhotos()
    }

}