package com.example.bobby.nwumobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bobby.nwumobile.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private EditText nwunumber;
    private EditText password;
    private Button login;
    private CheckBox showpassword;
    private DatabaseReference mdatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = getResources().getDrawable(R.drawable.background);
        drawable.setAlpha(50);

        nwunumber = findViewById(R.id.StudentNo);
        password = findViewById(R.id.Password);
        login = findViewById(R.id.button);
        showpassword = findViewById(R.id.show_hide);

        CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showpassword.setText(R.string.hide_password);
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    showpassword.setText(R.string.show_password);
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        };
        showpassword.setOnCheckedChangeListener(changeListener);

        mdatabase = FirebaseDatabase.getInstance().getReference("NwuUsers");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Signing in");
                progressDialog.show();

                mdatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        progressDialog.dismiss();
                        Users users = dataSnapshot.child(nwunumber.getText().toString().trim()).getValue(Users.class);
                        if (dataSnapshot.child(nwunumber.getText().toString().trim()).exists()){

                            if (users.getPassword().equals(password.getText().toString().trim())){
                                switch (users.getTag()){
                                    case "student":
                                        Intent student = new Intent(MainActivity.this,StudentDashboard.class);
                                        student.putExtra("Name",users.getName());
                                        startActivity(student);
                                        break;
                                    case "lecturer":
                                        Intent lecturer = new Intent(MainActivity.this,LecturerDashboard.class);
                                        lecturer.putExtra("Name", users.getName());
                                        startActivity(lecturer);
                                }

                            }
                            else {
                                Toast.makeText(MainActivity.this,"Password is incorrect!",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this,"Nwu number does not exist",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}























