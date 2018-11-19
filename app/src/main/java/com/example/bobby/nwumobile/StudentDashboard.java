package com.example.bobby.nwumobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bobby.nwumobile.Model.Users;
import com.google.firebase.database.FirebaseDatabase;


public class StudentDashboard extends AppCompatActivity {

    private TextView textView;
    private Spinner spinner;
    private FirebaseDatabase stdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        textView.setText("Welcome, "+ getIntent().getStringExtra("Name") );



    }
}
