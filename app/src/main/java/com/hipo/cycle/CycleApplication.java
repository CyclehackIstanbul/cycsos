package com.hipo.cycle;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.PushService;
import com.parse.SaveCallback;

/**
 * Created by baris on 20/06/15.
 */
public class CycleApplication extends Application {
    private static final String BASE_URL = "https://api.parse.com/1/";
    public static final String SHARED_PREFS = "CYCLE_SHARED_PREFS";
    private static final String PARSE_APP_ID = "Bdyjk7my6LJxbHM5NWnjCP15kiaDGjyY14QnkBf8";
    private static final String PARSE_CLIENT_KEY = "4YYiSm0SGYhOKhmK7nW1bMWo1iAW3LTl60f2QzWe";

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, PARSE_APP_ID, PARSE_CLIENT_KEY);
//        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        PushService.setDefaultPushCallback(this, NotificationActivity.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });
        
    }
    private static CycleRestClient contactsRestClient;
    private static CycleApi contactsApi;
    public static CycleApi getApi() {
        if (contactsRestClient == null) {
            contactsRestClient = new CycleRestClient(BASE_URL);
        }
        if (contactsApi == null) {
            contactsApi = contactsRestClient.getApiService();
        }
        return contactsApi;
    }
}
