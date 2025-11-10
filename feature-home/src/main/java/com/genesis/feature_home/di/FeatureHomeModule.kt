package com.genesis.feature_home.di

import com.genesis.core.navigation.NavigationProvider
import com.genesis.feature_home.navigation.HomeNavigationProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val featureHomeModule = module {
    singleOf(::HomeNavigationProvider).bind<NavigationProvider>()
}