package com.hipo.cycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by baris on 21/06/15.
 */
public class IncomingReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
//        try {
//            JSONObject json = new JSONObject(bundle.getString("com.parse.Data"));
//            Intent intent1 = new Intent(NotificationActivity.class);
//            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            Bundle b = new Bundle();
////            b.putString("id",json.getString("sos_id"));
//            intent1.putExtras(b);
//            context.startActivity(intent1);

//
//            Intent i = new Intent();
//            i.setClassName("com.hipo.cycle", "com.hipo.cycle.NotificationActivity");
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(i);

            Intent i = new Intent(context, SignInActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);


//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }


}
