package com.phanluongha.mockserverlogin.mvp.interactors.iplm;

import com.phanluongha.mockserverlogin.mvp.interactors.BaseInteractor;

public class BaseInteractorImpl implements BaseInteractor{

    protected boolean isCanceled;

    @Override
    public void cancel() {
        isCanceled = true;
    }

    @Override
    public void reset() {
        isCanceled = false;
    }
}
