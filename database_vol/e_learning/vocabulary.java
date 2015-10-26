package com.example.e_learning;

import java.util.ArrayList;

import com.example.database.MySQLiteOpenHelper;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class vocabulary extends ActionBarActivity implements android.view.View.OnClickListener {

	private ImageView img_Vvol;
	private TextView tvVVocabulary;
	private Context context;
	private ListView lvVol;
	private ArrayList<String> arrList=new ArrayList<String>();
	private VolAdapter adapter;
	private MySQLiteOpenHelper database;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vocabulary);
		database=new MySQLiteOpenHelper(this);
		arrList=database.getAllLesson();
		lvVol=(ListView) findViewById(R.id.lvVol);
		adapter=new VolAdapter(this, R.layout.vol_item, arrList);
		lvVol.setAdapter(adapter);
		img_Vvol=(ImageView)findViewById(R.id.img_Vvol);
		
		img_Vvol.setOnClickListener(this);
		
		lvVol.setOnItemClickListener(new OnItemClickListener() {
		
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(vocabulary.this,vol_lesson.class);
				intent.putExtra("lesson", arrList.get(position));
				startActivity(intent);
				finish();
			}
		});
			
		}
		public void onClick(View v) {
				Intent intent = new Intent();
				switch (v.getId()) {
				case R.id.img_Vvol:
					intent.setClass(this, vocabulary.class);
					startActivity(intent);
					finish();
					break;
				case R.id.img_Eexer:
					intent.setClass(this, exercise.class);
					startActivity(intent);
					finish();
					break;
				default:
					break;
		}
		
		}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vocabulary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent();
		intent.setClass(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
