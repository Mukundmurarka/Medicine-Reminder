package com.mukundmurarka.medicinereminder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    ImageView plus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.plus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
//                pickTime();
//                pickDate();
//                Toast.makeText(MainActivity.this,"Date " + userDay+"-"+userMonth+"-"+userYear,Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }
//
//    private void pickTime() {
//
//        // Get Current Time
//
//
//        // Launch Time Picker Dialog
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                Log.d("test", hourOfDay + ":" + minute);
//
//                userHour = hourOfDay;
//                userMinute = minute;
//
//            }
//        }, mHour, mMinute, false);
//
//
//        timePickerDialog.show();
//    }
//
//
//    //date picker method
//    private void pickDate() {
//
//        // Get Current Date
//        final Calendar c = Calendar.getInstance();
//        mYear = c.get(Calendar.YEAR);
//        mMonth = c.get(Calendar.MONTH);
//        mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Log.d("test", dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//
//                userDay = dayOfMonth;
//                userMonth = monthOfYear+1;
//                userYear = year;
//
//            }
//        }, mYear, mMonth, mDay);
//
//        datePickerDialog.show();
//
//    }
//}
