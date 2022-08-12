package com.example.yo7a.healthwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutApp extends AppCompatActivity {

    int temp, heartrate, respiration, pressure , saturation;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        Intent i= getIntent();
        temp= Integer.parseInt(i.getStringExtra("Temperature"));
        heartrate= Integer.parseInt(i.getStringExtra("Heart"));
        respiration= Integer.parseInt(i.getStringExtra("Respiration"));
        //pressure= Integer.parseInt(i.getStringExtra("Pressure"));
        saturation= Integer.parseInt(i.getStringExtra("Oxygen"));
        result=findViewById(R.id.result);
        if(temp<98){
            if(heartrate<90 & heartrate>60){
                if(respiration<20 & respiration>12){
                    result.setText("All vitals are normal and suggest you are healthy . although it is advised to visit a physician if you get dry cough");
                }else{
                    result.setText("All vitals are normal except you breathing seems laboured. it is advised to visit a physician just to be safe");
                }
            }else{
                result.setText("Your Heartrate seems to be out of the normal range.take multiple readings in a relaxed environment. if it persists visit a physician");
            }
        }else{
            result.setText("High Temperature is consistent wth symptoms of corona virus . you should visit a physician for more accurate results");
        }






    }


}
