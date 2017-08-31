package com.foxmount.gitfox.gitapi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.foxmount.gitfox.gitapi.UrlConst.URL_MAIN;

/**
 * Created by A on 31.08.2017.
 */

public class ApiManager {

    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(URL_MAIN)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
