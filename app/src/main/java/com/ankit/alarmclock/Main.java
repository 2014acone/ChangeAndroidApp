package com.ankit.alarmclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.util.Log;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main extends Activity {
    Uri alarmTone; //= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
    Ringtone ringtone;// = RingtoneManager.getRingtone(getApplicationContext(), alarmTone);
   // private RingtonePlayingService ring;// = new RingtonePlayingService();
    private CountDownTimer countDownTimer;
    private long time;
    private long interval = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        alarmTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtone = RingtoneManager.getRingtone(getApplicationContext(), alarmTone);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            time = (long) extras.getInt("time");
            Log.d("time", " " + time);
            int hour = extras.getInt("hour");
            int minute = extras.getInt("minute");
        }
        ringtone.stop();
       // if(timerHasStarted); countDownTimer.cancel();
        if(time <= 100) time = 300000;
        countDownTimer = new MyCountDownTimer(time, interval);
        countDownTimer.start();
        Log.d("outside", "apple");
    }

    public void stop(View view) {
        ringtone.stop();
        countDownTimer.cancel();
        countDownTimer.cancel();
        //RingtoneManager ringtoneManager = new RingtoneManager(Main.this);

        //ringtoneManager.stopPreviousRingtone();
        //Intent intent = new Intent(Main.this, AlarmReceiver.class);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
        //AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //pendingIntent.cancel();
        //alarmManager.cancel(pendingIntent);
        //Log.d("thing2", " " + pendingIntent.describeContents());
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();

        //Intent i = new Intent(this, AlarmRing.class);
        //stopService(i);
        //Intent stopIntent = new Intent(this, RingtonePlayingService.class);
        //this.stopService(stopIntent);
        //ring.stop();
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

    public void snooze(View view) {
        ringtone.stop();
        Intent intent = new Intent(this, HTTPPostActivity.class);
        ringtone.stop();
        countDownTimer.cancel();
        countDownTimer = new MyCountDownTimer(5*60*1000,interval);
        countDownTimer.start();
        ringtone.stop();
        //Intent intent2 = new Intent(this, MainActivity.class);
        //startActivity(intent2);
        Toast.makeText(this, "Alarm Snoozed", Toast.LENGTH_SHORT).show();
        //startActivity(intent2);
        //Intent intent2 = new Intent(this, AlarmReceiver.class);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        //AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        // pendingIntent.cancel();
        //alarmManager.cancel(pendingIntent);
        //RingtoneManager ringtoneManager = new RingtoneManager(Main.this);
        //ringtoneManager.stopPreviousRingtone();
        //Intent i = new Intent(this, AlarmRing.class);
        //stopService(i);
        //Intent stopIntent = new Intent(this, RingtonePlayingService.class);
        //this.stopService(stopIntent);
        startActivity(intent);

    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }


        @Override
        public void onFinish() {
             alarmTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
             ringtone = RingtoneManager.getRingtone(getApplicationContext(), alarmTone);
            //RingtonePlayingService ring = new RingtonePlayingService();
            //ring.play();
            ringtone.play();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT ).show();
            Log.d("countermsg", "apple");
        }
    }
}