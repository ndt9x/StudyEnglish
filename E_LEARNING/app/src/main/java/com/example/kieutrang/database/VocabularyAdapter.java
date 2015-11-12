package com.example.kieutrang.database;

import android.app.Activity;
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
public class VocabularyAdapter extends ArrayAdapter<Vocabulary> {
    private ArrayList<Vocabulary> arrayList;
    private Vocabulary entity;
    private Activity context;
    int resource;

    public VocabularyAdapter(ArrayList<Vocabulary> arrayList, Activity context, int resource) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(resource,null);
            TextView tvTen =(TextView)convertView.findViewById(R.id.tvitem_ten);
            TextView tvPhienam = (TextView) convertView.findViewById(R.id.tvitem_phiemam);
            TextView tvNghia = (TextView) convertView.findViewById(R.id.tvitem_nghia);
            TextView tvVidu = (TextView) convertView.findViewById(R.id.tvitem_vidu);
            tvTen.setText(arrayList.get(position).getTenchu());
            tvPhienam.setText(arrayList.get(position).getPhienam());
            tvNghia.setText(arrayList.get(position).getNghia());
            tvVidu.setText(arrayList.get(position).getVidu());
        }
            return convertView;
    }
}
