package com.phanluongha.mockserverlogin.network;


import com.phanluongha.mockserverlogin.common.Constants;
import com.phanluongha.mockserverlogin.mvp.model.RetrofitData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MockServerService {

    @FormUrlEncoded
    @POST("/login")
    Observable<RetrofitData> login(@Field(Constants.EMAIL) String email,@Field(Constants.PASSWORD) String password);
}
