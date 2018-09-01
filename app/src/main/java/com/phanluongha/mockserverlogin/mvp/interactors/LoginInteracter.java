package com.phanluongha.mockserverlogin.mvp.interactors;

import com.phanluongha.mockserverlogin.mvp.listeners.LoginListener;

public interface LoginInteracter extends BaseInteractor{

    void login(String email, String password, LoginListener loginListener);

}
