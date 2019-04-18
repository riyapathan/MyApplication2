package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity
{
    RadioGroup radiogroup;
    Button back,next;
    RadioButton rd_female,rd_male;
    static String gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        RadioGroup radiogroup=(RadioGroup)findViewById(R.id.rg);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton radioButton=(RadioButton)findViewById(checkedId);
               gender=radioButton.getText().toString();
                Toast.makeText(GenderActivity.this, "You Select :"+gender, Toast.LENGTH_LONG).show();


            }
        });
        back=(Button)findViewById(R.id.Back2);
        next=(Button)findViewById(R.id.Next2);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent i3=new Intent(getBaseContext(),UsernameActivity.class);
                Bundle extra=new Bundle();
                setResult(RESULT_OK);
                startActivity(i3);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent i4=new Intent(GenderActivity.this,DOB_Comment.class);

                startActivity(i4);


            }
        });





    }


    public static String mygender()
    {
        return gender;
    }


}
