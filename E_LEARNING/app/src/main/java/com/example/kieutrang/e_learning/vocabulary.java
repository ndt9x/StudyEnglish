package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kieutrang.database.MySQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 11/1/2015.
 */
public class vocabulary extends Activity implements View.OnClickListener {
    private ImageView img_Vvol, img_Vtest, img_Vexer, img_Vextra;
    private TextView tvVvocabulary, tvVexer, tvVextra, tvVtest, tvVvol;
    private Context context;
    private ListView lvVol;
    private ArrayList<String> arrayList = new ArrayList<String>();
    private VolAdapter adapter;
    private MySQLiteOpenHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabulary);
        overridePendingTransition(R.anim.move, R.anim.movereturn);
        database = new MySQLiteOpenHelper(this);
        arrayList = database.getAllLesson();
        lvVol = (ListView) findViewById(R.id.lvVol);
        adapter = new VolAdapter(this, R.layout.vol_item, arrayList);
        lvVol.setAdapter(adapter);
        img_Vvol = (ImageView) findViewById(R.id.img_Vvol);
        img_Vvol.setOnClickListener(this);
        img_Vexer = (ImageView) findViewById(R.id.img_Vexer);
        img_Vexer.setOnClickListener(this);
        img_Vextra = (ImageView) findViewById(R.id.img_Vextra);
        img_Vextra.setOnClickListener(this);
        img_Vtest = (ImageView) findViewById(R.id.img_Vtest);
        img_Vtest.setOnClickListener(this);
        tvVvocabulary = (TextView) findViewById(R.id.tvVVocabulary);
        tvVexer = (TextView) findViewById(R.id.tvVexer);
        tvVextra = (TextView) findViewById(R.id.tvVExtra);
        lvVol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(vocabulary.this, vol_lesson.class);
                intent.putExtra("lesson", arrayList.get(position));
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.img_Vvol:
                intent.setClass(this, vocabulary.class);
                startActivity(intent);
                finish();
                finish();
                break;
            case R.id.img_Vexer:
                intent.setClass(this, exercise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_Vtest:
                intent.setClass(this, test_english.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_Vextra:
                intent.setClass(this, extra.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent intent = new Intent();
        intent.setClass(this, E_Learning.class);
        startActivity(intent);
        finish();
    }
}