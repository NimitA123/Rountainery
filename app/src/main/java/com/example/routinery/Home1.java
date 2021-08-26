package com.example.routinery;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Home1 extends AppCompatActivity {
    private ImageView img;
    private EditText et;
    private ImageView clk;
    private EditText StartDate;
    private EditText EndDate;
    int y;
    int m;
    int d;
    int t1Hour, t1Minute, t2Hour, t2Minute;
    private Button setTime;
    private EditText PersonName;
    private int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        img = findViewById(R.id.img1);
        et = findViewById(R.id.tvDate);

      //  PersonName = findViewById(R.id.tvPerson);
        /**** getInstance will gives updates date from the new Year ****/
        final Calendar c = Calendar.getInstance();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog g = new DatePickerDialog(Home1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        et.setText(i + "/" + i1 + "/" + i2);

                    }
                }, y, m, d);
                g.show();
            }
        });
        clk = findViewById(R.id.Watch);
        StartDate = findViewById(R.id.tvStartDate);
        EndDate = findViewById(R.id.tvEndDate);
        StartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Home1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        t2Hour = i;
                        t2Minute = i1;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0, 0, 0, t2Hour, t2Minute);
                        StartDate.setText(DateFormat.format("hh:mm aa", calendar));
                    }
                }, 12, 0, false);
                timePickerDialog.updateTime(t2Hour, t2Minute);
                timePickerDialog.show();
            }
        });
        EndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Home1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        t1Hour = i;
                        t1Minute = i1;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0, 0, 0, t1Hour, t1Minute);
                        EndDate.setText(DateFormat.format("hh:mm aa", calendar));
                    }
                }, 12, 0, false);
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });


        setTime = findViewById(R.id.setTime);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText comment = findViewById(R.id.tvComment);
              //  TimePicker timePicker =  findViewById(R.id.timePicker);
                //set notification & text.
                Intent intent = new Intent(Home1.this, AlarmReceiver.class);
                intent.putExtra("notificationId", notificationId);
                intent.putExtra("todo", comment.getText().toString());
                //getBroadcast(context, request(code, intent, flags)
                PendingIntent alarmIntent = PendingIntent.getBroadcast
                        (Home1.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
                switch (view.getId()){
                    case R.id.setTime:
                     //   int hour = timePicker.getCurrentHour();
                      //  int minutes = timePicker.getCurrentMinute();
                        //create Time
                        Calendar startTime = Calendar.getInstance();
                        startTime.set(Calendar.HOUR_OF_DAY, t1Hour);
                        startTime.set(Calendar.MINUTE, t1Minute);
                        startTime.set(Calendar.SECOND, 0);
                        long alarmStartTime = startTime.getTimeInMillis();

                        //set Alarm
                        //set(type, millisecond, intent)
                        alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
                        Toast.makeText(Home1.this, "Done!", Toast.LENGTH_LONG).show();
                        break;

                }



            }


        });


    }
}