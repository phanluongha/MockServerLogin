package com.phanluongha.mockserverlogin.mvp.interactors.iplm;

import android.annotation.SuppressLint;

import com.phanluongha.mockserverlogin.mvp.model.RetrofitData;
import com.phanluongha.mockserverlogin.mvp.interactors.LoginInteracter;
import com.phanluongha.mockserverlogin.mvp.listeners.LoginListener;
import com.phanluongha.mockserverlogin.network.MockServerService;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginInteractorImpl extends BaseInteractorImpl implements LoginInteracter {

    private MockServerService mockServerService;

    @Inject
    public LoginInteractorImpl(MockServerService mockServerService) {
        this.mockServerService = mockServerService;
    }

    @SuppressLint("CheckResult")
    @Override
    public void login(String email, String password, LoginListener loginListener) {
        reset();
        Observable<RetrofitData> observable = mockServerService.login(email, password);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(result -> {
                    if (result.isError()) {
                        loginListener.onError(result.getError());
                    } else {
                        loginListener.onSuccess();
                    }
                }, throwable -> {
                    loginListener.onError(throwable.getMessage());
                });
    }
}
