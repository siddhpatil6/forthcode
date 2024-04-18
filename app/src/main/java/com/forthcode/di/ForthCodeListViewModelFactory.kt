package com.forthcode.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.forthcode.usecase.ForthCodeUseCase
import com.forthcode.viewmodel.ForthCodeViewModel
import javax.inject.Inject

class ForthCodeListViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var forthCodeUseCase: ForthCodeUseCase


    init {
        DaggerForthCodeListComponent.builder().build().inject(this)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ForthCodeViewModel::class.java)) {
            return ForthCodeViewModel(forthCodeUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}