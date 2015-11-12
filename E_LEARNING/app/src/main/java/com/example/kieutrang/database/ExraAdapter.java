package com.example.kieutrang.database;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kieutrang.e_learning.R;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 10/30/2015.
 */
public class ExraAdapter extends ArrayAdapter<Extra> {
    private ArrayList<Extra> arrayList;
    private Extra entity;
    private Activity context;
    int resource;


    public ExraAdapter(ArrayList<Extra> arrayList, Activity context, int resource) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(resource, null);
        }
        TextView tvNoidung = (TextView) convertView.findViewById(R.id.tvExtra_content);
        tvNoidung.setText(arrayList.get(position).getNoidung());
        return convertView;
    }
}
