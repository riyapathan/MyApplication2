package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{

    RadioButton RdEnglish,RdHindi,RdMarathi,RdUrdu;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        RdEnglish=(RadioButton)findViewById(R.id.rdenglish);
        RdHindi=(RadioButton)findViewById(R.id.rdhindi);
        RdMarathi=(RadioButton)findViewById(R.id.rdmarathi);
        RdUrdu=(RadioButton)findViewById(R.id.rdurdu);

        next=(Button)findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getBaseContext(),UsernameActivity.class);
                startActivity(intent);
            }
        });
    }

    public void check(View view)
    {
        if(RdEnglish.isChecked())
        {
            Toast.makeText(getApplicationContext(), "You Selected "+RdEnglish.getText().toString(), Toast.LENGTH_LONG).show();
            setLocale("en");
            recreate();
        }
        else if(RdHindi.isChecked())
        {
            Toast.makeText(getApplicationContext(), "आपने चुना "+RdHindi.getText().toString(), Toast.LENGTH_LONG).show();
            setLocale("hi");
            recreate();
        }
        else if(RdMarathi.isChecked())
        {
            Toast.makeText(getApplicationContext(), "आपण निवडला आहे "+RdMarathi.getText().toString(), Toast.LENGTH_LONG).show();
            setLocale("mi");
            recreate();
        }
        else if(RdUrdu.isChecked())
        {
            Toast.makeText(getApplicationContext(), " آپ نے منتخب کیا"+RdUrdu.getText().toString(), Toast.LENGTH_LONG).show();
            setLocale("ur");
            recreate();
        }
    }

    private void setLocale(String lang)
    {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }

    public void loadLocale()
    {
        SharedPreferences prefs=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=prefs.getString("My_Lang","");
        setLocale(language);
    }



}
