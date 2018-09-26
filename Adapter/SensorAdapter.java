package com.example.bauwensn.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bauwensn.myapplication.Models.SensorData;
import com.example.bauwensn.myapplication.R;

import java.util.List;


public class SensorAdapter extends ArrayAdapter<SensorData> {



    public SensorAdapter(@NonNull Context context, List<SensorData> sensors) {
        super(context, 0, sensors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_of_list, parent, false);

        TextView tvAddr = view.findViewById(R.id.item_list_street);
        TextView tvPlace = view.findViewById(R.id.item_list_place);
        ImageView imgLogo = view.findViewById(R.id.item_list_logo);

        SensorData data = getItem(position);

        tvAddr.setText(data.getAdresse());
        int resImgKo = R.drawable.icone_pas_ok;
        int resImgOk = R.drawable.icone_ok;
        if (Integer.parseInt(data.getProximity()) > 50) {
            imgLogo.setImageResource(resImgKo);
            tvPlace.setText("La place est prise");
        }else {
            imgLogo.setImageResource(resImgOk);
            tvPlace.setText("La place est libre");
        }

        return  view;
    }
}
