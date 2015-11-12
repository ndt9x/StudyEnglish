package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kieutrang.database.Extra;
import com.example.kieutrang.database.MySQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 10/30/2015.
 */
public class extra extends Activity implements View.OnClickListener{

    private ImageView img_EVol, img_EExer, img_ETest, img_EExtra;
    private TextView tvEExer, tvEVol, tvETest, tvEExtra, tvEBook;
    private ListView lvSLesson;
    private ArrayList<Extra> arrList = new ArrayList<Extra>();
    private ExtraAdapter adapter;
    private Context context;

    private MySQLiteOpenHelper database;
    Integer[] imgid={
            R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8,
            R.drawable.img9, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
            R.drawable.img13, R.drawable.img1,
            R.drawable.img2,  R.drawable.img3,
            R.drawable.img4, R.drawable.img5,
            R.drawable.img6, R.drawable.img7,
            R.drawable.img8, R.drawable.img9,
            R.drawable.img10, R.drawable.img11,
            R.drawable.img12, R.drawable.img13
    };
    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra);

        database = new MySQLiteOpenHelper(this);
        arrList= database.getAllExtra();
        overridePendingTransition(R.anim.movereturn,0);
        img_EVol = (ImageView) findViewById(R.id.img_EVol);
        img_EVol.setOnClickListener(this);
        img_ETest = (ImageView) findViewById(R.id.img_ETest);
        img_ETest.setOnClickListener(this);
        img_EExer = (ImageView) findViewById(R.id.img_EExer);
        img_EExer.setOnClickListener(this);
        img_EExtra = (ImageView) findViewById(R.id.img_EExtra);
        img_EExtra.setOnClickListener(this);
        tvEExer = (TextView) findViewById(R.id.tvEExer);
        tvEVol = (TextView) findViewById(R.id.tvEVol);
        tvETest = (TextView) findViewById(R.id.tvETest);
        tvEExtra = (TextView) findViewById(R.id.tvEExtra);
        tvEBook = (TextView) findViewById(R.id.tvEExtra);
        adapter=new ExtraAdapter(this, arrList, imgid, R.layout.extra_item);
        lvSLesson=(ListView)findViewById(R.id.lvELesson);
        lvSLesson.setAdapter(adapter);
        lvSLesson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent=new Intent(extra.this,extra_lesson.class);
                intent.putExtra("idStory", position);
                startActivity(intent);

            }
        });


    };

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.img_EVol:
                intent.setClass(this, vocabulary.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_EExer:
                intent.setClass(this, exercise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_ETest:
                intent.setClass(this, test_english.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_EExtra:
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
        intent.setClass(this,E_Learning.class);
        startActivity(intent);
        finish();
    }
}
