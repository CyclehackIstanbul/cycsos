package com.hipo.cycle;

import java.net.SocketTimeoutException;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by baris on 21/06/15.
 */
public class CycleErrorHandler implements ErrorHandler {
    @Override public Throwable handleError(RetrofitError cause) {
        Response r = cause.getResponse();
        if (cause.getKind().equals(RetrofitError.Kind.NETWORK)) {
            if (cause.getCause() instanceof SocketTimeoutException) {
//                return new MyConnectionTimeoutException();
            } else {
//                return new MyNoConnectionException();
            }
        }

        return cause;
    }
}
