package com.example.bobby.nwumobile;

import android.support.v7.app.AppCompatActivity;

public class Students extends AppCompatActivity {

    public String studentNumber;
    public String studentName;
    public String studentPassword;

    public Students() {
    }

    public Students(String studentNumber, String studentPassword) {
        this.studentNumber = studentNumber;
        this.studentPassword = studentPassword;
    }


}
