package com.example.bobby.nwumobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class LecturerDashboard extends AppCompatActivity {

    private TextView textViewl;
    private Spinner spinnerl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_dashboard);

        textViewl = findViewById(R.id.textView2);
        spinnerl = findViewById(R.id.spinner2);

        textViewl.setText("Welcome, " + getIntent().getStringExtra("Name"));

    }
}
