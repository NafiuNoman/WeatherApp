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


                MainActivity.temp.setText(obj.getString("temp"));
               /* String a= obj.getString("temp");
                Integer b = Integer.parseInt(a);
                MainActivity.temp.setText(b);*/

                MainActivity.maxTemp.setText(obj.getString("temp_max"));
                MainActivity.minTemp.setText(obj.getString("temp_min"));

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
