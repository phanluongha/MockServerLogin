package com.phanluongha.mockserverlogin.dragger.components;

import com.phanluongha.mockserverlogin.activity.LoginActivity;
import com.phanluongha.mockserverlogin.dragger.modules.LoginModule;
import com.phanluongha.mockserverlogin.dragger.scopes.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {
        LoginModule.class
})

public interface LoginComponent {

    void inject(LoginActivity activity);
}
