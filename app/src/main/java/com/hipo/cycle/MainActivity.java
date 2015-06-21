package com.hipo.cycle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.client.Response;

public class MainActivity extends BaseActivity implements  GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {

    @InjectView(R.id.mainActivityNameTV)
    TextView nameTV;
    @InjectView(R.id.mainActivityPhoneTV)
    TextView phoneTV;

    private GoogleApiClient mGoogleApiClient;
    int PLACE_PICKER_REQUEST = 1;
    ProgressDialog dialog;
    private double lat,lng;

    String pushStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);



        phoneTV.setText(getPhone());
        nameTV.setText(getName());
        dialog = new ProgressDialog(this);
        dialog.show();

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)

                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
//Current Location
//        PendingResult result = Places.PlaceDetectionApi
//                .getCurrentPlace(mGoogleApiClient, null);
//        result.setResultCallback(new ResultCallback() {
//            @Override
//            public void onResult(Result result) {
//                Log.d("BEE", result.toString());
//
//
//            }
//        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
//            String notificationData = bundle.getString("com.parse.Data");
            if (bundle != null) {
                Log.d("detectPusMessage", "----" );
//                handlePushNotificationMessage(notificationData);
            }

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

            }
        }
    }

    @OnClick(R.id.mainActivitySettingsV)
    void openSettings() {
//        final Intent intent = new Intent(this,SignInActivity.class);
//        startActivity(intent);

        final Intent intent = new Intent(this,NotificationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle bundle) {
        PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                .getCurrentPlace(mGoogleApiClient, null);
        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
            @Override
            public void onResult(PlaceLikelihoodBuffer likelyPlaces) {

                Place place = likelyPlaces.get(0).getPlace();
                lat =  place.getLatLng().latitude;
                lng =  place.getLatLng().longitude;
                likelyPlaces.release();
                dialog.dismiss();
//                ParsePush push = new ParsePush();
//                String message = " " + likelyPlaces.get(0).getPlace().getAddress();
//
//                push.setMessage(message);
//                push.sendInBackground();
            }
        });
    }

    @OnClick(R.id.mainActivitySendSOSBtn)
    void sendSos() {
        ArrayList<ObjectP> objects = new ArrayList<>();
        objects.add(new ObjectP(getId()));
        objects.add(new ObjectP(getId()));
        CycleApplication.getApi().createSOS(new CreateSOSRequestClass(new Owner(objects),new Location(lat,lng)),sosCallback);
    }

    @Override
    public void onConnectionSuspended(int i) {
        dialog.dismiss();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        dialog.dismiss();
    }

    private CycleCallback<Object> sosCallback = new CycleCallback<Object>() {
        @Override
        public void failure(int status) {

        }

        @Override
        public void connectionError() {

        }

        @Override
        public void success(Object o, Response response) {
            Toast.makeText(MainActivity.this,"SOS gönderildi",Toast.LENGTH_LONG).show();
        }
    };
}
