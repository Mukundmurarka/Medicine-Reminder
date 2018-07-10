package com.mukundmurarka.medicinereminder;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main2Activity extends AppCompatActivity {
    EditText name,date,time;
    TextView datePick,timepick;
    private int mYear, mMonth, mDay, mHour, mMinute;

    private int userYear,userMonth,userDay,userHour,userMinute;

    SimpleDateFormat format;
    Button save,setalarm;
    java.sql.Time timeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.namemm);
        date = findViewById(R.id.editText2);
        time = findViewById(R.id.editText3);
        setalarm = findViewById(R.id.button2);
        save = findViewById(R.id.button);
        datePick= findViewById(R.id.textView2);
        timepick = findViewById(R.id.textView3);
        datePick.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dd = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {


                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        try {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                            Date dtdate = formatter.parse(dateInString);

                            date.setText(formatter.format(dtdate).toString());

                            formatter = new SimpleDateFormat("dd/MMM/yyyy");


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },userYear,userMonth,userDay);
                dd.show();
            }
        });
        timepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);
                TimePickerDialog tt = new TimePickerDialog(Main2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                     try
                     {
                         String dtStart = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
                         format = new SimpleDateFormat("HH:mm");

                         timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                         time.setText(String.valueOf(timeValue));

                         userMinute = minute;
                         userHour = hourOfDay;

                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                    }
                }, userHour,userMinute, DateFormat.is24HourFormat(Main2Activity.this));
                tt.show();
            }
        });

        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // long timet=Integer.parseInt(String.valueOf(time));
                Intent i =  new Intent(Main2Activity.this,Alarm.class);
                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),0, i,0);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

                long hour = TimeUnit.HOURS.toMillis((long)userHour);
                long minute = TimeUnit.MINUTES.toMillis((long)userMinute);

                long totalMillSecond = hour+minute;
                Log.d("test",""+totalMillSecond);
                am.set(AlarmManager.RTC_WAKEUP,totalMillSecond,pi);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"add successfully",Toast.LENGTH_LONG).show();
            }
        });


    }
}


