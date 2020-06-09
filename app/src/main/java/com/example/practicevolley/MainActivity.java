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


    public static TextView txt ;
    Button btn;
    EditText editText;
    String city;


     public static RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       requestQueue= Volley.newRequestQueue(this);




        txt=findViewById(R.id.display);
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
