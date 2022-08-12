package com.example.yo7a.healthwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class VitalSignsResults extends AppCompatActivity {

    private String user, Date;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    int VBP1, VBP2, VRR, VHR, VO2,temp;
    public Button diagnose;
    EditText temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_signs_results);

        Date = df.format(today);
        TextView VSRR = this.findViewById(R.id.RRV);
        TextView VSBPS = this.findViewById(R.id.BP2V);
        TextView VSHR = this.findViewById(R.id.HRV);
        TextView VSO2 = this.findViewById(R.id.O2V);
        diagnose = this.findViewById(R.id.Diagnose);
        temperature = this.findViewById(R.id.editText);
        temperature.setText(getTemp());


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            VRR = bundle.getInt("breath");
            VHR = bundle.getInt("bpm");
            VBP1 = bundle.getInt("SP");
            VBP2 = bundle.getInt("DP");
            VO2 = bundle.getInt("O2R");
            user = bundle.getString("Usr");
            VSRR.setText(String.valueOf(VRR));
            VSHR.setText(String.valueOf(VHR));
            VSBPS.setText(VBP1 + " / " + VBP2);
            VSO2.setText(String.valueOf(VO2));
        }

        diagnose.setOnClickListener(v -> {

            Intent i = new Intent(VitalSignsResults.this,AboutApp.class);

            i.putExtra("Heart",String.valueOf(VHR));
            i.putExtra("Pressure",String.valueOf(VBP1+"/"+VBP2 ));
            i.putExtra("Respiration" , String.valueOf(VRR) );
            i.putExtra("Oxygen", String.valueOf(VO2));
            i.putExtra("Temperature", String.valueOf(temp));
            startActivity(i);
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(VitalSignsResults.this, Primary.class);
        i.putExtra("Usr", user);
        startActivity(i);
        finish();
    }

    public String getTemp(){
        String value="";

        Random rand= new Random();
        int randInt= rand.nextInt();
        while(randInt<35 || randInt>98){
            randInt=rand.nextInt();
        }
        value=randInt+ " F";
        temp=randInt;
        return value;
    }
}

