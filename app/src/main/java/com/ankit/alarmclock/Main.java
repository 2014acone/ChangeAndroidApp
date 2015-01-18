package com.ankit.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import org.apache.commons.logging.Log;
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


public class Main extends ActionBarActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new Snooze.PlaceholderFragment())
                    .commit();
        }
    }

   public void stop(View view){
       Intent intent = new Intent(this, AlarmReceiver.class);
       PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
       AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
       alarmManager.cancel(pendingIntent);
       Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_LONG).show();
       //Intent intent2 = new Intent(this, MainActivity.class);
       //startActivity(intent2);
       Intent stopIntent = new Intent(this, RingtonePlayingService.class);
       this.stopService(stopIntent);





   }


    public void snooze(View view){
        Intent intent = new Intent(this, HTTPPostActivity.class);
        //Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent);
        //startActivity(intent2);
        Toast.makeText(this, "Alarm Snoozed", Toast.LENGTH_LONG).show();
        //startActivity(intent2);
        Intent intent2 = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent2, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

        Intent stopIntent = new Intent(this, RingtonePlayingService.class);
        this.stopService(stopIntent);
        /*Date date = new java.util.Date();

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://api.venmo.com/v1/payments?");

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("access_token", "NSLYQ8zykgJKVzqfCLVxVZN6Qaw5SpKG"));
        pairs.add(new BasicNameValuePair("email", "ank.h.shah@gmail.com"));
        pairs.add(new BasicNameValuePair("note", "date:"+date+"."));
        pairs.add(new BasicNameValuePair("amount", "0.01"));
        try{
            post.setEntity(new UrlEncodedFormEntity(pairs));
        }catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        try{
            HttpResponse response = client.execute(post);
        }catch (ClientProtocolException e) {
            // Log exception
            e.printStackTrace();
        } catch (IOException e) {
            // Log exception
            e.printStackTrace();
        }*/




        /*WebView webView = new WebView(this);

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.layout);
        relativeLayout.addView(webView);

        Date date = new java.util.Date();

        webView.loadUrl("https://venmo.com/?txn=pay&recipients=ankits96&amount=.01&note="+date+"&audience=public");*/
    }
}
