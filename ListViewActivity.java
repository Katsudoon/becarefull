package com.example.bauwensn.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bauwensn.myapplication.Adapter.SensorAdapter;
import com.example.bauwensn.myapplication.Api.SensorHttpConnexion;
import com.example.bauwensn.myapplication.Models.SensorData;

import java.util.ArrayList;


public class ListViewActivity extends AppCompatActivity implements SensorHttpConnexion.SensorResult {

    String adress;
    ListView listView;
    TextView titre;
    private SensorData sensor;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_activity);
        listView = findViewById(R.id.listView);
        titre = findViewById(R.id.titre);
        Bundle extras = getIntent().getExtras();
        adress = extras.getString("adress");
        mHandler = new Handler();


        SensorHttpConnexion task = new SensorHttpConnexion();
        task.setCallback(this);
        task.execute(adress);



    }

    @Override
    public void onTaskCompleted(ArrayList<SensorData> sensorArray) {
        if (sensorArray != null) {
            SensorAdapter adapter = new SensorAdapter(this, sensorArray);
            listView.setAdapter(adapter);
        }
        else {
            titre.setText("Aucune place pres de cet endroit");
        }


    }




}
