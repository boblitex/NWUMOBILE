package com.example.bobby.nwumobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lect,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case (R.id.Profile):
                Toast.makeText(getApplicationContext(),"Lecturer profile",Toast.LENGTH_LONG).show();
                return true;
            case (R.id.change):
                Toast.makeText(getApplicationContext(),"password changed",Toast.LENGTH_LONG).show();
                return true;
            case (R.id.Logout):
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
