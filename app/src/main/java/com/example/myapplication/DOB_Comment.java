package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class DOB_Comment extends AppCompatActivity
{
    DatabaseHelper myDb=new DatabaseHelper(this);
    EditText birthdate,comments;
    DatePickerDialog datePickerDialog;
    Button register;
    String B_date,cmnt;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dob__comment);

        // initiate the date picker and a button and edit text
        birthdate = (EditText) findViewById(R.id.date);
        comments = (EditText) findViewById(R.id.editComment);
        register = (Button) findViewById(R.id.button_add);


        // perform click event on edit text
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(DOB_Comment.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                birthdate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        AddData();

    }

    public void AddData()
    {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //username activity
                String first_name= UsernameActivity.setFirstname();
                String last_name= UsernameActivity.setLastname();

                //gender activity
                String gender=GenderActivity.mygender();

                //DOB_comment activity
                cmnt=comments.getText().toString();
                B_date=birthdate.getText().toString();

                boolean isInserted = myDb.insertData(first_name,last_name,gender,B_date,cmnt);
                if (isInserted == true)
                    Toast.makeText(DOB_Comment.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DOB_Comment.this, "Data not Inserted", Toast.LENGTH_LONG).show();


            }
        });
    }


}
