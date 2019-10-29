package com.example.baitranlam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnAlarm1;
    Calendar calendar;
    private PendingIntent pendingIntent;
    private TimePicker time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        btnAlarm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sau30snuathibaothuc();
            }
        });
    }
    private void sau30snuathibaothuc() {
        calendar=calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,time.getCurrentHour());
        calendar.set(Calendar.MINUTE,time.getCurrentMinute());
        calendar.set(Calendar.SECOND,0);
        Toast.makeText(this,"Đã thiết lập", Toast.LENGTH_SHORT).show();

        AlarmManager manager =
                (AlarmManager)getSystemService(ALARM_SERVICE);

       manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
    }

    private void addControls() {
        btnAlarm1 = findViewById(R.id.btnAlarm1);
        time=findViewById(R.id.time);
        Intent intent = new Intent(this, BaoThucReceiver.class);
        pendingIntent= PendingIntent.getBroadcast(this, 0, intent, 0);
    }
}
