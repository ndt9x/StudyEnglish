package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kieutrang.database.Extra;
import com.example.kieutrang.database.MySQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 10/30/2015.
 */
public class extra_lesson extends Activity implements View.OnClickListener{

        private TextView tvExtra_lesson, tvVol, tvTest, tvExer, tvStory, tvExtra_content;
    private Button previous;
    private ImageView imgvol, imgSLexer, imgstory, imgSLtest,imgS;
    private MySQLiteOpenHelper database;
    private ArrayList<Extra> arr;
    private Bundle bundle;
    private ExtraAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra_lesson);
        context =  this;
        overridePendingTransition(R.anim.movereturn,0);
        imgvol = (ImageView)findViewById(R.id.imgELvol);
        imgvol.setOnClickListener(this);
        imgSLexer = (ImageView)findViewById(R.id.imgELexer);
        imgSLexer.setOnClickListener(this);
        imgSLtest = (ImageView)findViewById(R.id.imgELtest);
        imgSLtest.setOnClickListener(this);
        tvExtra_content = (TextView)findViewById(R.id.tvExtra_content);
        tvExtra_lesson = (TextView)findViewById(R.id.tvExtra_lesson);
        imgstory = (ImageView)findViewById(R.id.imgELextra);
        imgstory.setOnClickListener(this);
        imgS=(ImageView)findViewById(R.id.imgE);
        String image="icon4";
        int drawableResourceId = this.getResources().getIdentifier(image, "drawable", this.getPackageName());
        imgS.setImageResource(drawableResourceId);
        previous = (Button)findViewById(R.id.previous);
        previous.setOnClickListener(this);
        database=new MySQLiteOpenHelper(extra_lesson.this);
        arr= database.getAllExtra();
        if (arr.size()!=0) {
            bundle = getIntent().getExtras();
            tvExtra_lesson.setText(arr.get(bundle.getInt("idStory")).getTen());
            tvExtra_content.setText(arr.get(bundle.getInt("idStory")).getNoidung());
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.previous:
                intent.setClass(this, extra.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imgELvol:
                intent.setClass(this, vocabulary.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imgELtest:
                intent.setClass(this, test_english.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imgELexer:
                intent.setClass(this, exercise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imgELextra:
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
        intent.setClass(this, extra.class);
        startActivity(intent);
        finish();
    }

}

