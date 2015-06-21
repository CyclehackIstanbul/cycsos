package com.hipo.cycle;

import android.content.Intent;
import android.os.Bundle;

public class HelperActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getName() == null || getName().length() == 0) {
            startActivity(new Intent(this, SignInActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
        finish();
    }


}
