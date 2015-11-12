package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 11/1/2015.
 */
public class TestOffAdapter extends ArrayAdapter<String> {

    Activity context;
    ArrayList<String> itemname;

    int layoutId;

    public TestOffAdapter(Activity context, ArrayList<String> itemname, int layoutId) {
        super(context, layoutId, itemname);
        this.context = context;
        this.layoutId = layoutId;
        this.itemname = itemname;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layoutId, null);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.tvTestitem);
        txtTitle.setText(itemname.get(position));
        return convertView;
    }

}

