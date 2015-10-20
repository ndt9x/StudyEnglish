package com.example.e_learning;

import java.util.ArrayList;
import java.util.Locale;

import com.example.database.*;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class vol_lesson extends ActionBarActivity implements OnInitListener, OnClickListener {
	private Button btVLesson;
	private TextView tvVlesson ;
	private Context context;
	private ListView lvVLesson;
	private MySQLiteOpenHelper database;
	private ArrayList<Vocabulary> arr;
	private VocabularyAdapter adapter;
	private Bundle bundle;
	private TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vol_lesson);
		context = this;
		
		bundle=getIntent().getExtras();
		lvVLesson=(ListView)findViewById(R.id.lvVLesson);
		database=new MySQLiteOpenHelper(vol_lesson.this);
		btVLesson = (Button)findViewById(R.id.btVlesson);
		btVLesson.setOnClickListener(this);
		tvVlesson = (TextView)findViewById(R.id.tvvol_lesson);
		tvVlesson.setText(bundle.getString("lesson"));
		arr=database.getvocabulary(bundle.getString("lesson"));
		fillData();
		tts = new TextToSpeech(this, this);
		lvVLesson.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				speakOut(arr.get(position).getTenchu());
			}
		});
	}
	
	
private void speakOut(String string) {

		String text = string;

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
}
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btVlesson:
			intent.setClass(this, vocabulary.class);
			startActivity(intent);
		default:
			break;
		}
	}
		
		void fillData(){
			arr=database.getvocabulary(bundle.getString("lesson"));
			if(arr!=null){
				adapter = new VocabularyAdapter(arr, this, R.layout.vollesson_item);
				lvVLesson.setAdapter(adapter);
			}
			for (int i = 0; i < arr.size(); i++) {
				Log.d("test",arr.get(i).toString());
			}
		}
		
		public void onInit(int status) {
	 
	        if (status == TextToSpeech.SUCCESS) {
	 
	            int result = tts.setLanguage(Locale.US);
	 
	            if (result == TextToSpeech.LANG_MISSING_DATA
	                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
	                Log.e("TTS", "This Language is not supported");
	            } else {
	              
	              
	            }
	 
	        } else {
	            Log.e("TTS", "Initilization Failed!");
	        }
	 
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vol_lesson, menu);
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
		intent.setClass(this, vocabulary.class);
		startActivity(intent);
		finish();
	}
}
