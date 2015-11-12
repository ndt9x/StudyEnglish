package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kieutrang.database.MySQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 11/1/2015.
 */
public class test_offline extends Activity implements View.OnClickListener {
    private ImageView img_TVol, img_TExer, img_TTest, img_TExtra;
    private TextView tvTExer, tvTVol, tvTTest, tvTtest, tvTextra;
    private ListView lvTLesson;
    private Context context;
    private ArrayList<String> arrList = new ArrayList<String>();
    private TestOffAdapter adapter;
    private MySQLiteOpenHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_offline);
        context = this;
        database = new MySQLiteOpenHelper(this);
        overridePendingTransition(R.anim.movereturn, 0);
        img_TVol = (ImageView) findViewById(R.id.img_TVol);
        img_TVol.setOnClickListener(this);
        img_TExtra = (ImageView) findViewById(R.id.img_TExtra);
        img_TExtra.setOnClickListener(this);
        img_TExer = (ImageView) findViewById(R.id.img_TExer);
        img_TExer.setOnClickListener(this);
        img_TTest = (ImageView) findViewById(R.id.img_TTest);
        img_TTest.setOnClickListener(this);
        tvTtest = (TextView) findViewById(R.id.tvTtest);
        tvTExer = (TextView) findViewById(R.id.tvTExer);
        tvTVol = (TextView) findViewById(R.id.tvTVol);
        tvTextra = (TextView) findViewById(R.id.tvTExtra);
        tvTTest = (TextView) findViewById(R.id.tvTTest);
        arrList = database.getAllTestLesson();
        lvTLesson = (ListView) findViewById(R.id.lvTLesson);
        arrList=database.getAllTestLesson();
        lvTLesson = (ListView)findViewById(R.id.lvTLesson);
        adapter=new TestOffAdapter(this, arrList, R.layout.test_item);
        lvTLesson.setAdapter(adapter);
        lvTLesson.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent=new Intent(test_offline.this,testoff_lesson.class);
                intent.putExtra("TestLesson", arrList.get(position));
                startActivity(intent);

            }
        });

    };


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.img_TVol:
                intent.setClass(this, vocabulary.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_TExer:
                intent.setClass(this, exercise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_TTest:
                intent.setClass(this, test_english.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_TExtra:
                intent.setClass(this, extra.class);
                startActivity(intent);
                finish();
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


