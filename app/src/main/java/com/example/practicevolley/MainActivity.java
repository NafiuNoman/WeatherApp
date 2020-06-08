package com.example.practicevolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView txt ;
    Button btn;
    EditText editText;
    String city;

    RequestQueue requestQueue;
   // requestQueue= Volley.newRequestQueue(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);




        txt=findViewById(R.id.display);
        btn=findViewById(R.id.btn);
        editText=findViewById(R.id.edit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            city= editText.getText().toString();


        //    }
        //});



        //String url="https://jsonplaceholder.typicode.com/todos/1";

        String url="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=90c80ed73e6258c82389e83487f872d5";
        txt.setText(url);








                JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {


                    //WORKING
                    JSONObject obj = response.getJSONObject("sys");
                    JSONObject obj2 = response.getJSONObject("main");
                    String temp = String.valueOf(obj.getDouble("sunrise"));
                    String pani = String.valueOf(obj2.getInt("humidity"));
                    String name = obj.getString("country");





                  /*
                    //NOT WORKING
                    //String temp = response.getString("temp");

                   */







                    txt.setText(temp+"\n\n"+name+"\n\n"+pani);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("myapp","Somthing went wrong");

            }
        }


        ) ;




       requestQueue.add(jsonObjectRequest);


            }

        });




    }



}
