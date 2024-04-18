package com.forthcode.interfaces

import com.forthcode.data.ForthCodePhotosItem

interface IForthCodeUseCase {
    suspend fun getListOfPhotos(): List<ForthCodePhotosItem>

}