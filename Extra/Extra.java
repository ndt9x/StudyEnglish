package com.example.e_learning;

import java.util.ArrayList;

import com.example.database.ExtraData;
import com.example.database.MySQLiteOpenHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class Extra extends Activity {
	private ArrayList<ExtraData> arrayList = new ArrayList<ExtraData>();
	private ExtraAdapter adapter;
	private ListView lvExtra;
	private MySQLiteOpenHelper database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.extra);
		database = new MySQLiteOpenHelper(this);
		arrayList = database.getAllExtra(); 
		adapter = new ExtraAdapter(this, R.layout.extra_item, arrayList);
		TextView tvExtra = (TextView) findViewById(R.id.tvExtra);
		lvExtra = (ListView) findViewById(R.id.lvExtra);
		lvExtra.setAdapter(adapter);
		lvExtra.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(Extra.this, ExtraLesson.class);
				intent.putExtra("idExtra", position);
				startActivity(intent);
			}
		});
	}
}
