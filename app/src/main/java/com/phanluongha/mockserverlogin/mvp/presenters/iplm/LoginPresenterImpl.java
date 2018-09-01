package com.phanluongha.mockserverlogin.mvp.presenters.iplm;

import com.phanluongha.mockserverlogin.mvp.interactors.LoginInteracter;
import com.phanluongha.mockserverlogin.mvp.listeners.LoginListener;
import com.phanluongha.mockserverlogin.mvp.presenters.LoginPresenter;
import com.phanluongha.mockserverlogin.mvp.views.LoginView;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginPresenter, LoginListener {

    private final LoginView loginView;

    private final LoginInteracter loginInteracter;

    @Inject
    public LoginPresenterImpl(LoginView loginView, LoginInteracter loginInteracter) {
        this.loginView = loginView;
        this.loginInteracter = loginInteracter;
    }

    @Override
    public void login(String email, String password) {
        loginView.showLoading();
        loginInteracter.login(email, password, this);
    }

    @Override
    public void onSuccess() {
        loginView.hideLoading();
        loginView.loginSuccess();
    }

    @Override
    public void onError(String message) {
        loginView.hideLoading();
        loginView.showError(message);
    }

    @Override
    public void cancel() {
        loginView.hideLoading();
        loginInteracter.cancel();
    }
}

