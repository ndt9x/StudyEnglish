package com.example.e_learning;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import com.example.database.MySQLiteOpenHelper;
import com.example.database.Vocabulary;

import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class exercise extends Activity implements OnClickListener,TextToSpeech.OnInitListener{

	private ImageView img_Evol, img_Etest, img_Eexer, img_Estory;
	private TextView tvStory, tvExer, tvEtest, tvVol, tvInfo, tvGuide;
	private Button btSpk, btCheck, btNext, btAns;
	private EditText edExercise;
	private Context context;
	private MySQLiteOpenHelper database;
	private ArrayList<Vocabulary> arr;
	Random random;
	int question;
	Boolean Ans;
	private TextToSpeech tts;
	String questions;
	
	@Override
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//overridePendingTransition(R.anim.move,R.anim.movereturn);
		setContentView(R.layout.exercise);
		context = this;
		database=new MySQLiteOpenHelper(this);
		random=new Random();
		arr=database.getAllVol();
		tts = new TextToSpeech(this, this);
//		img_Evol = (ImageView)findViewById(R.id.img_Evol);
//		img_Evol.setOnClickListener(this);
//		img_Etest = (ImageView)findViewById(R.id.img_Etest);
//		img_Etest.setOnClickListener(this);
		img_Eexer = (ImageView)findViewById(R.id.img_Eexer);
		img_Eexer.setOnClickListener(this);
//		img_Estory = (ImageView)findViewById(R.id.img_Estory);
//		img_Estory.setOnClickListener(this);
		tvInfo = (TextView)findViewById(R.id.tvInfo);
//		tvStory = (TextView)findViewById(R.id.tvEStory);
		tvExer = (TextView)findViewById(R.id.tvExer);
//		tvEtest = (TextView)findViewById(R.id.tvEtest);
//		tvVol = (TextView)findViewById(R.id.tvvol);
		tvExer = (TextView)findViewById(R.id.tvExer);
		tvGuide =(TextView)findViewById(R.id.tvGuide);
		edExercise = (EditText)findViewById(R.id.edExercise);
		btCheck = (Button)findViewById(R.id.btCheck);
		btCheck.setOnClickListener(this);
		//tvResult = (TextView)findViewById(R.id.tvResult);
		btSpk = (Button)findViewById(R.id.btSpeaker);
		btSpk.setOnClickListener(this);
		btAns = (Button)findViewById(R.id.btAns);
		btAns.setOnClickListener(this);
		randomSpeakout();
		Ans=true;
		
		
	};
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.img_Evol:
			intent.setClass(this, vocabulary.class);
			startActivity(intent);
			finish();
			break;
		case R.id.img_Eexer:
			intent.setClass(this, exercise.class);
			startActivity(intent);
			finish();
			break;
		case R.id.btCheck:
			if (!edExercise.getText().equals("")) {
				if (edExercise.getText().toString().equals(questions)) {
					tvInfo.setText("Correct!!");
				}
				else {
					tvInfo.setText("False! Try again");
					edExercise.setText("");
					edExercise.setFocusable(true);
				}
			}
			break;
		case R.id.btSpeaker:
			speakOut(questions);
			break;
		case R.id.btAns:
			if (!Ans) {
				btAns.setText("Answer");
				btCheck.setEnabled(true);
				randomSpeakout();
				speakOut(questions);
				Ans=true;
				edExercise.setText("");
				edExercise.setFocusable(true);
			}
			else{
				btAns.setText("Next");
				btCheck.setEnabled(false);
				edExercise.setText(questions);
				Ans=false;
			}
			break;
		default:
			break;
		}
		
	}
	void randomSpeakout(){
		if(arr.size()!=0){
			question=random.nextInt(arr.size());
			questions=arr.get(question).getTenchu();
		}
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent();
		intent.setClass(this,MainActivity.class);
		startActivity(intent);
		finish();
	}
	
	@Override
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
	  private void speakOut(String string) {
		  
	        String text = string;
	 
	        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	    }
}
