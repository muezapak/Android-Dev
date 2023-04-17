package com.example.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //variable declaration
    //private TextView textView;
    private TextView editText;
    //private Button buttonO;
    //private Button buttonS;
    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //now we will initialize variables by searching relative elements from resources
       // textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextNumber);
        // private TextView msg = findViewById(R.id.response);
        Button buttonP = findViewById(R.id.buttonP);
        Button buttonO=findViewById(R.id.buttonO);
        Button buttonS=findViewById(R.id.buttonS);
        res=findViewById(R.id.textView2);


        buttonP.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "submitted clicked successfully", Toast.LENGTH_SHORT).show();

                String kg=editText.getText().toString();
                double val=Double.parseDouble(kg);
                        double pounds= val*2.205;
                        res.setText("value in pounds=\t"+pounds);

            }
        });
      buttonO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kg=editText.getText().toString();
                double val=Double.parseDouble(kg);

                double ounce=val*35.274;
                res.setText("value in Ounces=\t"+ounce);
            }
        });
       buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kg=editText.getText().toString();
                double val=Double.parseDouble(kg);
                double stone=val*0.158;
                res.setText("value in Stones=\t"+stone);
            }
        });

    }
}