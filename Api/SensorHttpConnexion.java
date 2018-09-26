package com.example.bauwensn.myapplication.Api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.bauwensn.myapplication.Models.SensorData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class SensorHttpConnexion extends AsyncTask<String, Void, ArrayList<SensorData>> {

    public interface SensorResult {
        void onTaskCompleted(ArrayList<SensorData> sensorArray);
    }

    private SensorResult callback;

    public void setCallback(SensorResult callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //private static String BASE_URL = "https://wt-61e473cce099e4c955c5728dc16e1f96-0.sandbox.auth0-extend.com/proximity";
    private static String BASE_URL = "http://172.17.41.55:8080/devices/lastDevice";
    private String adress = "";
    private String result;
    private ArrayList<SensorData> sensorArray;

    protected ArrayList<SensorData> doInBackground(String... strings) {

        try {
                    adress = strings[0];
                    URL url = new URL(BASE_URL);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                    StringBuilder builder = new StringBuilder();

                    String inputString;
                    while ((inputString = bufferedReader.readLine()) != null) {
                        builder.append(inputString + "\r\n");
                    }
                    result = builder.toString();

                    urlConnection.disconnect();
                    bufferedReader.close();

                    try {
                        //JSONObject jObject = new JSONObject(result);
                        JSONArray data = new JSONArray(result);
                        //JSONArray data = jObject.getJSONArray("data");

                        sensorArray = new ArrayList<>();
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject c = data.getJSONObject(i);
                            String deviceId = c.getString("deviceId");
                            String street = c.getString("street");
                            String proximity = c.getString("proximity");

                            SensorData sensor = new SensorData(
                                    deviceId,
                                    street,
                                    proximity
                            );
                            sensorArray.add(sensor);
                        }

                    }catch (final JSONException e) {
                        e.printStackTrace();
                        return null;
                    }
                    return sensorArray;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

        }


    protected void onPostExecute(ArrayList<SensorData> sensorArray) {
        if(callback != null) {
            callback.onTaskCompleted(sensorArray);
        }
    }


}
