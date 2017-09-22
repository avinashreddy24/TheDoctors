package com.aug22.avinashchintareddy.thedoctors;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver
{


    public void onReceive(Context context, Intent intent)
    {



       Intent service_intent=new Intent(context,RingtonePlayingService.class);



        context.startService(service_intent);
    }
}
