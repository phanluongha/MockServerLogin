package com.phanluongha.mockserverlogin.dragger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class HostModule {

    public static final int NETWORK_TIMEOUT_SECONDS = 10;

    @Provides
    @Singleton
    public Integer provideNetworkTimeout() {
        return NETWORK_TIMEOUT_SECONDS;
    }
}
