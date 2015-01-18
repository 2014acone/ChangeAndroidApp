package com.ankit.alarmclock;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.*;

/**
 * Created by aecone on 1/17/15.
 */
public class RingtonePlayingService extends Activity
{
    private Ringtone ringtone;
    public RingtonePlayingService() {
        Uri alarmTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(getApplicationContext(), alarmTone);
    }

    public void play()
    {
        ringtone.play();

    }

    public void stop()
    {
        ringtone.stop();
    }

}

