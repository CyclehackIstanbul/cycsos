package com.hipo.cycle;

/**
 * Created by baris on 21/06/15.
 */

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface CycleApi {

    @POST("/classes/Profile/")
    void createProfile(@Body CreateProfileRequestClass createProfileRequestClass, CycleCallback<CreateProfileResponseClass> callback);

    @GET("/classes/Profile/{id}")
    void getProfileDetail(@Path("id") String id, CycleCallback<Object> object);

    @POST("/classes/SOS")
    void createSOS(@Body CreateSOSRequestClass createSOSRequestClass, CycleCallback<Object> callback);



    @POST("/installations")
    void register(@Body RegisterRequestClass registerRequestClass,CycleCallback<Object> callback);

    @GET("/classes/SOS/{id}")
    void getNotification(@Path("id") String id,CycleCallback<Object> callback);

}
