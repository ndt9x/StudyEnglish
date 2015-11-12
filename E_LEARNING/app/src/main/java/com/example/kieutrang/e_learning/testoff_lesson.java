package com.example.kieutrang.e_learning;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.kieutrang.database.MySQLiteOpenHelper;
import com.example.kieutrang.database.Test;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 11/1/2015.
 */
public class testoff_lesson  extends Activity implements View.OnClickListener {
    private Button btTLesson;
    private ListView lvTLesson;
    private MySQLiteOpenHelper database;
    private TextView tvTlesson, tvQues, tvTime;
    private ScrollView scrollView1;
    private RadioButton radioA, radioB, radioC, radioD;
    private RadioGroup radioGroup1;
    private Button btPre, btNext, btSend;
    private ArrayList<Test> arr;
    private ArrayList<TestOffAnswer> arrList;
    private TestOffAdapter adapter;
    private Bundle bundle;
    private Context context;
    int index_question = 0;
    int num_question = 0;
    int time = 0;
    int point = 0;
    String answer;
    int finish = 0;
    CountDownTimer timecount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.test_lesson);
        context = this;
        overridePendingTransition(R.anim.movereturn, 0);
        bundle = getIntent().getExtras();
        database = new MySQLiteOpenHelper(testoff_lesson.this);
        arr = database.getTestLesson(bundle.getString("TestLesson"));
        arrList = new ArrayList<TestOffAnswer>();
        for (int i = 0; i < arr.size(); i++) {
            TestOffAnswer testAns = new TestOffAnswer(arr.get(i).getAnswerTrue(), "",
                    arr.get(i).getId());
            arrList.add(testAns);
        }
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvQues = (TextView) findViewById(R.id.tvQues);
        tvTlesson = (TextView) findViewById(R.id.tvTlesson);
        btPre = (Button) findViewById(R.id.btPre);
        btPre.setOnClickListener(this);
        btNext = (Button) findViewById(R.id.btNext);
        btNext.setOnClickListener(this);
        btSend = (Button) findViewById(R.id.btnSend);
        btSend.setOnClickListener(this);
        lvTLesson = (ListView) findViewById(R.id.lvTLesson);
        radioA = (RadioButton) findViewById(R.id.radioA);
        radioB = (RadioButton) findViewById(R.id.radioB);
        radioC = (RadioButton) findViewById(R.id.radioC);
        radioD = (RadioButton) findViewById(R.id.radioD);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioA.setOnClickListener(this);
        radioB.setOnClickListener(this);
        radioC.setOnClickListener(this);
        radioD.setOnClickListener(this);
        if (arr.size() != 0) {
            tvQues.setText("Question: " + arr.get(0).getQuestion());
            radioA.setText("A: " + arr.get(0).getAnswerA());
            radioB.setText("B: " + arr.get(0).getAnswerB());
            radioC.setText("C: " + arr.get(0).getAnswerC());
            radioD.setText("D: " + arr.get(0).getAnswerD());

        }
        tvTlesson.setText("Question: " + (index_question + 1) + "/10");
        timecount=new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTime.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTime.setText("0");
                nopbai();
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btPre:
                btNext.setVisibility(View.VISIBLE);
                index_question--;
                if (index_question == 0) {
                    btPre.setVisibility(View.GONE);
                }

                tvQues.setText("Question: "
                        + arr.get(index_question).getQuestion());
                if (finish == 0) {
                    radioA.setText("A: " + arr.get(index_question).getAnswerA());
                    radioB.setText("B: " + arr.get(index_question).getAnswerB());
                    radioC.setText("C: " + arr.get(index_question).getAnswerC());
                    radioD.setText("D: " + arr.get(index_question).getAnswerD());
                }else{
                    if(arr.get(index_question).getAnswerA().equals(arrList.get(index_question).getAnswer())){
                        radioA.setTextColor(getResources().getColor(R.color.red));
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioD.setTextColor(getResources().getColor(R.color.black));
                    }if(arr.get(index_question).getAnswerB().equals(arrList.get(index_question).getAnswer())){
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioB.setTextColor(getResources().getColor(R.color.red));
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioD.setTextColor(getResources().getColor(R.color.black));
                    }
                    if(arr.get(index_question).getAnswerC().equals(arrList.get(index_question).getAnswer())){
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioC.setTextColor(getResources().getColor(R.color.red));
                        radioD.setTextColor(getResources().getColor(R.color.black));
                    }
                    if(arr.get(index_question).getAnswerD().equals(arrList.get(index_question).getAnswer())){
                        radioD.setTextColor(getResources().getColor(R.color.black));
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioD.setTextColor(getResources().getColor(R.color.red));
                    }
                }
                if (arrList.get(index_question).getMyanswer().equals("")) {
                    radioGroup1.clearCheck();
                } else {
                    checkAnswer();

                }
                tvTlesson.setText("Question: " + (index_question + 1) + "/10");
                break;
            case R.id.btNext:
                index_question++;
                btPre.setVisibility(View.VISIBLE);
                if (index_question == 9) {
                    btNext.setVisibility(View.GONE);
                }
                tvQues.setText("Question: " + arr.get(index_question).getQuestion());
                if (finish == 0) {
                    radioA.setText("A: " + arr.get(index_question).getAnswerA());
                    radioB.setText("B: " + arr.get(index_question).getAnswerB());
                    radioC.setText("C: " + arr.get(index_question).getAnswerC());
                    radioD.setText("D: " + arr.get(index_question).getAnswerD());
                }else{
                    if(arr.get(index_question).getAnswerA().equals(arrList.get(index_question).getAnswer())){
                        radioA.setTextColor(getResources().getColor(R.color.red));
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioD.setTextColor(getResources().getColor(R.color.black));
                    }if(arr.get(index_question).getAnswerB().equals(arrList.get(index_question).getAnswer())){
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioB.setTextColor(getResources().getColor(R.color.red));
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioD.setTextColor(getResources().getColor(R.color.black));
                    }
                    if(arr.get(index_question).getAnswerC().equals(arrList.get(index_question).getAnswer())){
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioC.setTextColor(getResources().getColor(R.color.red));
                        radioD.setTextColor(getResources().getColor(R.color.black));
                    }
                    if(arr.get(index_question).getAnswerD().equals(arrList.get(index_question).getAnswer())){
                        radioD.setTextColor(getResources().getColor(R.color.black));
                        radioB.setTextColor(getResources().getColor(R.color.black));
                        radioC.setTextColor(getResources().getColor(R.color.black));
                        radioD.setTextColor(getResources().getColor(R.color.red));
                    }
                }
                if (arrList.get(index_question).getMyanswer().equals("")) {
                    radioGroup1.clearCheck();

                } else {
                    checkAnswer();

                }
                tvTlesson.setText("Question: " + (index_question + 1) + "/10");
                break;
            case R.id.btnSend:
                nopbai();
                break;
            case R.id.radioA:
                arrList.get(index_question).setMyanswer("A");
                break;
            case R.id.radioB:
                arrList.get(index_question).setMyanswer("B");
                break;
            case R.id.radioC:
                arrList.get(index_question).setMyanswer("C");
                break;
            case R.id.radioD:
                arrList.get(index_question).setMyanswer("D");
                break;
            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
        arr=null;
        arrList=null;
        Intent intent = new Intent();
        intent.setClass(this, test_offline.class);
        startActivity(intent);
        finish();

    }

    public void checkAnswer() {
        if (arrList.get(index_question).getMyanswer().equals("A")) {
            // Log.d("ASD",arrList.get(index_question).getMyanswer().equals("A")+"");
            Log.d("ASD", arrList.get(index_question).getMyanswer() + "");
            radioA.setChecked(true);
        }
        if (arrList.get(index_question).getMyanswer().equals("B")) {
            radioB.setChecked(true);
        }
        if (arrList.get(index_question).getMyanswer().equals("C")) {
            radioC.setChecked(true);
        }
        if (arrList.get(index_question).getMyanswer().equals("D")) {
            radioD.setChecked(true);
        }
    }

    private void nopbai() {
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i).getMyanswer().equals("")) {
                answer = "";
            }
            if (arrList.get(i).getMyanswer().equals("A")) {
                answer = arr.get(i).getAnswerA();
            }
            if (arrList.get(i).getMyanswer().equals("B")) {
                answer = arr.get(i).getAnswerB();
            }
            if (arrList.get(i).getMyanswer().equals("C")) {
                answer = arr.get(i).getAnswerC();
            }
            if (arrList.get(i).getMyanswer().equals("D")) {
                answer = arr.get(i).getAnswerD();
            }
            if (answer.equals(arrList.get(i).getAnswer())) {
                point++;

            }

        }
        showDialogResult();
        btSend.setVisibility(View.GONE);
        timecount.cancel();
        finish = 1;

    }
    private void showDialogResult(){
        final Dialog dialog = new Dialog(testoff_lesson.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.test_result);

        TextView text = (TextView) dialog.findViewById(R.id.tvRes);
        text.setText("Your Score: "+point*10);
        TextView textTrue = (TextView) dialog.findViewById(R.id.tvTrue);
        textTrue.setText(""+point);
        TextView textFalse = (TextView) dialog.findViewById(R.id.tvFalse);
        textFalse.setText(""+(10-point));
        Button dialogButton = (Button) dialog.findViewById(R.id.btRev);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

