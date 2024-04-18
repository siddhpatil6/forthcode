package com.forthcode.interfaces
import com.forthcode.data.ForthCodePhotosItem

interface  IForthCodeRepository {
  suspend fun getListOfPhotos(): List<ForthCodePhotosItem>

}