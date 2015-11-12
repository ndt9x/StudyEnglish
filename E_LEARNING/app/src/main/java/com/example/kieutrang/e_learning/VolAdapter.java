package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 11/1/2015.
 */
public class VolAdapter extends ArrayAdapter<String> {
    Activity context = null;
    ArrayList<String> arr = null;
    int layoutId;

    public VolAdapter(Activity context, int layoutId, ArrayList<String> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.arr = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layoutId, null);
        }
        TextView bt= (TextView)convertView.findViewById(R.id.tvVolbt);
        bt.setText(arr.get(position));
        return convertView;
    }
}
