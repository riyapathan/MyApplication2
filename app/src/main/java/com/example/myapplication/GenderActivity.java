package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity
{
    Button back,next;
    RadioButton rd_female,rd_male;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        back=(Button)findViewById(R.id.Back2);
        next=(Button)findViewById(R.id.Next2);

        rd_female=(RadioButton)findViewById(R.id.radiofemale);
        rd_male=(RadioButton)findViewById(R.id.radiomale);
        Bundle bundle=null;
        bundle=getIntent().getExtras();

        if(bundle!=null)
        {
            Toast.makeText(GenderActivity.this, "Data Passed", Toast.LENGTH_LONG).show();
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
                Intent i1=new Intent(getBaseContext(),UsernameActivity.class);
                startActivity(i1);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent i2=new Intent(getBaseContext(),DOB_Comment.class);
                startActivity(i2);
            }
        });

    }

    /*private void onRadioButtonClicked(View view)
    {
        String gender="";
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
    }*/


}
