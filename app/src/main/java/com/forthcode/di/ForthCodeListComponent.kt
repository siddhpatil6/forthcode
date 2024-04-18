package com.forthcode.di

import com.forthcode.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, ForthCodeModule::class])
interface ForthCodeListComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(forthCodeListViewModelFactory: ForthCodeListViewModelFactory)

}