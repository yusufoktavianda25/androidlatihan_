package binar.academy.mycatalogmovies.di

import binar.academy.mycatalogmovies.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { LoginViewModel(get(), get()) }
//    viewModel { RegisterViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
//    viewModel { ProfileViewModel(get(), get()) }
}