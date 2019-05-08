package com.example.doctor;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    String docName, docSpecial;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner specialisation = findViewById(R.id.specialisation);
        final Spinner doctorName = findViewById(R.id.doctorName);
        submitBtn = findViewById(R.id.submitBtn);


        ArrayAdapter<String> specialisationSpinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.specialisation));

        ArrayAdapter<String> doctorNameSpinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.list_empty));


        specialisationSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        specialisation.setAdapter(specialisationSpinnerAdapter);



        specialisation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String specialisationString = specialisation.getSelectedItem().toString();


                ArrayAdapter<String> doctorNameSpinnerAdapter;

                String[]  doctorNameArray = null;

                switch (position){

                    case 1:
                        docSpecial = "Anesthesiologists";
                        doctorNameArray = getResources().getStringArray(R.array.Anesthesiologists);
                        break;

                    case 2:
                        docSpecial = "Cardiologist";
                        doctorNameArray = getResources().getStringArray(R.array.Cardiologist);
                        break;

                         default:
                             docSpecial = "";

                             doctorNameArray = getResources().getStringArray(R.array.list_empty);
                             break;


                }
                if(doctorName != null) {
                    doctorNameSpinnerAdapter = new ArrayAdapter<>(MainActivity.this,
                            android.R.layout.simple_spinner_item,
                            doctorNameArray);

                    doctorNameSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    doctorName.setAdapter(doctorNameSpinnerAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        doctorName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                docName = doctorName.getSelectedItem().toString();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ResultActivity.class);
                i.putExtra("doctor", docName);
                i.putExtra("special",docSpecial);
                startActivity(i);
            }
        });

    }



}
