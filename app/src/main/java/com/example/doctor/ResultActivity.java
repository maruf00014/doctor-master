package com.example.doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView name, special, details;

        name = findViewById(R.id.ddoctorName);
        special = findViewById(R.id.doctorSpecialisation);
        details = findViewById(R.id.details);

        name.setText(getIntent().getStringExtra("doctor"));
        special.setText(getIntent().getStringExtra("special"));
        details.setText("Room: "+ ThreadLocalRandom.current().nextInt(201, 512)+","
                +" Serial: "+ThreadLocalRandom.current().nextInt(2, 32)+"," +new SimpleDateFormat(" dd/MM/yyyy, hh:mm aaa")
                .format(new Date(System.currentTimeMillis()+ThreadLocalRandom.current().nextInt(10*60*1000, 3*24*60*60*1000) )));
    }
}
