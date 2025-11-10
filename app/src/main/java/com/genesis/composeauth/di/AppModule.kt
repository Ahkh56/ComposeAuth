package com.genesis.composeauth.di

import com.genesis.core.di.coreModule
import com.genesis.data.di.dataModule
import com.genesis.feature_auth.di.featureAuthModule
import com.genesis.feature_home.di.featureHomeModule

val appModule = listOf(
    coreModule,
    dataModule,
    featureAuthModule,
    featureHomeModule
)
