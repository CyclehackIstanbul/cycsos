package com.hipo.cycle;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by baris on 21/06/15.
 */
public abstract class CycleCallback<T> implements Callback<T> {
    public abstract void failure(int status);

    public abstract void connectionError();

    @Override
    public void failure(RetrofitError error) {
        if (error.getKind().equals(RetrofitError.Kind.NETWORK)) {
            connectionError();
        } else if (error != null && error.getResponse() != null) {
            failure(error.getResponse().getStatus());
        } else {
            failure(0);
        }


    }
}