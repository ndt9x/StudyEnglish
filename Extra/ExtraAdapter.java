package com.example.e_learning;

import java.util.ArrayList;
import java.util.List;

import com.example.database.ExtraData;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class ExtraAdapter extends ArrayAdapter<ExtraData> {
	private int resource;
	private Activity context;
	private ArrayList<ExtraData> list;
	Integer[] imgid;

	public ExtraAdapter(Activity context, int resource,
			ArrayList<ExtraData> list) {
		super(context, resource, list);
		this.context = context;
		this.resource = resource;
		this.list = list;
		this.imgid = imgid;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {

			convertView = context.getLayoutInflater().inflate(resource, null);
		}
		ImageButton imgExtraItem = (ImageButton) convertView
				.findViewById(R.id.imgExtraItem);
		TextView tvTittle = (TextView) convertView.findViewById(R.id.tvTittle);
		tvTittle.setText(list.get(position).getTen());
		imgExtraItem.setImageResource(imgid[position]);
		return convertView;
	}
}
