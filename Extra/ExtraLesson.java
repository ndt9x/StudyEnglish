package com.example.e_learning;

import java.util.ArrayList;

import com.example.database.ExtraData;
import com.example.database.MySQLiteOpenHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExtraLesson extends Activity implements OnClickListener {
	private ImageView imgExtra;
	private Button btnPre;
	private ArrayList<ExtraData> arrayList;
	private MySQLiteOpenHelper database;
	private ExtraAdapter adapter;
	private TextView tvExtra_Lesson, tvNoiDung;
	private Bundle bundle;
	private Context context;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.extra_lesson);
		context = this;
		tvExtra_Lesson = (TextView) findViewById(R.id.tvExtra_lesson);
		tvNoiDung = (TextView) findViewById(R.id.tvNoiDung);
		imgExtra = (ImageView) findViewById(R.id.imgExtra);
		btnPre = (Button) findViewById(R.id.btnPre);
		btnPre.setOnClickListener(this);
		database = new MySQLiteOpenHelper(ExtraLesson.this);
		arrayList = database.getAllExtra();
		if (arrayList.size() != 0) {
			bundle = getIntent().getExtras();
			tvExtra_Lesson.setText(arrayList.get(bundle.getInt("idExtra"))
					.getTen());
			tvNoiDung.setText(arrayList.get(bundle.getInt("idExtra"))
					.getNoidung());
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		if (v == btnPre) {
			intent.setClass(this, Extra.class);
			startActivity(intent);
			finish();
		}

	}

	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent();
		intent.setClass(this, Extra.class);
		startActivity(intent);
		finish();
	}
}
