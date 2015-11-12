package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KieuTrang on 11/1/2015.
 */
public class test_english extends Activity implements View.OnClickListener {
    private TextView tvTtest, tvTOnline, tvTOffline, tvTVol, tvTExer, tvTTest, tvTExtra;
    private ImageButton imgTOnline, imgTOffline;
    private ImageView img_TVol, img_TExer, img_TTest, img_TExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        tvTExer = (TextView) findViewById(R.id.tvTExer);
        tvTOffline = (TextView) findViewById(R.id.tvTOffline);
        tvTOnline = (TextView) findViewById(R.id.tvTOnline);
        tvTtest = (TextView) findViewById(R.id.tvTtest);
        tvTVol = (TextView) findViewById(R.id.tvTVol);
        tvTExer = (TextView) findViewById(R.id.tvTExer);
        tvTTest = (TextView) findViewById(R.id.tvTTest);
        tvTExtra = (TextView) findViewById(R.id.tvTExtra);
        imgTOnline = (ImageButton) findViewById(R.id.imgTOnline);
        imgTOnline.setOnClickListener(this);
        imgTOffline = (ImageButton) findViewById(R.id.imgTOffline);
        imgTOffline.setOnClickListener(this);
        img_TVol = (ImageView) findViewById(R.id.img_TVol);
        img_TVol.setOnClickListener(this);
        img_TExer = (ImageView) findViewById(R.id.img_TExer);
        img_TExer.setOnClickListener(this);
        img_TTest = (ImageView) findViewById(R.id.img_TTest);
        img_TTest.setOnClickListener(this);
        img_TExtra = (ImageView) findViewById(R.id.img_TExtra);
        img_TExtra.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.imgTOnline:
                intent = new Intent(this, test_online.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imgTOffline:
                intent = new Intent(this, test_offline.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_TVol:
                intent = new Intent(this, vocabulary.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_TExer:
                intent = new Intent(this, exercise.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_TTest:
                intent = new Intent(this, test_online.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_TExtra:
                intent = new Intent(this, extra.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
