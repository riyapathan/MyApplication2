package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UsernameActivity extends AppCompatActivity
{


    Button back,next;
    static EditText firstname;
    static EditText lastname;
    static String fname;
    static String lname;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        back=(Button)findViewById(R.id.btnBack);
        next=(Button)findViewById(R.id.btnNext);

        firstname=(EditText)findViewById(R.id.editFirstname);
        lastname=(EditText)findViewById(R.id.editLastname);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i1=new Intent(getBaseContext(),MainActivity.class);
                startActivity(i1);
            }
        });

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                 fname=firstname.getText().toString();

                lname=lastname.getText().toString();



                Intent i2=new Intent(getApplicationContext(),GenderActivity.class);

                startActivity(i2);


            }
        });


    }

    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                firstname.setText(fname);
                lastname.setText(lname);
            }
        }
    }

    //set and get firstname and lastname

    public static String setFirstname()
    {

        return fname;
    }

    public static String setLastname()
    {

        return lname;
    }
}
