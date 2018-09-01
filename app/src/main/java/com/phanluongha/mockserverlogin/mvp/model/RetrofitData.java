package com.phanluongha.mockserverlogin.mvp.model;

/**
 * Created by phanluongha on 3/28/18.
 */

public class RetrofitData<T> {

    // code when error
    private int code = -1;

    public int getCode() {
        return code;
    }

    // error message
    private String error;

    public String getError() {
        return error;
    }

    /**
     * function check error or not
     */
    public boolean isError() {
        return code != -1;
    }


    private T result;

    public T getResult() {
        return result;
    }
}
