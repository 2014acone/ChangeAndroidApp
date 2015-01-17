package com.ankit.alarmclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.GregorianCalendar;


public class MainActivity extends FragmentActivity implements TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener {
    private int pickerHour = 0, pickerMin = 0, pickerDay = 0, pickerMonth = -1, pickerYear = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scheduleAlarm(View v){
        Long time = new GregorianCalendar().getTimeInMillis()+5*1000;
        long alarmTime = (time - new GregorianCalendar().getTimeInMillis())/1000;
        Intent intentAlarm = new Intent(this, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, PendingIntent.getBroadcast(this, 1, intentAlarm,
                PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Alarm Scheduled for " + alarmTime + " seconds",Toast.LENGTH_LONG).show();
    }

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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
