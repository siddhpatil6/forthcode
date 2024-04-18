package com.forthcode.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.forthcode.data.ForthCodePhotosItem
import com.forthcode.usecase.ForthCodeUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForthCodeViewModel @Inject constructor(private val forthCodeListUseCase: ForthCodeUseCase):
    ViewModel() , LifecycleObserver {

    var photosItem = MutableLiveData<List<ForthCodePhotosItem>>()

    fun getListOfPhotos(){
        viewModelScope.launch {
            val data = forthCodeListUseCase.getListOfPhotos()
            photosItem.postValue(data)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}