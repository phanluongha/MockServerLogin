package com.phanluongha.mockserverlogin.dragger.components;

import com.phanluongha.mockserverlogin.dragger.modules.HostModule;
import com.phanluongha.mockserverlogin.dragger.modules.LoginModule;
import com.phanluongha.mockserverlogin.dragger.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {HostModule.class, NetworkModule.class})
@Singleton
public interface AppComponent {

    LoginComponent plus(LoginModule loginModule);

}
