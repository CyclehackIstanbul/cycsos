package com.hipo.cycle;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.SaveCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import retrofit.client.Response;

public class SignInActivity extends BaseActivity {
    @InjectView(R.id.signInActivityPhoneET)
    EditText phoneET;
    @InjectView(R.id.signInActivityNameET)
    EditText nameET;
    @InjectView(R.id.signInActivityStartBtn)
    Button startBtn;
    String phone,name;
    String deviceToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.inject(this);
        ParseInstallation.getCurrentInstallation().saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                deviceToken = (String) ParseInstallation.getCurrentInstallation().get("deviceToken");
                saveToken(deviceToken);
            }
        });

    }
    @OnClick(R.id.signInActivityStartBtn)
    void start() {
        CycleApplication.getApi().createProfile(new CreateProfileRequestClass(name,phone),createProfileCallback);
        saveName(name);
        savePhone(phone);
        final Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @OnTextChanged({R.id.signInActivityNameET,R.id.signInActivityPhoneET})
    void setState() {
        name = nameET.getText().toString().trim();
        phone = phoneET.getText().toString().trim();
        if (name == null || name.length()== 0 || phone == null || phone.length() == 0 || !PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
            startBtn.setVisibility(View.GONE);
        } else {
            startBtn.setVisibility(View.VISIBLE);
        }
    }
    private CycleCallback<CreateProfileResponseClass> createProfileCallback = new CycleCallback<CreateProfileResponseClass>() {
        @Override
        public void failure(int status) {

        }

        @Override
        public void connectionError() {

        }

        @Override
        public void success(CreateProfileResponseClass createProfileResponseClass, Response response) {
            saveId(createProfileResponseClass.getObjectId());
//        CycleApplication.getApi().register(new RegisterRequestClass(deviceToken,new ObjectP(createProfileResponseClass.getObjectId())),registerCallback);
            ParseInstallation installation = ParseInstallation.getCurrentInstallation();
            installation.put("profile",createProfileResponseClass.getObjectId());
            installation.saveInBackground();
            Log.d("BEE", "" + ParseInstallation.getCurrentInstallation().get("profile")) ;
        }
    };
    private CycleCallback<Object> registerCallback = new CycleCallback<Object>() {
        @Override
        public void failure(int status) {

        }

        @Override
        public void connectionError() {

        }

        @Override
        public void success(Object o, Response response) {

        }
    };


}
