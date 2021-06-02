package com.example.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReciever extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if(intentAction!=null){
            String toastMessage = "";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power Connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected";
                    break;

                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Recieved";
                    break;
            }
            //display the toast
            Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT).show();
        }

    }
}