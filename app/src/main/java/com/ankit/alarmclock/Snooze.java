package com.ankit.alarmclock;

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

import java.io.IOException;
import java.util.Date;
import java.lang.Object;
import android.app.AlarmManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;



public class Snooze extends ActionBarActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void SNOOZE(View view){

        /*HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://api.venmo.com/v1/payments?note=test9&user_id=1559514545389568715&access_token=NSLYQ8zykgJKVzqfCLVxVZN6Qaw5SpKG&amount=0.01");

        try{
            HttpResponse response = client.execute(post);
        }catch(IOException e){}*/


        /*WebView webView = new WebView(this);

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.layout);
        relativeLayout.addView(webView);

        Date date = new java.util.Date();

        webView.loadUrl("https://venmo.com/?txn=pay&recipients=ankits96&amount=.01&note="+date+"&audience=public");*/
    }

   /* public void STOP(View view){

        Intent intent = new Intent(this, AlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1253, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);





    }*/


    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}

