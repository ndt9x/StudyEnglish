package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kieutrang.database.Extra;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 10/30/2015.
 */
public class ExtraAdapter extends ArrayAdapter<Extra> {

    Activity context;
    ArrayList<Extra> itemname;
    Integer[] imgid;
    int layoutId;
    public ExtraAdapter(Activity context, ArrayList<Extra> itemname, Integer[] imgid, int layoutId) {
        super(context, layoutId,itemname);
        this.context = context;
        this.layoutId=layoutId;
        this.imgid = imgid;
        this.itemname = itemname;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layoutId, null);}

        TextView txtTitle = (TextView) convertView.findViewById(R.id.tvExtraitem);
        ImageView imageView1 = (ImageView) convertView.findViewById(R.id.imgExtraitem1);
//		ImageView imageView2 = (ImageView) convertView.findViewById(R.id.imgStoryitem2);

        txtTitle.setText(itemname.get(position).getTen());
        imageView1.setImageResource(imgid[position]);
//		imageView2.setImageResource(imgid[position]);
        return convertView;
    }

}

