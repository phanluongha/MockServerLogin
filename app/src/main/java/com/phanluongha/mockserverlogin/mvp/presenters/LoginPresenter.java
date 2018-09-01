package com.phanluongha.mockserverlogin.mvp.presenters;

public interface LoginPresenter extends BasePresenter{

    void login(String email, String password);
}
