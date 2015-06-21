package com.hipo.cycle;

/**
 * Created by baris on 21/06/15.
 */

import retrofit.RequestInterceptor;

/**
 * Created by baris on 01/06/15.
 */
public class SessionRequestInterceptor implements RequestInterceptor {
    public SessionRequestInterceptor() {

    }

    @Override
    public void intercept(RequestFacade request) {

            request.addHeader("X-Parse-Application-Id", "Bdyjk7my6LJxbHM5NWnjCP15kiaDGjyY14QnkBf8");
            request.addHeader("X-Parse-REST-API-Key", "41INYDvhWQiyXK4vtAQRCTEVwXcqatMQbgbeTOzm");


    }
}
