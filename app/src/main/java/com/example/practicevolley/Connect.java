package com.example.practicevolley;
import android.app.DownloadManager;

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
       String url2 = "https://api.waqi.info/feed/"+city+"/?token=6949108ccebe025d0362103e338d7727dfc999cf";





    JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            try {

                JSONObject obj = response.getJSONObject("main");
                JSONObject obj2 = response.getJSONObject("sys");



                JSONArray array = response.getJSONArray("weather");
                JSONObject arrayObj = array.getJSONObject(0);

               // MainActivity.status.setText(arrayObj.getString("main"));

                String condition= arrayObj.getString("main");

                MainActivity.status.setText(condition);

                String s1="Clear";
                String s2="Clouds";
                String s3="Rain";
                String s4="Haze";
                String s5="Snow";


                //condition==s1 that condition was not working

               /* The X.contentEquals() method searches a string to find out if it contains the exact
                same sequence of characters in the specified string or StringBuffer.

                Returns true if the characters exist and false if not.

                */


                if(condition.contentEquals(s1))
                {
                    MainActivity.rel.setBackgroundResource(R.drawable.clearbac);


                }
                else if(condition.contentEquals(s2))
                {
                    MainActivity.rel.setBackgroundResource(R.drawable.cloudbac);

                }
                else if(condition.contentEquals(s3))
                {
                    MainActivity.rel.setBackgroundResource(R.drawable.rainbac);

                } else if(condition.contentEquals(s4))
                {
                    MainActivity.rel.setBackgroundResource(R.drawable.hazebac);

                }
                else if(condition.contentEquals(s5))
                {
                    MainActivity.rel.setBackgroundResource(R.drawable.snowbac);

                }
                else
                {
                    MainActivity.rel.setBackgroundResource(R.drawable.nature1);
                }


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


    JsonObjectRequest jsonObjectRequestAQI = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            try {
                JSONObject jsonObject =response.getJSONObject("data");

               int data = jsonObject.getInt("aqi");
               MainActivity.aqi.setText(""+data);

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
    MainActivity.requestQueue.add(jsonObjectRequestAQI);



}


}
