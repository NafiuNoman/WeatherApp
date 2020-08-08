package com.example.practicevolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import android.text.Layout;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity  {


    public static TextView temp ;
    public static TextView country ;
    public static TextView status ;
    public static TextView minTemp;
    public static TextView maxTemp ;
    public static RelativeLayout rel ;



    SwipeRefreshLayout swipeRefreshLayout;
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
        rel = findViewById(R.id.layout);

        btn=findViewById(R.id.btn);
        editText=findViewById(R.id.edit);

        //swipeRefreshLayout = findViewById(R.id.swipeId);


        rel.setAnimation(AnimationUtils.loadAnimation(this,R.anim.animate));




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                city=editText.getText().toString();
                Connect connect = new Connect(city);
                connect.Start();






            }

        });


//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//                Connect connect = new Connect(city);
//                connect.Start();
//
//                swipeRefreshLayout.setRefreshing(false);
//
//            }
//        });




    }



}
