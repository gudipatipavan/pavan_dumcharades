package com.dumexample.dumcharades;

import java.util.concurrent.TimeUnit;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class Dumcharades4 extends Activity {
	Button start,stop;
	TextView textViewTime;
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dumcharades4);
		 start=(Button)findViewById(R.id.button1);
		 stop=(Button)findViewById(R.id.button2);
		 mp =MediaPlayer.create(this,R.raw.so);
		textViewTime=(TextView)findViewById(R.id.textViewTime);
		textViewTime.setText("00:01:00");
		final CounterClass timer= new CounterClass(60000,1000);
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timer.start();
				mp.start();
			}
		});
		
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timer.cancel();
				mp.pause();
			}
		});
	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	public class CounterClass extends CountDownTimer{

		public CounterClass(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}
		@SuppressLint ("NewApi")
		@TargetApi(Build.VERSION_CODES.GINGERBREAD)
		@Override
		public void onTick(long millisUntilFinished) {
			// TODO Auto-generated method stub
			long millis =millisUntilFinished;
			String hms=String.format("%02d:%02d:%02d",TimeUnit.MILLISECONDS.toHours(millis),
					TimeUnit.MILLISECONDS.toMinutes(millis)-TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
					TimeUnit.MILLISECONDS.toSeconds(millis)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			
		System.out.println(hms);
		textViewTime.setText(hms);
			
		}
		@SuppressLint("NewApi")
		@TargetApi(Build.VERSION_CODES.GINGERBREAD)

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			textViewTime.setText("Completed.");			
		}
		
	}

}
