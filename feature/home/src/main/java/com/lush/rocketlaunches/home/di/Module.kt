package com.lush.rocketlaunches.home.di

import com.lush.rocketlaunches.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val homeModules = module {
    viewModel { HomeViewModel(get()) }
}

val loadHomeModules by lazy {
    val modules = listOf(homeModules)
    loadKoinModules(modules)
}
