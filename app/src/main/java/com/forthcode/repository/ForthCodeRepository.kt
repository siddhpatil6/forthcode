package com.forthcode.repository

import com.forthcode.networking.APIClient
import com.forthcode.networking.ApiInterface
import com.forthcode.interfaces.IForthCodeRepository
import com.forthcode.data.ForthCodePhotosItem
import javax.inject.Inject

class ForthCodeRepository @Inject constructor (var apiClient: APIClient): IForthCodeRepository {

    override suspend fun getListOfPhotos(): List<ForthCodePhotosItem> {
        val apiInterface = apiClient.getInstance().create(ApiInterface::class.java)
        return apiInterface.getPhotosList()
    }


}