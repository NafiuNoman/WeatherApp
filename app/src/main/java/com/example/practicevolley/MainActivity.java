package com.example.practicevolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity  {


    public static TextView temp ;
    public static TextView country ;
    public static TextView status ;
    public static TextView minTemp;
    public static TextView maxTemp ;

    Button btn;
    EditText editText;
    String city;


     public static RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       requestQueue= Volley.newRequestQueue(this);

        temp=findViewById(R.id.displayTemp);
        minTemp=findViewById(R.id.displayMin);
        maxTemp=findViewById(R.id.displayMax);
        country=findViewById(R.id.displayCountry);
        status=findViewById(R.id.displayStatus);

        btn=findViewById(R.id.btn);
        editText=findViewById(R.id.edit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                city=editText.getText().toString();
                Connect connect = new Connect(city);
                connect.Start();





            }

        });




    }



}
