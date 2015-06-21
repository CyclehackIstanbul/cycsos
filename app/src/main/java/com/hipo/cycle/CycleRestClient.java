package com.hipo.cycle;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by baris on 21/06/15.
 */
public class CycleRestClient {
    private CycleApi apiService;

    public CycleRestClient(String URL) {
        final OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(15, TimeUnit.SECONDS);
        mOkHttpClient.setReadTimeout(15, TimeUnit.SECONDS);

        RestAdapter restAdapter = new RestAdapter.Builder().setClient(new OkClient(mOkHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL).setErrorHandler(new CycleErrorHandler())
                .setEndpoint(URL).setRequestInterceptor(new SessionRequestInterceptor())
                .build();

        apiService = restAdapter.create(CycleApi.class);
    }

    public CycleApi getApiService() {

        return apiService;
    }
}
