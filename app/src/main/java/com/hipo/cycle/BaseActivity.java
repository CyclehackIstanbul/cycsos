package com.hipo.cycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by baris on 20/06/15.
 */
public class BaseActivity extends AppCompatActivity {
    public String getName() {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString("name", "");

    }

    public void saveName(String name) {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name);
        editor.commit();
    }


    public String getPhone() {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString("phone", "");

    }

    public void savePhone(String phone) {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("phone", phone);
        editor.commit();
    }
    public void saveId(String id) {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("id", id);
        editor.commit();
    }
    public String getId() {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString("id", "");

    }
    public void saveToken(String token) {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token);
        editor.commit();
    }
    public String getToken() {
        SharedPreferences preferences = this.getSharedPreferences(CycleApplication.SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString("token", "");

    }

}
