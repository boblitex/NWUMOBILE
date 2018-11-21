package com.example.bobby.nwumobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_stu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.Profile_stu):
                Toast.makeText(getApplicationContext(), "Student profile", Toast.LENGTH_LONG).show();
                return true;
            case (R.id.change_stu):
                Toast.makeText(getApplicationContext(), "password changed", Toast.LENGTH_LONG).show();
                return true;
            case (R.id.Logout_stu):
                final ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
                progressDialog.setMessage("Logging Out");
                progressDialog.show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }










































}
