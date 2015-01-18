package com.ankit.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;


/**
 * Created by ankit on 1/17/15.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {

    Ringtone ringtone;

    @Override
    public void onReceive(Context context, Intent intent){
        //Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        //ringtone = RingtoneManager.getRingtone(context, alarmUri);
        //ringtone.play();
        Intent i = new Intent(context, AlarmRing.class);
        context.startService(i);
        //Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        //Intent startIntent = new Intent(context, RingtonePlayingService.class);
        //startIntent.putExtra("ringtone-uri", ringtoneUri);
        //context.startService(startIntent);
        Toast.makeText(context, "Alarm Triggered", Toast.LENGTH_LONG).show();



    }

    public void stopAll(View view) {


        ringtone.stop();
    }
}
