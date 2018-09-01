package com.phanluongha.mockserverlogin.dragger.modules;

import com.phanluongha.mockserverlogin.dragger.scopes.ActivityScope;
import com.phanluongha.mockserverlogin.mvp.interactors.LoginInteracter;
import com.phanluongha.mockserverlogin.mvp.interactors.iplm.LoginInteractorImpl;
import com.phanluongha.mockserverlogin.mvp.presenters.LoginPresenter;
import com.phanluongha.mockserverlogin.mvp.presenters.iplm.LoginPresenterImpl;
import com.phanluongha.mockserverlogin.mvp.views.LoginView;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public LoginView provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    public LoginInteracter provideInteractor(LoginInteractorImpl interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    public LoginPresenter providePresenter(LoginPresenterImpl presenter) {
        return presenter;
    }
}

