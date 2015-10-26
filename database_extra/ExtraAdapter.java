package com.example.database;

import java.util.ArrayList;
import java.util.List;

import com.example.e_learning.R;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ExtraAdapter extends ArrayAdapter<ExtraData> {
	private ArrayList<ExtraData> arrayList;
	// private ExtraData entity;
	private Activity context;
	int resource;

	public ExtraAdapter(Activity context, int resource,
			ArrayList<ExtraData> arrayList) {
		super(context, resource, arrayList);
		this.arrayList = arrayList;
		this.context = context;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = context.getLayoutInflater().inflate(resource, null);
		TextView tvNoidung = (TextView) convertView
				.findViewById(R.id.tvNoiDung);
		tvNoidung.setText(arrayList.get(position).getNoidung());
		return convertView;
	}
}
