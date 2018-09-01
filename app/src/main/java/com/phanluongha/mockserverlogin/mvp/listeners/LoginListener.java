package com.phanluongha.mockserverlogin.mvp.listeners;

public interface LoginListener {

    void onSuccess();

    void onError(String message);
}
