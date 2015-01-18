package com.ankit.alarmclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends Activity{//FragmentActivity implements TimePickerDialog.OnTimeSetListener,
        //DatePickerDialog.OnDateSetListener
    //private int pickerHour = 0, pickerMin = 0, pickerDay = 0, pickerMonth = -1, pickerYear = 0;
    //Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
   // Ringtone ringtone;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker timeChooser;
    private static MainActivity inst;

    public static MainActivity instance(){
        return inst;
    }

    @Override
    public void onStart(){
        super.onStart();
        inst=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ankit);
        timeChooser = (TimePicker)findViewById(R.id.timeChooser);
        Button timebutton = (Button)findViewById(R.id.timebutton);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
    }

    public void onClick(View view){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, timeChooser.getCurrentHour());
        calendar.set(Calendar.MINUTE, timeChooser.getCurrentMinute());
        //int hour = timeChooser.getCurrentHour()*60*60*1000;
        //int minute = timeChooser.getCurrentMinute()*60*1000;
        //int totalTime = hour+minute;
        Intent myIntent = new Intent(this, AlarmReceiver.class);
        Toast.makeText(this, "Alarm Scheduled", Toast.LENGTH_SHORT).show();
        pendingIntent = PendingIntent.getBroadcast(this,0,myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
       //Log.d("thing", " " + alarmManager );
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
        //alarmManager.cancel(pendingIntent);
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
/*
   public void scheduleAlarm(View v){
        Long time = new GregorianCalendar().getTimeInMillis()+5*1000;
        long alarmTime = (time - new GregorianCalendar().getTimeInMillis())/1000;
        Intent intentAlarm = new Intent(this, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, PendingIntent.getBroadcast(this, 1, intentAlarm,
                PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Alarm Scheduled for " + alarmTime + " seconds",Toast.LENGTH_LONG).show();
    }
/*
    public void showTimePickerDialog(View v){
        android.app.FragmentManager fm = this.getFragmentManager();
        android.app.DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(fm, "timePicker");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        pickerHour = hourOfDay;
        pickerMin = minute;
        Toast.makeText(this, hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
    }

    public void showDatePickerDialog(View v){
        android.app.FragmentManager fm = this.getFragmentManager();
        android.app.DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(fm, "datePicker");
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        pickerDay = day;
        pickerMonth = month; //indexes from 0
        pickerYear = year;
        Toast.makeText(this, month + "/" + day + "/" + year, Toast.LENGTH_LONG).show();
    }*/
}
