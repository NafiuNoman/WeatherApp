package com.example.practicevolley;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Connect  {


    String city;


    Connect(String loc)
    {
         city = loc;
    }



public void Start()
{

   // String url="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=90c80ed73e6258c82389e83487f872d5";
    String url="https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=90c80ed73e6258c82389e83487f872d5";




    JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            try {

                JSONObject obj = response.getJSONObject("main");
                JSONObject obj2 = response.getJSONObject("sys");



                JSONArray array = response.getJSONArray("weather");
                JSONObject arrayObj = array.getJSONObject(0);

                MainActivity.status.setText(arrayObj.getString("main"));


                /*its working but its cant show int value its shows doubble value case getString();fuction take value as a string so its doubble came within it
                and its show the doubble value if exists

                MainActivity.temp.setText(obj.getString("temp"));

                 */





                //not working getInt
               // MainActivity.temp.setText(obj.getInt("temp"));


               /*
                not working in this way

                String a= obj.getString("temp");
                Integer b = Integer.parseInt(a);
                MainActivity.temp.setText(b);*/

/*
                  working Hahahaha atlast
                  this way you have get the int value from JSONobject as a int but you cant directly set int value in textView
                  so you have to use String.valueOf(); funtion its takes any data type and make it as a String . Now you can
                  int your int value as String in the field.


                  int tm =obj.getInt("temp_max");
                  int tmi =obj.getInt("temp_min");

                  String Stm=String.valueOf(tm);
                  String stmi=String.valueOf(tmi);

                  MainActivity.minTemp.setText(stmi);
                  MainActivity.maxTemp.setText(Stm);


 */             MainActivity.temp.setText(String.valueOf(obj.getInt("temp")));
                MainActivity.minTemp.setText(String.valueOf(obj.getInt("temp_min")));
                MainActivity.maxTemp.setText(String.valueOf(obj.getInt("temp_max")));


                MainActivity.country.setText(obj2.getString("country"));


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {


        }
    });


    MainActivity.requestQueue.add(jsonObjectRequest);


}


}
