package com.ankit.alarmclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.CountDownTimer;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity{//FragmentActivity implements TimePickerDialog.OnTimeSetListener,
        //DatePickerDialog.OnDateSetListener
    //private int pickerHour = 0, pickerMin = 0, pickerDay = 0, pickerMonth = -1, pickerYear = 0;
    //Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
   // Ringtone ringtone;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker timeChooser;
    private static MainActivity inst;
    private int totalTime;

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
        setContentView(R.layout.activity_main);
        timeChooser = (TimePicker)findViewById(R.id.timeChooser);
        timeChooser.setIs24HourView(true);
        timeChooser.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        Button timebutton = (Button)findViewById(R.id.timebutton);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
    }

    public void onClick(View view){
        Calendar calendar = Calendar.getInstance();
        int hour = timeChooser.getCurrentHour();
        Log.d("hour" , " "+ hour);
        Log.d("hour"," " + calendar.get(Calendar.HOUR_OF_DAY));
        int minute = timeChooser.getCurrentMinute();
        Log.d("minute" , " " +minute);
        Log.d("minute", " "+calendar.get(Calendar.MINUTE));
        int hours = (Math.abs(hour - calendar.get(Calendar.HOUR_OF_DAY)))*60*60*1000;
        Log.d("hours" , " "+ hours);
        int minutes = Math.abs((minute * 60 *1000)-(calendar.get(Calendar.MINUTE)*60*1000));
        Log.d("minutes" , " "+ minutes);
        int milHours = calendar.get(Calendar.HOUR_OF_DAY)*60*60*1000;
        int milMin = calendar.get(Calendar.MINUTE)*60*1000;
        int milhour = hour * 60*60*1000;
        int milmin = minute * 60 * 1000;
        calendar.set(Calendar.HOUR_OF_DAY, timeChooser.getCurrentHour());
        calendar.set(Calendar.MINUTE, timeChooser.getCurrentMinute());
        int milCalc = Math.abs(milhour - milHours)+Math.abs(milmin-milMin);
        int totalTime = hours + minutes;
        //totalTime = hour+minute;
        //Intent myIntent = new Intent(this, AlarmReceiver.class);
        Toast.makeText(this, "Alarm Scheduled", Toast.LENGTH_SHORT).show();
        //pendingIntent = PendingIntent.getBroadcast(this,0,myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
       //Log.d("thing", " " + alarmManager );
        //alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        //alarmManager.cancel(pendingIntent);
        Log.d("calendar", " " + calendar.getTimeInMillis());
        Log.d("calculated", " " + totalTime);
        Log.d("second calc", " " + milCalc);
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
        Intent i = new Intent(getApplicationContext(), Main.class);
        i.putExtra("time", milCalc);
        i.putExtra("hour", hour);
        i.putExtra("minute", minute);
        startActivity(i);

    }
   /*CountDownTimer count = new CountDownTimer(3000, 1000){

       public void onTick(long millisUntilFinished){

       }
       public void onFinish(){
           RingtonePlayingService hi = new RingtonePlayingService();
           hi.play();
       }
    }.start();*/


}
