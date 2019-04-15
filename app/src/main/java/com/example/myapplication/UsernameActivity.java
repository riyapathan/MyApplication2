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
    EditText firstname,lastname;

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
                String fname=firstname.getText().toString();
                String lname=lastname.getText().toString();

                Intent i2=new Intent(getApplicationContext(),GenderActivity.class);
               i2.putExtra("firstname",fname);
               i2.putExtra("lastname",lname);
                startActivity(i2);
            }
        });


    }
}
