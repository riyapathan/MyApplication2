package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GenderActivity extends AppCompatActivity
{
    RadioGroup rg;
    Button back,next;
    RadioButton rd_female,rd_male;
    static String gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);


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

   private void onRadioButtonClicked(View view)
    {

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radiofemale:
                if (checked)
                {
                    gender=rd_female.getText().toString();
                }

                break;
            case R.id.radiomale:
                if (checked)
                {
                    gender=rd_male.getText().toString();
                }
                break;
        }



    }

    public static String mygender()
    {
        return gender;
    }


}
