package com.phanluongha.mockserverlogin.dragger.modules;

import com.phanluongha.mockserverlogin.BuildConfig;
import com.phanluongha.mockserverlogin.network.FakeInterceptor;
import com.phanluongha.mockserverlogin.network.MockServerService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


    @Provides
    @Singleton
    public OkHttpClient provideClient(Integer networkTimeout) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(networkTimeout, TimeUnit.SECONDS);
        httpClient.connectTimeout(networkTimeout, TimeUnit.SECONDS);
        httpClient.addInterceptor(new FakeInterceptor());
        return httpClient.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public MockServerService provideService(Retrofit retrofit) {
        return retrofit.create(MockServerService.class);
    }

}
